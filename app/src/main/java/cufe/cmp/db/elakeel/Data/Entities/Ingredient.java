package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.DataBase.DbConstants;

public class Ingredient implements Entity {
    private long id;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(Cursor cursor) {
        this.id = cursor.getLong(cursor.getColumnIndexOrThrow(DbConstants.Ingredients.ID));
        this.name = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.Ingredients.NAME));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.Ingredients.SQL_INSERT);
        statement.bindString(0, name);
        id = statement.executeInsert();
        return id != -1;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.Ingredients.SQL_UPDATE_ALL);
        statement.bindString(0, name);
        statement.bindLong(1, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.Ingredients.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
