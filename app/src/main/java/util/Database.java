package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import entity.Token;


public class Database extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";
    private static final String TABELA_CLIENTE = "tb_clientes";

    private static final String COLUNA_TOKEN = "token";
    private static final String COLUNA_CODIGO = "codigo";

    public Database(Context context){
        super(context, BANCO_CLIENTE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  QUERY_COLUMN = "create table "+ TABELA_CLIENTE+ " ( "+
                COLUNA_CODIGO+ " INTEGER PRIMARY KEY, " +
                COLUNA_TOKEN+ " TEXT)";
        db.execSQL(QUERY_COLUMN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {

    }

    public void saveToken(Token token){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_TOKEN, token.getToken());

        db.insert(TABELA_CLIENTE, null, values);
        db.close();
    }

    public String recoverToken(){
        SQLiteDatabase db = this.getReadableDatabase();
        String token = new String();
        Cursor cursor = db.rawQuery("select * from "+ TABELA_CLIENTE, null);

        while(cursor.moveToNext()){
            token = cursor.getString(cursor.getColumnIndex(COLUNA_TOKEN));
        }
        return token;
    }
}
