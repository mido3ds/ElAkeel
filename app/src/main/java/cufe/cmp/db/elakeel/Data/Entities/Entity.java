package cufe.cmp.db.elakeel.Data.Entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cufe.cmp.db.elakeel.Data.Database.DbOpenHelper;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    protected static SQLiteDatabase db;

    public static void init(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    /**
     * insert in db with stored id
     *
     * @return true if successful
     */
    public abstract boolean insert();

    /**
     * update ALL data of this entry in given database
     *
     * @return true if successful
     */
    public abstract boolean update();

    /**
     * delete object in db
     *
     * @return true if successful
     */
    public abstract boolean delete();
}
