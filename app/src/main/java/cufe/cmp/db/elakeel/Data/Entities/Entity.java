package cufe.cmp.db.elakeel.Data.Entities;

import android.database.sqlite.SQLiteDatabase;

public interface Entity {
    /**
     * insert in db with stored id
     * @param db
     * @return true if successful
     */
    boolean insert(SQLiteDatabase db);

    /**
     * update ALL data of this entry in given database
     * @return true if successful
     * @param db
     */
    boolean update(SQLiteDatabase db);

    /**
     * delete object in db
     * @param db
     * @return true if successful
     */
    boolean delete(SQLiteDatabase db);
}
