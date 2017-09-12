package inesvico.pdm.apprende.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ControlSesion {
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;
    Context mContext;

    int PRIVATE_MODE=0;
    private final String PREF_NAME = "Mi SharedPreferences";
    private final String USUARIO;

    public ControlSesion(Context context, String nombre){
        this.USUARIO = nombre;
        mPref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public int obtenerDatos(){ return mPref.getInt(USUARIO,0); }

    public void establecerDatos(int puntuacion) {mEditor.putInt(USUARIO, puntuacion).apply();}


}