package br.com.faculdadepitagoras.cc.cm.consultarendereco;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public  EditText txtCEP;
    public  TextView txtBairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCEP=(EditText) findViewById(R.id.txtCEP);
        txtBairro=(TextView) findViewById(R.id.txtBairro);

        Button btn=(Button) findViewById(R.id.btnBuscar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarCep();
            }
        });
    }

    public void buscarCep(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpURLConnection urlConnection=null;
        try {
        String cpf=txtCEP.getText().toString();
        URL url = new URL("http://api.postmon.com.br/v1/cep/"+cpf);
        urlConnection = ( HttpURLConnection ) url. openConnection ();

             InputStream in = new BufferedInputStream( urlConnection . getInputStream ());
            Scanner s = new Scanner(in);
            if(s.hasNextLine()) {

                String strJson = s.nextLine();
                Log.d("Debug", strJson);

                JSONObject json = new JSONObject ( strJson );
                String bairro=json.get("bairro").toString();
                txtBairro.setText(bairro);
            }
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Nao foi possivel consultar o CEP",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }finally{
             urlConnection . disconnect ();
        }
    }
}
