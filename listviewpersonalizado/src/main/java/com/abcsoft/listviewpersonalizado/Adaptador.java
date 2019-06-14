package com.abcsoft.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private String[][] datos;
    private int[] datosImg;

    public Adaptador() {
    }

    public Adaptador(Context contexto, String[][] datos, int[] imagenes) {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        //new??
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //Tenemos que crear un objecto a partie del xml

        //Creo un objeto view a partir de la plantilla elemento_lista
        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        //Creo objetos a imagen de la plantilla para llenarlos
        TextView titulo = (TextView) vista.findViewById(R.id.idTitulo);
        TextView duracion = (TextView) vista.findViewById(R.id.idDuracion);
        TextView director = (TextView) vista.findViewById(R.id.idDirector);
        ImageView imagen = (ImageView) vista.findViewById(R.id.idImage);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.idRatingBar);

        //Añado el contenido de los datos en los campos
        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        duracion.setText("Duración: " + datos[i][2]);  //Mala practica "hard coded"
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));

        //Para cuando hagamos clic en el item
        imagen.setTag(i);

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public int[] getDatosImg() {
        return datosImg;
    }

    public void setDatosImg(int[] datosImg) {
        this.datosImg = datosImg;
    }

    public String[][] getDatos() {
        return datos;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

}
