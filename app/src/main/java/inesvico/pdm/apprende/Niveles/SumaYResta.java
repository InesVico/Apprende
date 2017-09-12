package inesvico.pdm.apprende.Niveles;

import inesvico.pdm.apprende.util.Controlador;
import inesvico.pdm.apprende.util.Preguntas;
import inesvico.pdm.apprende.util.PreguntasImpl;


public class SumaYResta  extends AbstractNivel {
    public Preguntas getPregunta() {
        int digito1 = (int) generarNumeroAleatorio();
        int digito2 = (int) generarNumeroAleatorio();
        char operador = getOperador();
        if(digito1 < digito2 && operador == '-'){
            int temp = digito1;
            digito1 = digito2;
            digito2 = temp;
        }
        int respuesta = (int) Controlador.getRespuesta(digito1, digito2, operador);
        return new PreguntasImpl("" + digito1 + operador + digito2, String.valueOf(respuesta), String.valueOf(operador));
    }

    @Override
    public char getOperador() {
        double valor = Math.random();
        if (valor < 0.5) {
            return '+';
        } else {
            return '-';
        }
    }
}
