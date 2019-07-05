package com.abcsoft.restpolloloko.model;

public class Producto {

    private String categoria;
    private Integer codigo;
    private Boolean descatalogado;
    private String descripcion;
    private String fechaAlta;
    private String nombre;
    private Double precio;

    public Producto() {
    }

//    public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getDescatalogado() {
        return descatalogado;
    }

    public void setDescatalogado(Boolean descatalogado) {
        this.descatalogado = descatalogado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "categoria=" + categoria +
                ", codigo=" + codigo +
                ", descatalogado=" + descatalogado +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}


