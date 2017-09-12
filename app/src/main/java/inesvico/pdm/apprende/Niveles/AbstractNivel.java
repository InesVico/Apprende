package inesvico.pdm.apprende.Niveles;

import inesvico.pdm.apprende.util.Controlador;
import inesvico.pdm.apprende.util.Estado;
import inesvico.pdm.apprende.util.Preguntas;

public abstract class AbstractNivel implements Estado {
    protected int mCorrecto;
    protected int mIncorrecto;

    private final int FACIL_MAX_SUMARESTA = 11;
    private final int MEDIO_MAX_SUMARESTA = 51;
    private final int DIFICIL_MAX_SUMARESTA = 201;


    @Override
    public int getRespuestaCorrecta() {
        return mCorrecto;
    }

    @Override
    public int getRespuestaIncorrecta() {
        return mIncorrecto;
    }

    @Override
    public String getRespuesta(Preguntas p) {
        return p.getRespuesta();
    }

    @Override
    public void setRespuestaCorrecta(int correcta) {
        this.mCorrecto = correcta;
    }

    @Override
    public void setRespuestaIncorrecta(int incorrecta) {
        this.mIncorrecto = incorrecta;
    }

    @Override
    public double generarNumeroAleatorio() {
        switch(Controlador.dificultad){
            case 1: //Facil
                return Math.random() * FACIL_MAX_SUMARESTA;
            case 2: //Medio
                return Math.random() * MEDIO_MAX_SUMARESTA;
            case 3: //Dificil
                return Math.random() * DIFICIL_MAX_SUMARESTA;
        }
        return 1;
    }
}
