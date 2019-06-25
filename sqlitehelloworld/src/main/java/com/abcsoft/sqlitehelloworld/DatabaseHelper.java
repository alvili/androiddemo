package com.abcsoft.sqlitehelloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.speech.tts.TextToSpeech;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Nombre de la bbdd
    public static final String DATABASE_NAME = "amigos.db";

    //Nombre de la tabla
    public static final String AMIGOS_TABLE = "AMIGOS";

    //Columnas de la tabla
    //Se recomienda usar mayusculas para los nombres de la tabla para diferenciarlos de Java. No son case sensitive
    public static final String COL_1 ="ID";
    public static final String COL_2 ="NOMBRE";
    public static final String COL_3 ="APELLIDO1";
    public static final String COL_4 ="APELLIDO2";


//    public DatabaseHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
//Suprimimos anotaciones
    public DatabaseHelper(Context context) {
//        super(context, name, factory, version);
//bbdd interna, no usamos la facoria, version fija
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Entramos aqui cuando la bbdd se crea por primera vez (despues de getWritableDatabase)
        //Se tendra que ejecutar una sentencia de DDL (Data Definition Languaje)

        StringBuilder strSQL = new StringBuilder();
/*
    CREATE TABLE AMIGOS (
        ID INTEGER PRIMARY KEY AUTOINCREMENT,
        NOMBRE TEXT NOT NULL,
        APELLIDO1, TEXT,
        APELLIDO2, TEXT,
    )
*/
        strSQL.append("CREATE TABLE ").append(AMIGOS_TABLE).append(" (")
              .append(COL_1).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
              .append(COL_2).append(" TEXT NOT NULL, ")
              .append(COL_3).append(" TEXT NOT NULL, ")
              .append(COL_4).append(" TEXT);");

        Log.d("*******", strSQL.toString());
        db.execSQL(strSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Entramos cuando se deteca un cambio de version en la ddbb.
        //Normalmente eso conlleva la cración de nuevas tablas o columnas en tablas ya existentes
        db.execSQL("DROP TABLE IF EXISTS " + AMIGOS_TABLE); //Elimina la tabla
        onCreate(db); //Reconstruye la tabla desde 0. Adios a los datos
    }

    //Métodos para realizar operaciones CRUD, obtención de listas, etc...
    public boolean insertData(String nombre, String apellido1, String apellido2){
        //Necesito una referencia a la bbdd
        SQLiteDatabase db = this.getWritableDatabase(); //Devuelve una referencia a la bbdd en modo escritura. Si la bbdd no existe, la crea

        //Necesito un contenedor de valores
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellido1);
        contentValues.put(COL_4, apellido2);

        long resultado = db.insert(AMIGOS_TABLE,null,contentValues);

        //Si resultado = -1, indica que algo ha ido mal
        //Si resultado >= 0, indica el numero de registros afectados

        //tres maneras de obtener el nombre de la bbdd
        String nombreDDBB = this.getDatabaseName();
        nombreDDBB = this.DATABASE_NAME;

        return false;
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AMIGOS_TABLE, null);

        //SelectionArgs ??
        //Es una array de Strings[]
        //En la consulta pueden haber ?s que seran substituidos por los valores de ese array de strings
        //Ejemplo
        //SELECT * FROM AMIGOS_TABLA WHERE NOMBRE =? AND APELLIDO LIKE ?
        //STRING [] = {"aDOLFO", "D"}

        return cursor;
    }


}
