package com.abcsoft.medicdata_bbdd.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.abcsoft.medicdata_bbdd.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    Utilidades ut = new Utilidades();

    //Nombre de la bbdd
    public static final String DATABASE_NAME = "medicdata.db";

    //Nombre de la tabla
    public static final String TABLE_NAME = "LECTURAS";

    //Columnas de la tabla
    //Se recomienda usar mayusculas para los nombres de la tabla para diferenciarlos de Java. No son case sensitive
    public static final String COL_0_TAG ="CODIGO";
    public static final String COL_1_TAG ="FECHAHORA";
    public static final String COL_2_TAG ="PESO";
    public static final String COL_3_TAG ="DIASTOLICA";
    public static final String COL_4_TAG ="SISTOLICA";
    public static final String COL_5_TAG ="LONGITUD";
    public static final String COL_6_TAG ="LATITUD";

    public static final String COL_0_TYPE ="INTEGER";
    public static final String COL_1_TYPE ="TEXT";
    public static final String COL_2_TYPE ="TEXT";
    public static final String COL_3_TYPE ="TEXT";
    public static final String COL_4_TYPE ="TEXT";
    public static final String COL_5_TYPE ="REAL";
    public static final String COL_6_TYPE ="REAL";

    public DatabaseHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //El constructor entra aqui cuando la bbdd se crea por primera vez (despues de getWritableDatabase)
        //Se tendra que ejecutar una sentencia de DDL (Data Definition Languaje)

        StringBuilder strSQL = new StringBuilder();
        strSQL.append("CREATE TABLE ").append(TABLE_NAME).append(" (")
              .append(COL_0_TAG).append(" ").append(COL_0_TYPE).append(" PRIMARY KEY AUTOINCREMENT, ")
              .append(COL_1_TAG).append(" ").append(COL_1_TYPE).append(" NOT NULL, ")
              .append(COL_2_TAG).append(" ").append(COL_2_TYPE).append(" NOT NULL, ")
              .append(COL_3_TAG).append(" ").append(COL_3_TYPE).append(" NOT NULL, ")
              .append(COL_4_TAG).append(" ").append(COL_4_TYPE).append(" NOT NULL, ")
              .append(COL_5_TAG).append(" ").append(COL_5_TYPE).append(", ")
              .append(COL_6_TAG).append(" ").append(COL_6_TYPE).append(");");

        Log.d("*******", strSQL.toString());
        db.execSQL(strSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //El constructor entra aqui cuando detecta un cambio de version en la ddbb.
        //Normalmente eso conlleva la cración de nuevas tablas o columnas en tablas ya existentes
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //Elimina la tabla
        onCreate(db); //Reconstruye la tabla desde 0. Adios a los datos
        
        //Puede cambiar a cada version. Si hay cambios en la estrucutra de la bbdd habrá que refelejarlos aqui
    }

    //Métodos para realizar operaciones CRUD, obtención de listas, etc...
//    public boolean insertData(Date fechahora, Double peso, Double diastolica, Double sistolica, Double longitud, Double latitud){
    public int insertData(Lectura lectura){

        //Necesito una referencia de acceso a la bbdd
        SQLiteDatabase db = this.getWritableDatabase(); //Devuelve una referencia a la bbdd en modo escritura. Si la bbdd no existe, la crea

        //Necesito un contenedor de valores
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_TAG, ut.getStringFromDate(lectura.getFechaHora()));
        contentValues.put(COL_2_TAG, lectura.getPeso());
        contentValues.put(COL_3_TAG, lectura.getDiastolica());
        contentValues.put(COL_4_TAG, lectura.getSistolica());
        contentValues.put(COL_5_TAG, lectura.getLongitud());
        contentValues.put(COL_6_TAG, lectura.getLatitud());

        db.beginTransaction();//Inicia transaccion.Sirve para garantizar la consistencia de la bbdd en caso de problemas

        long resultado = db.insert(TABLE_NAME,null, contentValues);
        //db.insert devulve un long correspondiente al número de registros. Equivale al codigo
        //nullColumnHack se utiliza cuando queremos insertar un registro con valores null

        db.endTransaction(); //Cierra el beginTransaction

        //Si resultado = -1, indica que algo ha ido mal
        //Si resultado >= 0, indica el numero de registros afectados
        if (resultado > 0) {
            lectura.setCodigo((int) resultado);
            return lectura.getCodigo();
        } else {
            return -1;
        }
//        return resultado == -1 ? false: true;
    }

    //Deveulve el valor de codigo mas alto. Corresponde al último elemento insertado
    public Integer maxCodigo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX(" + COL_0_TAG + ") FROM " + TABLE_NAME + "LIMIT 1", null);
        return cursor.getInt(0);
    }

    //Devuelve una List con todos los registros
    public List<Lectura> getAll(){

        Cursor cursor;

        //Conexión a la bbdd
        SQLiteDatabase db = this.getWritableDatabase();

        //Mediante rawQuery
        //cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_1_TAG, null);

        //Mediante query
        cursor = db.query(
                TABLE_NAME,
                new String[]{COL_0_TAG, COL_1_TAG, COL_2_TAG, COL_3_TAG, COL_4_TAG, COL_5_TAG, COL_6_TAG},
                null,
                null,
                null,
                null,
                COL_1_TAG,
                null
        );

        return cursorLecturaToList(cursor);

    }


//***************************************************************************************
//************************                                     **************************
//************************          Metodos privados           **************************
//************************                                     **************************
//***************************************************************************************

    //Convierte un cursor de la tabla lecturas a una List
    private List<Lectura> cursorLecturaToList(Cursor cursor){
        List<Lectura> lecturas = new ArrayList<>();
        Lectura lectura;

        //cursor no pot estar buit
        if (cursor.getCount() == 0) {
            return null;
        }

        //Recorro el cursor
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            lectura = new Lectura(
                    ut.getDateFromString(cursor.getString(1)),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5),
                    cursor.getDouble(6)
            );
            lectura.setCodigo(cursor.getInt(0));
            lecturas.add(lectura);
        }

        return lecturas;
    }

}
