package br.edu.devryslz.gti.estoucomsorte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  EditText  txtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValor=(EditText)findViewById(R.id.editText);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortear();
            }
        });
    }

    public void sortear(){
        String numero= txtValor.getText().toString();
        if(numero.equals("28")){
            Toast.makeText(getApplicationContext(),"Você acertou!",Toast.LENGTH_SHORT)
                    .show();
        }else{
            Toast.makeText(getApplicationContext(),"Você errou!",Toast.LENGTH_SHORT)
                    .show();

        }
    }


}
