package inesvico.pdm.apprende.util;

public interface Preguntas{

    String getPregunta();

    String getRespuesta();

    String getOperador();

    void setPregunta(String mPregunta);

    void setRespuesta(String mRespuesta);

    void setOperador(String operador);

    String imprimirPregunta();
}