package br.edu.devry.devrygti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void euCliquei(View view){
        Log.i("Activity","Você clicou!!!");
        Toast popup = Toast.makeText(getApplicationContext(), "Você clicou!!!", Toast.LENGTH_LONG);
        popup.show();
    }
}
