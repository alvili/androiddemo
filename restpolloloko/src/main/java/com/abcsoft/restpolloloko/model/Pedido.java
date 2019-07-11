package com.abcsoft.restpolloloko.model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private Camarero camarero;
    private Date fecha;
    private Integer id;
    private List<LineaPedido> lineasPedido;
    private Integer mesa;

    public Pedido() {
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "camarero=" + camarero +
                ", fecha=" + fecha +
                ", id=" + id +
                ", lineasPedido=" + lineasPedido +
                ", mesa=" + mesa +
                '}';
    }
}
