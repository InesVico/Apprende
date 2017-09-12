package inesvico.pdm.apprende.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import inesvico.pdm.apprende.R;

public class SobreApp_Actividad  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_sobreapp);

        Resources res = getResources();
        final TextView versionText = (TextView) findViewById(R.id.version);
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            versionText.setText(version);
        } catch (PackageManager.NameNotFoundException e) {
            versionText.setText("1.0");
        }
    }
}

