package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Chefs;

public class Chef implements Entity {
    private long id;
    private String name;
    private String nationality;
    private byte[] image;
    private String workHours;

    public Chef(String name, String nationality, byte[] image, String workHours) {
        this.name = name;
        this.nationality = nationality;
        this.image = image;
        this.workHours = workHours;
    }

    public Chef(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Chefs._ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NAME));
        nationality = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NATIONALITY));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Chefs.IMAGE));
        workHours = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.WORK_HOURS));
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindString(1, nationality);
        statement.bindBlob(2, image);
        statement.bindString(3, workHours);
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(4, id);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_DELETE);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }
}
