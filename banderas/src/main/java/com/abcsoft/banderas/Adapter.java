package com.abcsoft.banderas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private Context context;
    private String[][] fieldData;
    private int[] imageData;

    public Adapter() {
    }

    public Adapter(Context context, String[][] fieldData, int[] imageData) {
        this.context = context;
        this.fieldData = fieldData;
        this.imageData = imageData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //Total de elementos disponibles
        return imageData.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = inflater.inflate(R.layout.plantilla_pais, null);

        TextView country = (TextView) view.findViewById(R.id.idTextContry);
        TextView continent = (TextView) view.findViewById(R.id.idTextContinent);
        ImageView flag = (ImageView) view.findViewById(R.id.idImageFlag);

        country.setText(fieldData[position][0]);
        continent.setText(fieldData[position][1]);
        flag.setImageResource(imageData[position]);

        return view;
    }
}
