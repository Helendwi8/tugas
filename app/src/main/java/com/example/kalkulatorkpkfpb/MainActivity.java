package com.example.kalkulatorkpkfpb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextbilangan1, editTextbilangan2;
    Button buttonHitungFPBKPK;
    TextView pre, fpb, kpk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextbilangan1 = (EditText) findViewById(R.id.editTextBilangan1);
        editTextbilangan2 = (EditText) findViewById(R.id.editTextBilangan2);
        buttonHitungFPBKPK = (Button) findViewById(R.id.buttonHitungFPBKPK);
        pre = (TextView) findViewById(R.id.preText);
        fpb = (TextView) findViewById(R.id.fpbText);
        kpk = (TextView) findViewById(R.id.kpkText);
        buttonHitungFPBKPK.setOnClickListener(this);

    }

    public void onClick(View view) {
        hitungFPBKPK();
    }

    protected void hitungFPBKPK() {
        try {
            // do something
            int pertama = Integer.parseInt(editTextbilangan1.getText().toString());
            int kedua = Integer.parseInt(editTextbilangan2.getText().toString());
            int a, b, c;
            if(pertama>kedua){
                a=pertama;
                b=kedua;
            }
            else{
                a = kedua;
                b=pertama;
            }

            do {
                c = a % b;
                a = b;
                b = c;
            }
            while (c != 0);

            int FPB = a;
            int KPK = (pertama * kedua) / FPB;

            String preText, FPBText, KPKText;
            FPBText = Integer.toString(FPB);
            KPKText = Integer.toString(KPK);
            if (c == 0) {
                preText = "Faktor Persekutuan Terbesar dari bilangan "
                        + Integer.toString(pertama) + " dan " + Integer.toString(kedua) +
                        " merupakan bilangan bulat positif terbesar (" + FPBText +
                        ") yang dapat dibagi habis " +
                        "oleh kedua bilangan itu.\n\n" + "Dalam aritmetika dan teori bilangan, kelipatan " +
                        "persekutuan terkecil dari bilangan " +
                        Integer.toString(pertama) + " dan " + Integer.toString(kedua) + " adalah bilangan " +
                        "bulat positif terkecil " + KPKText + " yang dapat dibagi habis " +
                        "oleh kedua bilangan itu.";
                pre.setText(preText);
                fpb.setVisibility(View.VISIBLE);
                fpb.setText("FPB: " + FPBText);
                kpk.setVisibility(View.VISIBLE);
                kpk.setText("KPK: " + KPKText);

            } else {
                preText = "bilangan " + Integer.toString(pertama) + " dan " +
                        Integer.toString(kedua) + " tidak memiliki Faktor Persekutuan Terbesar (FPB) " +
                        "dan tidak memiliki Kelipatan Persekutuan Terkecil (KPK).";
                pre.setText(preText);
            }
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Input bilangan tidak sesuai.\nGunakan bilangan bulat positif!");
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
