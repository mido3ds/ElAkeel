package cufe.cmp.db.elakeel.Data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class Entity {
    /**
     * insert in db with stored id
     * @param db
     */
    public abstract void insert(SQLiteDatabase db);

    /**
     * update ALL data of this entry in given database
     * @param db
     */
    public abstract void update(SQLiteDatabase db);
}
