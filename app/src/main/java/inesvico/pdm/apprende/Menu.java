package inesvico.pdm.apprende;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import inesvico.pdm.apprende.util.ConfiguracionActividad;
import inesvico.pdm.apprende.util.PuntuacionActividad;
import inesvico.pdm.apprende.util.SobreApp_Actividad;

public class Menu extends AppCompatActivity {

    Button mComenzar, mPuntuacion, mConfiguracion, mSobreApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mComenzar = (Button) findViewById(R.id.empezar);
        mComenzar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, PreguntasActividad.class);
                startActivity(intent);
            }
        });
        mPuntuacion = (Button) findViewById(R.id.puntuacion);
        mPuntuacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, PuntuacionActividad.class);
                startActivity(intent);
            }
        });
        mConfiguracion = (Button) findViewById(R.id.configuracion);
        mConfiguracion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ConfiguracionActividad.class);
                startActivity(intent);
            }
        });

        mSobreApp = (Button) findViewById(R.id.sobreapp);
        mSobreApp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, SobreApp_Actividad.class);
                startActivity(intent);
            }
        });
    }
}
