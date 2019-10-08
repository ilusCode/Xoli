package sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;

public class sqlite {
    private static sql sql;
    private SQLiteDatabase db;
    public sqlite(Context context){

    }

    public sqlite(){

    }

    public void abrirDB(){
        Log.i("SQLite","Se abre la conexion a la base de datos" + sql.getDatabaseName());
        db=sql.getWritableDatabase();
    }

    public void cerrarDB(){
        Log.i("SQLite","Se cierra la conexion a la base de datos" + sql.getDatabaseName());
        sql.close();
    }

    public boolean addRegistro(){
        int id = 0;
        String clase= "", nombre = "", especie = "", sexo= "", fechaIngreso = "",habitat = "", alimento = "";// son los campos que se ingresan en la Base de Datos
        ContentValues cv=new ContentValues();//se utiliza para registrar infromaicon en la Base de Datos

        cv.put("ID_ANIMAL",id);
        cv.put("CLASIFICACION",clase);
        cv.put("ESPECIE",especie);
        cv.put("NOMBRE",nombre);
        cv.put("SEXO",sexo);
        cv.put("FECHA_INGRESO",fechaIngreso);
        cv.put("HABITAT",habitat);
        cv.put("ALIMENTO",alimento);

        return (
                db.insert(
                        "ANIMALS",
                        null,
                        cv)!=-1)?true:false;
    }

    public Cursor getRegistro(){
        return db.rawQuery("SELECT * FROM ANIMALS",null);
    }

    //se obtiene todos los valores que tiene la base de datos
    public ArrayList<String> getAnimal(Cursor cursor){
        ArrayList<String> listData=new ArrayList<>();
        String item="";
        if (cursor.moveToFirst()){
            do {
                item+="ID_ANIMAL:["+cursor.getInt(0)+"]\r\n";
                item+="CLASIFICACION:["+cursor.getInt(1)+"]\r\n";
                item+="ESPECIE:["+cursor.getInt(2)+"]\r\n";
                item+="NOMBRE:["+cursor.getInt(3)+"]\r\n";
                item+="SEXO:["+cursor.getInt(4)+"]\r\n";
                item+="FECHA_INGRESO:["+cursor.getInt(5)+"]\r\n";
                item+="HABITAT:["+cursor.getInt(6)+"]\r\n";
                item+="ALIMENTO:["+cursor.getInt(7)+"]\r\n";
                listData.add(item);
            }while (cursor.moveToNext());
        }
        return listData;
    }

    //se obtiene solamente un valor en especifico ID
    public ArrayList<String> getID(Cursor cursor){
        ArrayList<String> listData=new ArrayList<>();
        String item="";
        if (cursor.moveToFirst()){
            do {
                item+="ID_ANIMAL:["+cursor.getInt(0)+"]\r\n";
            }while (cursor.moveToNext());
        }
        return listData;
    }

    public String updateAnimal(){
        int id = 0;
        String clase= "", nombre = "", especie = "", sexo= "", fechaIngreso = "",habitat = "", alimento = "";// son los campos que se ingresan en la Base de Datos
        ContentValues cv=new ContentValues();//se utiliza para registrar infromaicon en la Base de Datos

        cv.put("ID_ANIMAL",id);
        cv.put("CLASIFICACION",clase);
        cv.put("ESPECIE",especie);
        cv.put("NOMBRE",nombre);
        cv.put("SEXO",sexo);
        cv.put("FECHA_INGRESO",fechaIngreso);
        cv.put("HABITAT",habitat);
        cv.put("ALIMENTO",alimento);

        int cant=db.update("ANIMALS",
                cv,
                "ID_PROD="+id,
                null);
        if (cant==1){
            return "Animal Modificado";
        }else {
            return "Error no se pudo realizar la modificacion";
        }
    }
    public Cursor getCant(int id){
        return db.rawQuery("SELECT * FROM ANIMALS WHERE ID_PROD="+id,
                null);
    }

    public int Elimianr(Editable id){
        return db.delete("ANIMALS", "ID_ANIMAL="+id,null);
    }
}
