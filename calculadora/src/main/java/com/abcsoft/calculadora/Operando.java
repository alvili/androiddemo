package com.abcsoft.calculadora;

import java.text.DecimalFormat;

public class Operando {

    private String valorDigitos;
    private Double valor;

    public Operando() {
        valorDigitos = "";
        valor = 0.0;
    }

    public Operando(String valorDigitos) {
        this.valorDigitos = valorDigitos;
        this.valor = strToDouble(valorDigitos);
    }

    public Operando(String valorDigitos, Double valor) {
        super();
        this.valorDigitos = valorDigitos;
        this.valor = valor;
    }

    public void addDigit(String NewChar) {
        this.valorDigitos = this.valorDigitos + NewChar;
        this.valor = strToDouble(valorDigitos);
    }

    public void removeDigit() {

//        if (this.valorDigitos != null && this.valorDigitos.length() > 0 && this.valorDigitos.charAt(this.valorDigitos.length() - 1) == 'x') {
        if (this.valorDigitos != null & this.valorDigitos.length() > 0 ) {
            this.valorDigitos = this.valorDigitos.substring(0, this.valorDigitos.length() - 1);
        }
        //TODO mirar com fer-ho amb regex
        //this.valorDigitos.replaceFirst(".$","");

        //TODO que passa amb strings buides??
        this.valor = strToDouble(valorDigitos);
    }

    public void reset() {
        //Vacio el contenido actual
        this.valorDigitos = "";
        this.valor = 0.0;
    }

    public String getValorDigitos() {
        return this.valorDigitos;
    }

    public void setValorDigitos(String valorDigitos) {
        this.valorDigitos = valorDigitos;
        this.valor = strToDouble(valorDigitos);
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
        this.valorDigitos = dblToString(valor);
    }

    @Override
    public String toString() {
//        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(this.valor);
    }

    private String dblToString(double valor){
//        return Double.toString(valor);
        return String.valueOf(valor);
    }

    private double strToDouble(String valorDigitos){
        return Double.parseDouble(valorDigitos);
    }



}
