package com.regedw.PractFinalFront.servicios;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class CompraJRDataSource implements JRDataSource {


    private CompraServices compraServices;
    private int indice = -1;

    CompraJRDataSource(CompraServices compraServices) {
        this.compraServices = compraServices;
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < compraServices.buscarTodos().size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object tmp = "";
        //si la propiedad no existe en el objeto la busco.
        switch (jrField.getName()) {
            case "cliente":
                tmp = compraServices.buscarTodos().get(indice).getCliente().toString();
                break;
            case "fecha":
                tmp = compraServices.buscarTodos().get(indice).getFecha();
                break;
            case "monto":
                tmp = compraServices.buscarTodos().get(indice).getTotal();
                break;
            case "articulos":
                tmp = compraServices.buscarTodos().get(indice).getPaquetes().size();
                break;
        }

        System.out.println("La consulta campo:" + jrField.getName() + " valor: " + tmp.toString());
        return tmp;
    }


}