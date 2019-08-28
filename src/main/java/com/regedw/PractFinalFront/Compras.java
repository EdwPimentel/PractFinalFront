package com.regedw.PractFinalFront;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compras implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private Date fecha;

    private double total;

    @ElementCollection
    private List<Producto> paquetes;

    private Long cliente;

    private Long empleado;

    private Date fechaInicio;

    private Date fechaFinal;

    private String estado;

    public Compras(Date fecha, double total, List<Producto> paquetes, Long cliente, Long empleado, Date fechaInicio, Date fechaFinal, String estado) {
        this.fecha = fecha;
        this.total = total;
        this.paquetes = paquetes;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Producto> paquetes) {
        this.paquetes = paquetes;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}