package br.edu.devry.porjetosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import br.edu.devry.porjetosqlite.banco.Note;
import br.edu.devry.porjetosqlite.banco.NotesDao;

public class MainActivity extends AppCompatActivity {
    private NotesDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao=new NotesDao(getApplicationContext());
        dao.open();
    }

    public void adicionarNota(View view){
        System.out.print("Minha mensagem!!!");

        EditText texto=(EditText)findViewById(R.id.editText);

        String text=texto.getText().toString();
        Log.i("LOG texto",text);

        dao.create(text);

        List<Note> minhaLista = dao.lista();
        Iterator<Note> iterator = minhaLista.iterator();

        while (iterator.hasNext()) {
            Note nota2 = iterator.next();
            Log.i("APP",nota2.getNote());
        }

    }

    public void listar(View view){
        Intent intent=new Intent(getApplicationContext(),ListaNoteActivity.class);
        startActivity(intent);
    }
}
