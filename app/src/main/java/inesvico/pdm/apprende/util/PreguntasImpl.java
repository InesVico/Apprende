package inesvico.pdm.apprende.util;

public class PreguntasImpl  implements Preguntas{
    private String mPregunta;
    private String mRespuesta;
    private String mOperador;

    public PreguntasImpl(String pregunta, String respuesta, String operador){
        this.mPregunta = pregunta;
        this.mRespuesta = respuesta;
        this.mOperador = operador;
    }

    public String getPregunta(){
        if(this.mPregunta == null){
            return "Error: No se ha encontrado pregunta";
        }
        return mPregunta;
    }

    public String getRespuesta(){
        if(this.mRespuesta == null){
            return "Error: No se ha encontrado respuesta";
        }
        return mRespuesta;
    }

    public String getOperador(){
        if(this.mOperador == null){
            return "Error: no existe operador";
        }
        return mOperador;
    }

    public void setPregunta(String pregunta){
        this.mPregunta = pregunta;
    }
    public void setRespuesta(String respuesta){
        this.mRespuesta = respuesta;
    }
    public void setOperador(String operador){
        this.mOperador = operador;
    }
    public String imprimirPregunta(){
        return mPregunta + " = " + mRespuesta;
    }

}
