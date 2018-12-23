package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Database.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Entities.Order;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Chefs;

public class Chef extends Entity {
    private Reviewable reviewable;
    private String name;
    private String nationality;
    private byte[] image;
    private String workHours;

    public Chef(String name, String nationality, byte[] image, String workHours) {
        reviewable = new Reviewable(DbConstants.Reviewables.Type.Chef);
        this.name = name;
        this.nationality = nationality;
        this.image = image;
        this.workHours = workHours;
    }

    public Chef(Cursor cursor) {
        reviewable = new Reviewable(cursor);
        name = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NAME));
        nationality = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.NATIONALITY));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Chefs.IMAGE));
        workHours = cursor.getString(cursor.getColumnIndexOrThrow(Chefs.WORK_HOURS));
    }

    public static Chef from(Order order) {
        return null;// TODO: 23/12/2018
    }

    public Reviewable getReviewable() {
        return reviewable;
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
    public boolean insert() {
        reviewable.insert();
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindString(1, nationality);
        statement.bindBlob(2, image);
        statement.bindString(3, workHours);

        statement.bindLong(4, reviewable.getId());
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Chefs.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete() {
        return reviewable.delete();
    }
}
