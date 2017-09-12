package inesvico.pdm.apprende.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import inesvico.pdm.apprende.R;

public class ConfiguracionActividad extends AppCompatActivity {

    private static boolean bFacil = false;
    private static boolean bMedio = true;
    private static boolean bDificil = false;
    private Switch mFacil;
    private Switch mMedio;
    private Switch mDificil;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_configuracion);

        mFacil = (Switch) findViewById(R.id.facil);
        mMedio = (Switch) findViewById(R.id.medio);
        mDificil = (Switch) findViewById(R.id.dificil);

        mFacil.setChecked(bFacil);
        mMedio.setChecked(bMedio);
        mDificil.setChecked(bDificil);

        mFacil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    bFacil = true;
                    if (bFacil) {
                        bMedio = false;
                        bDificil = false;
                        mFacil.setChecked(bFacil);
                        mMedio.setChecked(bMedio);
                        mDificil.setChecked(bDificil);

                    }
                    Controlador.setDificultad(1);
                }
                else{
                    if(!bMedio && !bDificil){
                        mFacil.setChecked(bFacil);
                        Toast.makeText(getApplication().getApplicationContext(),"¿Has escogido dificultad?", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        mMedio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    bMedio = true;
                    if (bMedio) {
                        bFacil = false;
                        bDificil = false;
                        mFacil.setChecked(bFacil);
                        mMedio.setChecked(bMedio);
                        mDificil.setChecked(bDificil);

                    }
                    Controlador.setDificultad(2);
                }
                else{
                    if(!bFacil && !bDificil){
                        mMedio.setChecked(bMedio);
                        Toast.makeText(getApplication().getApplicationContext(),"¿Has escogido dificultad?", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        mDificil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    bDificil = true;
                    if (bDificil) {
                        bMedio = false;
                        bFacil = false;
                        mFacil.setChecked(bFacil);
                        mMedio.setChecked(bMedio);
                        mDificil.setChecked(bDificil);

                    }
                    Controlador.setDificultad(3);
                }
                else{
                    if(!bFacil && !bMedio){
                        mDificil.setChecked(bDificil);
                        Toast.makeText(getApplication().getApplicationContext(),"¿Has escogido dificultad?", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
}
