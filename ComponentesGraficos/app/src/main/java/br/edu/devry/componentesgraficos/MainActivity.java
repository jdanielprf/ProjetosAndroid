package br.edu.devry.componentesgraficos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected ProgressBar progress;
    private Toast msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.teste);
        findViewById(R.id.textView);

        Log.d("Activity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //abrir a conexao
    }

    @Override
    protected void onStop() {
        super.onStop();
        //fechar conexao
    }
}
