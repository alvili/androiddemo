package com.abcsoft.calculadora;

public class Operando {

    private String ValorDigitos;
    private Double Valor;

    public Operando() {
        super();
        ValorDigitos = "";
        Valor = 0.0;
    }

    public Operando(String valorDigitos, Double valor) {
        super();
        ValorDigitos = valorDigitos;
        Valor = valor;
    }

    public Double AsDouble() {
        return Double.parseDouble(ValorDigitos);
    }

    public void AddDigit(String NewChar) {
        ValorDigitos = ValorDigitos + NewChar;
    }

    public void Reset() {
        //Vacio el contenido actual
        ValorDigitos = "";
        Valor = 0.0;
    }

    public String getValorDigitos() {
        return ValorDigitos;
    }

    public void setValorDigitos(String valorDigitos) {
        ValorDigitos = valorDigitos;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    @Override
    public String toString() {
        return "ValorDigitos";
    }



}
