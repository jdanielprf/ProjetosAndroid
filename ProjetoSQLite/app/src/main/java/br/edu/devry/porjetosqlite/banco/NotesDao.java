package br.edu.devry.porjetosqlite.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 24/09/16.
 */
public class NotesDao {

    private SQLiteDatabase database ;

    private String [] columns = {
            BancoDados.COLUMN_ID ,
            BancoDados.COLUMN_NOTES
    };

    private BancoDados sqliteOpenHelper ;

    public NotesDao ( Context context ) {
        sqliteOpenHelper = new BancoDados ( context ) ;
    }

    public void open () throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase () ;
    }

    public void close () {
        sqliteOpenHelper.close () ;
    }

    public Note create ( String note ) {
        ContentValues values = new ContentValues () ;

        values.put ( BancoDados.COLUMN_NOTES , note ) ;

        long insertId = database.insert ( BancoDados.TABLE_NOTES , null ,
                values ) ;

        Cursor cursor = database . query ( BancoDados.TABLE_NOTES ,
                columns , BancoDados.COLUMN_ID + " = " + insertId , null ,
                null , null , null ) ;

        cursor.moveToFirst () ;
        Note newNote = new Note () ;
        newNote.setId ( cursor.getLong (0) ) ;
        newNote.setNote (cursor.getString (1) ) ;
        cursor.close () ;
        return newNote ;
    }


    public List<Note> lista(){
        List<Note> lista=new ArrayList<Note>();
        Cursor cursor = database.query ( BancoDados . TABLE_NOTES ,
                columns , null, null ,
                null , null , null ) ;

        while(cursor.moveToNext()){
            Note newNote = new Note () ;
            newNote.setId ( cursor.getLong (0) ) ;
            newNote.setNote (cursor.getString (1) ) ;
            lista.add(newNote);
        }
        return lista;
    }

}
