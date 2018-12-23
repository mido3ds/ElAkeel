package cufe.cmp.db.elakeel.Data.Entities;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

public interface Entity extends Serializable {
    /**
     * insert in db with stored id
     *
     * @param db
     * @return true if successful
     */
    boolean insert(SQLiteDatabase db);

    /**
     * update ALL data of this entry in given database
     *
     * @param db
     * @return true if successful
     */
    boolean update(SQLiteDatabase db);

    /**
     * delete object in db
     *
     * @param db
     * @return true if successful
     */
    boolean delete(SQLiteDatabase db);
}
