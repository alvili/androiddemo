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
//    private ArrayList<Double> operandos = new ArrayList<>();
    private ArrayList<Operando> operandos = new ArrayList<>();
    private ArrayList<String> operadores = new ArrayList<>();
    private Estado[] estado = {Estado.INICIAL, Estado.INICIAL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.idDisplay);

    }

    enum Estado{
        INICIAL, OPERANDO, OPERADOR, DELETE, RESULTADO;
    }

    public void botonPulsado (View view) {

        String tecla = "";
        estado[1]=estado[0];
        switch (view.getId()){

            case R.id.idBoton0 : tecla = "0"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton1 : tecla = "1"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton2 : tecla = "2"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton3 : tecla = "3"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton4 : tecla = "4"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton5 : tecla = "5"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton6 : tecla = "6"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton7 : tecla = "7"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton8 : tecla = "8"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton9 : tecla = "9"; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton10 : tecla = "."; estado[0] = Estado.OPERANDO; break;
            case R.id.idBoton11 : tecla = "-"; estado[0] = Estado.OPERADOR; break;
            case R.id.idBoton12 : tecla = "*"; estado[0] = Estado.OPERADOR; break;
            case R.id.idBoton13 : tecla = "/"; estado[0] = Estado.OPERADOR; break;
            case R.id.idBoton14 : tecla = "";  estado[0] = Estado.RESULTADO; break;
            case R.id.idBoton15 : tecla = "Del"; estado[0] = Estado.DELETE; break;
            case R.id.idBoton16 : tecla = "="; estado[0] = Estado.INICIAL; break;
            case R.id.idBoton17 : tecla = "+"; estado[0] = Estado.OPERADOR; break;

        }

        //Escriu a la pantalla del mvl
        //Toast.makeText(getApplicationContext(), "Pulsando" + tecla, Toast.LENGTH_LONG).show();

        switch (estado[0]){

            case INICIAL:
                LimpiarPantalla();
                LimpiarPila();
                break;

            case OPERANDO:
                operandoTmp.addDigit(tecla);
                ActualizarTeclaDisplay(tecla);
                break;

            case DELETE:
                operandoTmp.removeDigit();

                //TODO actualizar estado
                break;

            case OPERADOR:
                operadores.add(tecla);
                //Si pide operador significa que puedo guardar el operando actual
//                operandos.add(operandoTmp.getValor());
                operandos.add(new Operando(operandoTmp.getValorDigitos()));
                operandoTmp.reset();
                ActualizarTeclaDisplay(tecla);
                break;


            case RESULTADO:
                operandos.add(new Operando(operandoTmp.getValorDigitos()));
                //Guardo el resultado en operandoTmp por si se quiere usar como sguiente operando
                operandoTmp.reset();
                operandoTmp.setValor(Calcular());//guardo resultat per si es vol fer servir a la propera operacio
                ActualizarResultadoDisplay(operandoTmp.getValorDigitos());
                LimpiarPila();
                break;
        }
    }

    //Actualiza el display
    public void ActualizarTeclaDisplay(String tecla){
        StringBuilder sb = new StringBuilder();

        /*
        //Reconstruyo la sequencia de operaciones
        sb.append(operandos(i));
        for (int i=0;i<operadores.size();i++){
            sb.append(operadores(i));
            sb.append(operandos[i].);
        }
        */
        sb.append(display.getText().equals("0") ? "" : display.getText()).append(tecla);
        display.setText(sb.toString());
    }

    //Actualiza el display con el resultado
    public void ActualizarResultadoDisplay(String resultado){
        StringBuilder sb = new StringBuilder();
        sb.append(display.getText()).append("\n").append(resultado).append("\n");
        display.setText(sb.toString());
    }

    //Evalua el resultado de la operacion
    public double Calcular() {

        Double resultado = operandos.get(0).getValor();

        for (int i = 0; i < operadores.size(); i++) {
            switch (operadores.get(i)) {
                case "+":
                    resultado += operandos.get(i + 1).getValor();
                    break;
                case "-":
                    resultado -= operandos.get(i + 1).getValor();
                    break;
                case "*":
                    resultado *= operandos.get(i + 1).getValor();
                    break;
                case "/":
                    if (operandos.get(i + 1).getValor() != 0) {
                        resultado /= operandos.get(i + 1).getValor();
                    }else{
                        resultado=999999999999999999999999999999;
                    }
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



