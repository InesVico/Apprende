package inesvico.pdm.apprende;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mCuentos;
    private TextView mLectoEscritura;
    private TextView mLetras;
    private TextView mNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCuentos = (TextView) findViewById(R.id.cuentos);
        mLectoEscritura = (TextView) findViewById(R.id.lectoescritura);
        mLetras = (TextView) findViewById(R.id.letras);
        mNumeros = (TextView) findViewById(R.id.numeros);

        mNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NumerosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mLetras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Esta opción no está disponible en estos momentos", Toast.LENGTH_SHORT)
                        .show();

            }
        });
        mLectoEscritura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Esta opción no está disponible en estos momentos", Toast.LENGTH_SHORT)
                        .show();

            }
        });
        mCuentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Esta opción no está disponible en estos momentos", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
