package inesvico.pdm.apprende.util;

import inesvico.pdm.apprende.Niveles.Resta;
import inesvico.pdm.apprende.Niveles.Suma;
import inesvico.pdm.apprende.Niveles.SumaYResta;

public class Controlador {

    private static final Estado[] PREGUNTAS = new Estado[]
                {new Suma(), new Resta(), new SumaYResta()};

        private static int progreso = 0;
        private static int totalCorrectas = 0;
        private static int totalIncorrectas = 0;
        private static int totalPreguntas = 0;

        public static int dificultad = 1;

        private static Estado estadoActual = PREGUNTAS[progreso];
        private static Preguntas preguntaActual = estadoActual.getPregunta();

        public static void borrarCampos() {
            progreso = 0;
            totalCorrectas = 0;
            totalIncorrectas = 0;
            totalPreguntas = 0;
        }

        public static void setDificultad(int dificultad) {
            Controlador.dificultad = dificultad;
        }

        public static int getTotalPreguntas() {
            return totalPreguntas;
        }

        public static String hacerPregunta() {
            preguntaActual = estadoActual.getPregunta();
            return preguntaActual.getPregunta();
        }

        public static String getCorrectas() {
            return String.valueOf(totalCorrectas);
        }

        public static String getTotalIncorrectas() {
            return String.valueOf(totalIncorrectas);
        }

        public static boolean solucionar(String solucion) {
            String respuesta = preguntaActual.getRespuesta();
            if(respuesta == null || respuesta.equals("")){
                return false;
            }
            try {
                double RespuestaFinal = Double.parseDouble(respuesta);
                double SolucionFinal = Double.parseDouble(solucion);
                if (RespuestaFinal == SolucionFinal) {
                    totalCorrectas++;
                    totalPreguntas++;
                    estadoActual.setRespuestaCorrecta(estadoActual.getRespuestaCorrecta() + 1);
                    // Si respondes 10 bien, pasas al siguiente estado
                    if (estadoActual.getRespuestaCorrecta() == 10) {
                        estadoActual.setRespuestaCorrecta(0);
                        estadoActual.setRespuestaIncorrecta(0);
                        progreso++;
                        if (progreso == PREGUNTAS.length) {
                            progreso = PREGUNTAS.length - 1;
                        }
                        estadoActual = PREGUNTAS[progreso];
                        preguntaActual = estadoActual.getPregunta();
                    } else {
                        estadoActual.setRespuestaIncorrecta(estadoActual.getRespuestaIncorrecta() - 1);
                        preguntaActual = estadoActual.getPregunta();
                    }
                    return true;
                } else {
                    totalIncorrectas++;
                    totalPreguntas++;
                    estadoActual.setRespuestaIncorrecta(estadoActual.getRespuestaIncorrecta() + 1);
                    if (estadoActual.getRespuestaIncorrecta() == 10) {
                        estadoActual.setRespuestaCorrecta(0);
                        estadoActual.setRespuestaIncorrecta(0);
                        progreso--;
                        if (progreso < 0) {
                            progreso = 0;
                        }
                        estadoActual = PREGUNTAS[progreso];
                        preguntaActual = estadoActual.getPregunta();
                    } else {
                        estadoActual.setRespuestaCorrecta(estadoActual.getRespuestaCorrecta() - 1);
                        preguntaActual = estadoActual.getPregunta();
                    }
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        public static double getRespuesta(double digito1, double digito2, char operador) {
            switch (operador) {
                case '+':
                    return digito1 + digito2;
                case '-':
                    return digito1 - digito2;
            }
            return 1 + 1;
        }

}
