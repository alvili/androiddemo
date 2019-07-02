package com.abcsoft.medicdata.model;


import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LecturaServicesSQLite implements LecturaServices {

    private static Context contexto;
    private DatabaseHelper myDB;
    private static final Map<Integer,Lectura> LECTURAS;
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    private static final LecturaServicesSQLite INSTANCE = new LecturaServicesSQLite(contexto);

    static {
        LECTURAS = new TreeMap<>();
    }

    public LecturaServicesSQLite(Context contexto) {
        this.contexto = contexto;
        //Creo la bbdd
        myDB = new DatabaseHelper(contexto,1);
    }

//    public static LecturaServicesSQLite getInstance(){
//        return INSTANCE;
//    }

    @Override
    public Lectura create(Lectura lectura) {

        //La nueva lectura no tiene código. El codigo lo genera la inserción a la bbdd
        //myDB.insertData(lectura);
        //Integer newCode = myDB.maxCodigo();
        Integer newCode = myDB.insertData(lectura);
        lectura.setCodigo(newCode);
        return LECTURAS.put(newCode, lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        return null;
    }

    @Override
    public Lectura update(Lectura lectura) {
        return null;
    }

    @Override
    public boolean delete(Integer codigo) {
        return false;
    }

    @Override
    public List<Lectura> getAll() {
        for (Lectura lec : myDB.getAll()){
            LECTURAS.put(lec.getCodigo(), lec);
        }

        return myDB.getAll();
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2){

        //Pedir todos los registros e iterarlos es ineficiente.
        //La solucion buena es mediante el motor del sql, mucho mas optima y no devuelve información que no queremos

            List<Lectura> lecturasFiltradas = new ArrayList<>();

            for(Lectura lectura : myDB.getAll()){
                if (lectura.getFechaHora().after(fecha1) && lectura.getFechaHora().before(fecha2)){
                    lecturasFiltradas.add(lectura);
                }
            }
            return lecturasFiltradas;
    }
}