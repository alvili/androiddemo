package com.abcsoft.restpolloloko.model;

public class LineaPedido {
    private Integer cantidad;
    private Double precio;
    private Producto producto;

    public LineaPedido() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "cantidad=" + cantidad +
                ", precio=" + precio +
                ", producto=" + producto +
                '}';
    }
}
