package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.DataBase.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Entity;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.DeliveryMen;

public class DeliveryMan implements Entity {
    private Reviewable reviewable;
    private String name;
    private byte[] image;
    private String phone;

    public DeliveryMan(String name, byte[] image, String phone) {
        this.reviewable = new Reviewable(DbConstants.Reviewables.Type.DeliveryMan);
        this.name = name;
        this.image = image;
        this.phone = phone;
    }

    public DeliveryMan(Cursor cursor) {
        reviewable = new Reviewable(cursor);
        name = cursor.getString(cursor.getColumnIndexOrThrow(DeliveryMen.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(DeliveryMen.IMAGE));
        phone = cursor.getString(cursor.getColumnIndexOrThrow(DeliveryMen.PHONE));
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        reviewable.insert(db);
        SQLiteStatement statement = db.compileStatement(DeliveryMen.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindBlob(1, image);
        statement.bindString(2, phone);

        statement.bindLong(3, getReviewable().getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DeliveryMen.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        return reviewable.delete(db);
    }
}
