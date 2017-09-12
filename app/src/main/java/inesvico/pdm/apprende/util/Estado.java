package inesvico.pdm.apprende.util;

public interface Estado {

    int getRespuestaCorrecta();

    int getRespuestaIncorrecta();

    Preguntas getPregunta();

    String getRespuesta(Preguntas mPregunta);

    double generarNumeroAleatorio();

    void setRespuestaCorrecta(int correcta);

    void setRespuestaIncorrecta(int incorrecta);

    char getOperador();
}