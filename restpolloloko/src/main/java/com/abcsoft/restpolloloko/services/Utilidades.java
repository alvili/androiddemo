package com.abcsoft.restpolloloko.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public String getStringFromDate(Date date){
        return sdf.format(date);
    }

    public Date getDateFromString(String string){
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Devuelve un nombre aleatorio basado en un rango
    public String nombreAleatorio(int rango){
        int c = (int) (Math.random()*rango);
        return String.valueOf(c);

    }

}
