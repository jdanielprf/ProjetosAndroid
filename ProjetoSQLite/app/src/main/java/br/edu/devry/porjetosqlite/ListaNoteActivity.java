package br.edu.devry.porjetosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import br.edu.devry.porjetosqlite.banco.Note;
import br.edu.devry.porjetosqlite.banco.NotesDao;

public class ListaNoteActivity extends AppCompatActivity {
    private NotesDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_note);
        find
    }

    @Override
    protected void onStart() {
        super.onStart();

        dao=new NotesDao(getApplicationContext());
        dao.open();

        LinearLayout lista=(LinearLayout)findViewById(R.id.lista);

        List<Note> minhaLista = dao.lista();
        Iterator<Note> iterator = minhaLista.iterator();

        while (iterator.hasNext()) {
            Note nota = iterator.next();
            TextView texto = new TextView(getApplicationContext());
            texto.setText(nota.getNote());

            lista.addView(texto);
        }

    }
}
