package com.example.projetoandroidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO  {
    private Conexao conexao;
    private SQLiteDatabase banco;
    public AlunoDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome",aluno.getNome());
        values.put("serie",aluno.getSerie());
        values.put("escola",aluno.getEscola());
        return banco.insert("aluno",null,values);
    }
    public void excluir(Aluno a){

        banco.delete("aluno", "id = ?", new String[]{String.valueOf(a.getId())});
    }
    public List<Aluno> obterTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno",new String[]{"id","nome","serie","escola"}, null,null,null,null,null);
        while (cursor.moveToNext()){
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setSerie(cursor.getString(2));
            a.setEscola(cursor.getString(3));
            alunos.add(a);
        }
        return alunos;
    }

    public void atualizar(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome",aluno.getNome());
        values.put("serie",aluno.getSerie());
        values.put("escola",aluno.getEscola());
        banco.update("aluno", values,"id = ?",new String[]{String.valueOf(aluno.getId())});
    }
}
