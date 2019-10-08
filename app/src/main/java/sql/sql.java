package sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class sql extends SQLiteOpenHelper {
    private static final String db ="zoo";
    private static final int VERSION =1;
    private final String tAnimal="CREATE TABLE ANIMAL (" +
            "ID_ANIMAL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "CLASIFICACION TEXT NOT NULL," +
            "ESPECIE TEXT NOT NULL," +
            "NOMBRE TEXT NOT NULL," +
            "SEXO TEXT NOT NULL," +
            "FECHA_INGRESO TEXT NOT NULL," +
            "HABITAT TEXT NOT NULL," +
            "ALIMENTO TEXT NOT NULL)";

    public sql(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public sql(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public sql(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tAnimal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion){
            db.execSQL("DROP TABLE IF EXISTS ANIMALS");
            db.execSQL(tAnimal);
        }
    }
}
