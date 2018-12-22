package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Reviewables;

public class Reviewable implements Entity {
    private long id;
    private Reviewables.Type type;

    public Reviewable(Reviewables.Type type) {
        this.type = type;
    }

    public Reviewable(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Reviewables.ID));
        type = Reviewables.Type.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Reviewables.TYPE))];
    }

    public long getId() {
        return id;
    }

    public Reviewables.Type getType() {
        return type;
    }

    public void setType(Reviewables.Type type) {
        this.type = type;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviewables.SQL_INSERT);
        statement.bindLong(0, type.ordinal());
        id = statement.executeInsert();
        return id != -1;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviewables.SQL_UPDATE_ALL);
        statement.bindLong(0, type.ordinal());
        statement.bindLong(1, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviewables.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
