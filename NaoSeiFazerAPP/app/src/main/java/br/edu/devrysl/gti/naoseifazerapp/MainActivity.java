package br.edu.devrysl.gti.naoseifazerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void cliqueEmMim(View elemento){
       Log.i("Informativas","você clicou!!!");
   }
}
