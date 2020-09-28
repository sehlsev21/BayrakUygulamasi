package com.example.bayrakuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {
    private TextView textViewDogru,textViewYalnis,textViewSoru;
    private ImageView imageViewBayrak;
    private Button buttonA,buttonB,buttonC,buttonD;
    private ArrayList<Bayraklar> sorularListe;
    private ArrayList<Bayraklar> yalnisSeceneklerListe;
    private Bayraklar dogruSoru;
    private Veritabani vt;
    //sayac
    private int soruSayac=0;
    private int yalnisSayac=0;
    private int dogruSayac=0;
    //secenekler
    private HashSet<Bayraklar> secenekleriKaristirmaListe = new HashSet<>();
    private ArrayList<Bayraklar> seceneklerListe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewDogru = findViewById(R.id.textViewDogru);
        textViewYalnis = findViewById(R.id.textViewYalnis);
        textViewSoru = findViewById(R.id.textViewSoru);
        imageViewBayrak = findViewById(R.id.imageViewBayrak);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        vt = new Veritabani(this);
        sorularListe = new BayraklarDao().rastgele5Getir(vt);
        soruYukle();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonA);
                sayacKontrol();
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonB);
                sayacKontrol();
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonC);
                sayacKontrol();
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonD);
                sayacKontrol();
            }
        });
    }

    public void soruYukle(){

        textViewSoru.setText((soruSayac+1) + ". SORU");

        dogruSoru = sorularListe.get(soruSayac);
        yalnisSeceneklerListe = new BayraklarDao().rastgele3YalnisSecenekGetir(vt,dogruSoru.getBayrak_id());
        imageViewBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrak_resim(),"drawable",getPackageName()));

        secenekleriKaristirmaListe.clear();
        secenekleriKaristirmaListe.add(dogruSoru);
        secenekleriKaristirmaListe.add(yalnisSeceneklerListe.get(0));
        secenekleriKaristirmaListe.add(yalnisSeceneklerListe.get(1));
        secenekleriKaristirmaListe.add(yalnisSeceneklerListe.get(2));

        seceneklerListe.clear();

        for(Bayraklar b: secenekleriKaristirmaListe){
            seceneklerListe.add(b);
        }

        buttonA.setText(seceneklerListe.get(0).getBayrak_ad());
        buttonB.setText(seceneklerListe.get(1).getBayrak_ad());
        buttonC.setText(seceneklerListe.get(2).getBayrak_ad());
        buttonD.setText(seceneklerListe.get(3).getBayrak_ad());

    }

    public void dogruKontrol(Button button){

        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getBayrak_ad();

        if(buttonYazi.equals(dogruCevap)){
            dogruSayac++;
        }else{
            yalnisSayac++;
        }
        textViewDogru.setText("Doğru : "+ dogruSayac);
        textViewYalnis.setText("Yalnis : "+ yalnisSayac);
    }

    public void sayacKontrol(){
        soruSayac++;

        if(soruSayac != 5){
            soruYukle();
        }else{
            Intent intent = new Intent(QuizActivity.this, ResultActtivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();
        }
    }



}
