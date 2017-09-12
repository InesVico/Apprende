package inesvico.pdm.apprende;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import inesvico.pdm.apprende.util.ControlSesion;
import inesvico.pdm.apprende.util.Controlador;

public class FinActividad extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ControlSesion superado = new ControlSesion(this, "SUPERADO");
        ControlSesion mayorP = new ControlSesion(this, "mayorPuntuacion");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_fin);

        TextView mtotalCorrectas = (TextView) findViewById(R.id.Correctas);
        int correctas = Integer.parseInt(Controlador.getCorrectas());
        if(correctas > mayorP.obtenerDatos()){
            mayorP.establecerDatos(correctas);
            TextView nuevaPuntuacion = (TextView) findViewById(R.id.nuevaPuntuacion);
            String nuevaPuntuacionText = "Tienes un nuevo record de " + Controlador.getCorrectas();
            nuevaPuntuacion.setText(nuevaPuntuacionText);
        }

        superado.establecerDatos(correctas + superado.obtenerDatos());
        mtotalCorrectas.append(Controlador.getCorrectas());

        TextView mtotalIncorrectas = (TextView) findViewById(R.id.Incorrectas);
        mtotalIncorrectas.append(Controlador.getTotalIncorrectas());

        TextView mTotalPreguntas = (TextView) findViewById(R.id.Preguntas);
        mTotalPreguntas.append(String.valueOf(Controlador.getTotalPreguntas()));


    }
}
