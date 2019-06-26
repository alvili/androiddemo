package com.abcsoft.medicdata_bbdd.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    //Nombre de la bbdd
    public static final String DATABASE_NAME = "medicdata.db";

    //Nombre de la tabla
    public static final String TABLE_NAME = "LECTURAS";

    //Columnas de la tabla
    //Se recomienda usar mayusculas para los nombres de la tabla para diferenciarlos de Java. No son case sensitive
    public static final String COL_1_TAG ="CODIGO";
    public static final String COL_2_TAG ="FECHAHORA";
    public static final String COL_3_TAG ="PESO";
    public static final String COL_4_TAG ="DIASTOLICA";
    public static final String COL_5_TAG ="SISTOLICA";
    public static final String COL_6_TAG ="LONGITUD";
    public static final String COL_7_TAG ="LATITUD";

    public static final String COL_1_TYPE ="INTEGER";
    public static final String COL_2_TYPE ="TEXT";
    public static final String COL_3_TYPE ="REAL";
    public static final String COL_4_TYPE ="REAL";
    public static final String COL_5_TYPE ="REAL";
    public static final String COL_6_TYPE ="REAL";
    public static final String COL_7_TYPE ="REAL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Entramos aqui cuando la bbdd se crea por primera vez (despues de getWritableDatabase)
        //Se tendra que ejecutar una sentencia de DDL (Data Definition Languaje)

        StringBuilder strSQL = new StringBuilder();
        strSQL.append("CREATE TABLE ").append(TABLE_NAME).append(" (")
              .append(COL_1_TAG).append(" ").append(COL_1_TYPE).append(" PRIMARY KEY AUTOINCREMENT, ")
              .append(COL_2_TAG).append(" ").append(COL_2_TYPE).append(" NOT NULL, ")
              .append(COL_3_TAG).append(" ").append(COL_3_TYPE).append(" NOT NULL, ")
              .append(COL_4_TAG).append(" ").append(COL_4_TYPE).append(" NOT NULL, ")
              .append(COL_5_TAG).append(" ").append(COL_5_TYPE).append(" NOT NULL, ")
              .append(COL_6_TAG).append(" ").append(COL_6_TYPE).append(", ")
              .append(COL_7_TAG).append(" ").append(COL_7_TYPE).append(");");

        Log.d("*******", strSQL.toString());
        db.execSQL(strSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Entramos cuando se deteca un cambio de version en la ddbb.
        //Normalmente eso conlleva la cración de nuevas tablas o columnas en tablas ya existentes
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //Elimina la tabla
        onCreate(db); //Reconstruye la tabla desde 0. Adios a los datos
    }

    //Métodos para realizar operaciones CRUD, obtención de listas, etc...
    public boolean insertData(Date fechahora, Double peso, Double diastolica, Double sistolica, Double longitud, Double latitud){
        //Necesito una referencia a la bbdd
        SQLiteDatabase db = this.getWritableDatabase(); //Devuelve una referencia a la bbdd en modo escritura. Si la bbdd no existe, la crea

        //Necesito un contenedor de valores
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_TAG, sdf.format(fechahora));
        contentValues.put(COL_3_TAG, peso);
        contentValues.put(COL_4_TAG, diastolica);
        contentValues.put(COL_5_TAG, sistolica);
        contentValues.put(COL_6_TAG, longitud);
        contentValues.put(COL_7_TAG, latitud);

        long resultado = db.insert(TABLE_NAME,null,contentValues);

        //Si resultado = -1, indica que algo ha ido mal
        //Si resultado >= 0, indica el numero de registros afectados

        return resultado == -1 ? false: true;
    }

    //Deveulve el valor de codigo mas alto. Corresponde al último elemento insertado
    public Integer maxCodigo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX(" + COL_1_TAG + ") FROM " + TABLE_NAME + "LIMIT 1", null);
        return cursor.getInt(0);
    }

    //Devuelve un cursor con todos los registros
    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

}
