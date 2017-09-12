package inesvico.pdm.apprende.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import inesvico.pdm.apprende.R;

public class PuntuacionActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_puntuacion);
        ControlSesion mejorPuntuacion = new ControlSesion(this,"MejorPuntuacion");
        TextView puntuacion = (TextView) findViewById(R.id.mejorPuntuacion);
        puntuacion.append(String.valueOf(mejorPuntuacion.obtenerDatos()));

    }
}
