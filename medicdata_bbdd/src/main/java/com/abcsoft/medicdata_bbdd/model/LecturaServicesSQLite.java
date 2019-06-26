package com.abcsoft.medicdata_bbdd.model;


import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LecturaServicesSQLite implements LecturaServices {

    private static Context contexto;
    private DatabaseHelper myDB;
    private static final Map<Integer,Lectura> LECTURAS;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    private static final LecturaServicesSQLite INSTANCE = new LecturaServicesSQLite(contexto);

    static {
        LECTURAS = new TreeMap<>();
    }

    public LecturaServicesSQLite(Context contexto) {
        this.contexto = contexto;
        //Creo la bbdd
        myDB = new DatabaseHelper(contexto);
    }

//    public static LecturaServicesSQLite getInstance(){
//        return INSTANCE;
//    }

    @Override
    public Lectura create(Lectura lectura) {

        //La nueva lectura no tiene código
        myDB.insertData(
                lectura.getFechaHora(),
                lectura.getPeso(),
                lectura.getDiastolica(),
                lectura.getSistolica(),
                lectura.getLongitud(),
                lectura.getLatitud()
        );
        Integer newCode = myDB.maxCodigo();
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

        Cursor cursor = myDB.getAll();
        Lectura lectura;

        if (cursor.getCount() == 0) {
            return null;
        }

        while (cursor.moveToNext()) {
            Integer codigo = cursor.getInt(0);
            Date fechaHora = null;
            try {
                fechaHora = sdf.parse(cursor.getString(1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Double peso = cursor.getDouble(2);
            Double diastolica = cursor.getDouble(3);
            Double sistolica = cursor.getDouble(4);
            Double longitud = cursor.getDouble(5);
            Double latitud = cursor.getDouble(6);

            lectura = new Lectura(fechaHora, peso, diastolica, sistolica, longitud, latitud);
            LECTURAS.put(codigo, lectura);
        }
        return new ArrayList<Lectura>(LECTURAS.values());
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2){
            List<Lectura> lecturas = new ArrayList<>();

            for(Lectura lectura:getAll()){
                if (lectura.getFechaHora().after(fecha1) && lectura.getFechaHora().before(fecha2)){
                    lecturas.add(lectura);
                }
            }
            return lecturas;
    }
}