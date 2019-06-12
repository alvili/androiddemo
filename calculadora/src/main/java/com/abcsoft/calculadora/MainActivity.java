package com.abcsoft.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private Operando operandoTmp = new Operando();
    private ArrayList<Double> operandos = new ArrayList<>();
    private ArrayList<String> operadores = new ArrayList<>();
    private Estado estado = Estado.INICIAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.idDisplay);

    }

    enum Estado{
        INICIAL, OPERANDO, OPERADOR, RESULTADO;
    }

    public void botonPulsado (View view) {

        String tecla = "";

        switch (view.getId()){

            case R.id.idBoton0 : tecla = "0"; estado = Estado.OPERANDO; break;
            case R.id.idBoton1 : tecla = "1"; estado = Estado.OPERANDO; break;
            case R.id.idBoton2 : tecla = "2"; estado = Estado.OPERANDO; break;
            case R.id.idBoton3 : tecla = "3"; estado = Estado.OPERANDO; break;
            case R.id.idBoton4 : tecla = "4"; estado = Estado.OPERANDO; break;
            case R.id.idBoton5 : tecla = "5"; estado = Estado.OPERANDO; break;
            case R.id.idBoton6 : tecla = "6"; estado = Estado.OPERANDO; break;
            case R.id.idBoton7 : tecla = "7"; estado = Estado.OPERANDO; break;
            case R.id.idBoton8 : tecla = "8"; estado = Estado.OPERANDO; break;
            case R.id.idBoton9 : tecla = "9"; estado = Estado.OPERANDO; break;
            case R.id.idBoton10 : tecla = "."; estado = Estado.OPERANDO; break;
            case R.id.idBoton11 : tecla = "-"; estado = Estado.OPERADOR; break;
            case R.id.idBoton12 : tecla = "*"; estado = Estado.OPERADOR; break;
            case R.id.idBoton13 : tecla = "/"; estado = Estado.OPERADOR; break;
            case R.id.idBoton14 : tecla = "";  estado = Estado.RESULTADO; break;
            case R.id.idBoton15 : tecla = "OFF"; break;
            case R.id.idBoton16 : tecla = "="; estado = Estado.INICIAL; break;
            case R.id.idBoton17 : tecla = "+"; estado = Estado.OPERADOR; break;

        }

        if (estado == Estado.OPERANDO) {
            operandoTmp.AddDigit(tecla);
        }

        if (estado == Estado.OPERADOR) {
            operadores.add(tecla);
            if (operandos.size() == 0) {
                operandos.add(operandoTmp.AsDouble()); //Recupero l'ultim resultat
            }
        }


        //Si pide operador o resultado significa que puedo guardar el operando
        if (estado == Estado.OPERADOR || estado == Estado.RESULTADO) {
            operandos.add(operandoTmp.AsDouble());
            operandoTmp.Reset();
        }

        //Escriu a la pantalla del mvl
        //Toast.makeText(getApplicationContext(), "Pulsando" + cifra, Toast.LENGTH_LONG).show();

        //Si pulsa = muestra resultado, sino solo actualizo la tecla
        if (estado == Estado.RESULTADO) {
            operandoTmp.setValor(Calcular());//guardo resultat per si es vol fer servir a la propera operacio
            ActualizarResultadoDisplay(operandoTmp.getValor());
            LimpiarPila();
        } else {
            ActualizarTeclaDisplay(tecla);
        }

        if (estado == Estado.INICIAL) {
            LimpiarPantalla();
            LimpiarPila();
        }

    }

    //Actualiza el display
    public void ActualizarTeclaDisplay(String tecla){
        StringBuilder sb = new StringBuilder();
        sb.append(display.getText().equals("0") ? "" : display.getText()).append(tecla);
        display.setText(sb.toString());
    }

    //Actualiza el display con el resultado
    public void ActualizarResultadoDisplay(double resultado){
        StringBuilder sb = new StringBuilder();
        sb.append(display.getText()).append("\n").append(resultado).append("\n");
        display.setText(sb.toString());
    }

    //Evalua el resultado de la operacion
    public double Calcular() {
//        //Parseo la operacion
//        String Operacion = (String) display.getText();
//        String[] partsString = Operacion.split("*");

        Double resultado = operandos.get(0);

        for (int i = 0; i < operadores.size(); i++) {
            switch (operadores.get(i)) {
                case "+":
                    resultado += operandos.get(i + 1);
                    break;
                case "-":
                    resultado -= operandos.get(i + 1);
                    break;
                case "*":
                    resultado *= operandos.get(i + 1);
                    break;
                case "/":
                    resultado /= operandos.get(i + 1);
                    break;
            }
        }
        return resultado;
    }

    //Resetea el display
    public void LimpiarPantalla(){
        //Limpio display
        display.setText("0");
    }

    public void LimpiarPila(){
        //Limpio variables
        operandos.clear();
        operadores.clear();
    }


}



