package inesvico.pdm.apprende;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import inesvico.pdm.apprende.util.Controlador;

public class PreguntasActividad extends AppCompatActivity {
    private CountDownTimer timer;
    /**Amount of time to show the tick or cross after answering a question */
    private static int TIEMPO_RESPUESTA = 1000;
    private static int INTERVALO = 1000;
    private long mTiempoRestante = 120000; //Start at 60 seconds

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        timer = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        final TextView mTimerText = getTimer();
        timer = new CountDownTimer(mTiempoRestante,INTERVALO) {
            public void onTick(long millisUntilFinished) {
                mTiempoRestante = millisUntilFinished;
                String time = "Segundos restantes: " + millisUntilFinished / 1000;
                mTimerText.setText(time);
            }
            public void onFinish() {
                timer.cancel();
                Intent intent = new Intent(PreguntasActividad.this, FinActividad.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_preguntas);

        Controlador.borrarCampos();

        final TextView mPreguntaText = (TextView) findViewById(R.id.preguntaPregunta);
        String questionInput = Controlador.hacerPregunta();
        mPreguntaText.setText(questionInput);

        final EditText mRespuesta = (EditText) findViewById(R.id.preguntaRespuesta);
        mRespuesta.setKeyListener(null);
        Button backspace = getSpace();
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable text = mRespuesta.getText();
                if (text.length() == 0) {
                    return;
                }
                CharSequence backspaced = text.subSequence(0, text.length() - 1);
                mRespuesta.setText(backspaced);
            }
        });

        Button clear = getClear();
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRespuesta.setText("");

            }
        });

        Button enter = getEnter();
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRespuesta.getText().toString().equals("")) {
                    return;
                }
                boolean isCorrect = Controlador.solucionar(mRespuesta.getText().toString());
                final ImageView solved = (ImageView) findViewById(R.id.solved);
                if (isCorrect) {
                    solved.setImageResource(R.drawable.bien);
                } else {
                    solved.setImageResource(R.drawable.mal);
                }
                //Only display the view for
                solved.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        solved.setVisibility(View.GONE);
                    }
                }, TIEMPO_RESPUESTA);
                final TextView mPreguntaText = (TextView) findViewById(R.id.preguntaPregunta);
                String questionInput = Controlador.hacerPregunta();
                mPreguntaText.setText(questionInput);
                mRespuesta.setText("");

            }
        });

        Button b0 = getButton0();
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "0";
                mRespuesta.append(c);
            }
        });


        Button b1 = getButton1();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "1";
                mRespuesta.append(c);
            }
        });
        Button b2 = getButton2();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "2";
                mRespuesta.append(c);
            }
        });
        Button b3 = getButton3();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "3";
                mRespuesta.append(c);
            }
        });
        Button b4 = getButton4();
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "4";
                mRespuesta.append(c);
            }
        });
        Button b5 = getButton5();
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "5";
                mRespuesta.append(c);
            }
        });
        Button b6 = getButton6();
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "6";
                mRespuesta.append(c);
            }
        });
        Button b7 = getButton7();
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "7";
                mRespuesta.append(c);
            }
        });
        Button b8 = getButton8();
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "8";
                mRespuesta.append(c);
            }
        });
        Button b9 = getButton9();
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = "9";
                mRespuesta.append(c);
            }
        });

    }


    private TextView getTimer() {
        return (TextView) findViewById(R.id.timer);
    }

    private Button getButton0() {
        return (Button) findViewById(R.id.Button0);
    }

    private Button getButton1() {
        return (Button) findViewById(R.id.Button1);
    }

    private Button getButton2() {
        return (Button) findViewById(R.id.Button2);
    }

    private Button getButton3() {
        return (Button) findViewById(R.id.Button3);
    }

    private Button getButton4() {
        return (Button) findViewById(R.id.Button4);
    }

    private Button getButton5() {
        return (Button) findViewById(R.id.Button5);
    }

    private Button getButton6() {
        return (Button) findViewById(R.id.Button6);
    }

    private Button getButton7() {
        return (Button) findViewById(R.id.Button7);
    }

    private Button getButton8() {
        return (Button) findViewById(R.id.Button8);
    }

    private Button getButton9() {
        return (Button) findViewById(R.id.Button9);
    }

    private Button getSpace() {
        return (Button) findViewById(R.id.ButtonBackSpace);
    }

    private Button getClear() {
        return (Button) findViewById(R.id.ButtonClear);
    }

    private Button getEnter() {
        return (Button) findViewById(R.id.ButtonEnter);
    }

}

