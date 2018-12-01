package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Chefs;

public class Chef implements Entity {
    private long reviewableID;
    private String name;
    private String nationality;
    private byte[] image;
    private String workHours;

    public Chef(long reviewableID, String name, String nationality, byte[] image, String workHours) {
        this.reviewableID = reviewableID; //TODO make it an object of Reviewable
        this.name = name;
        this.nationality = nationality;
        this.image = image;
        this.workHours = workHours;
    }

    public Chef(Cursor cursor) {
        reviewableID = cursor.getLong(cursor.getColumnIndexOrThrow(Chefs.REVIEWABLE_ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NAME));
        nationality = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NATIONALITY));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Chefs.IMAGE));
        workHours = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.WORK_HOURS));
    }

    public long getReviewableID() {
        return reviewableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindString(1, nationality);
        statement.bindBlob(2, image);
        statement.bindString(3, workHours);

        statement.bindLong(4, reviewableID);
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_DELETE);
        statement.bindLong(0, reviewableID);
        return statement.executeUpdateDelete() == 1;
    }
}
