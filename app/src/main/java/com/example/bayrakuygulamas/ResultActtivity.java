package com.example.bayrakuygulamas;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActtivity extends AppCompatActivity {

    private TextView textViewSonuc,textViewBasari;
    private Button buttonTekrar;
    private int dogruSayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_acttivity);

        textViewSonuc = findViewById(R.id.textViewSonuc);
        textViewBasari = findViewById(R.id.textViewBasari);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        dogruSayac = getIntent().getIntExtra("dogruSayac",0);

        textViewSonuc.setText(dogruSayac+ " DOĞRU "+(5-dogruSayac)+" YANLIŞ");
        textViewBasari.setText("% " + (dogruSayac*100)/5 + " Başarı" );

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActtivity.this, QuizActivity.class));
                finish();
            }
        });
    }
}
