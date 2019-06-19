package com.abcsoft.listviewpersonalizado;

import android.content.Context;
import android.content.Intent;
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
        //Tenemos que crear un objecto a partir del xml

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
        imagen.setTag(i); //Lo recuperaré en la implementacion de la clase anonima

        //Añadimos un listener a la imagen, atento al evento on click
        //View.OnClickListener() esw una clase abstracta -> requiere implementacion
        //Implementamos el listener como clase anonima
        imagen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //v identifica la vista que llama al onClick
                Intent intent = new Intent (contexto, VisorImagen.class); //1 (contexto) -> mundo en el que vive, 2) clase donde va

                /*
                //putExtra pasa datos a la clase vinculada con intent
                intent.putExtra("nombre_parametro","Valor");
                intent.putExtra("numeroHijos",12);
                intent.putExtra("Objetocualquiera", new Character(2));
                */

                //variable i no es accessible desde aqui. la hemos guardado como Tag en imagen y la recuperamos desde aqui
                intent.putExtra("IMG", datosImg[(Integer) v.getTag()]); //Recupero el parametro i
                contexto.startActivity(intent); //lanza la activity

            }
        });

        //Añado un listener al titulo para que me abra la descripcion en otra vista
        titulo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //v identifica la vista que llama al onClick
                Intent intent = new Intent (contexto, VisorTexto.class); //1 (contexto) -> mundo en el que vive, 2) clase donde va

                //variable i no es accessible desde aqui. la hemos guardado como Tag en imagen y la recuperamos desde aqui
                intent.putExtra("DESC", datos[(Integer) v.getTag()][4]); //Recupero el parametro i, que indica en que elemento estoy
                contexto.startActivity(intent); //lanza la activity

            }
        });









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
