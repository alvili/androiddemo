package com.abcsoft.restpolloloko.model;

public class Camarero {

    private Integer codigo;
    private String nombre;

    public Camarero() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Camarero{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
