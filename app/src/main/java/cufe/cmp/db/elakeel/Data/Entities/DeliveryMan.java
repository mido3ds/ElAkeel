package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.DeliveryMen;

public class DeliveryMan implements Entity {
    private long id;
    private String name;
    private byte[] image;
    private String phone;

    public DeliveryMan(String name, byte[] image, String phone) {
        this.name = name;
        this.image = image;
        this.phone = phone;
    }

    public DeliveryMan(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(DeliveryMen._ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(DeliveryMen.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(DeliveryMen.IMAGE));
        phone = cursor.getString(cursor.getColumnIndexOrThrow(DeliveryMen.PHONE));
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
        SQLiteStatement statement = db.compileStatement(DeliveryMen.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindBlob(1, image);
        statement.bindString(2, phone);
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DeliveryMen.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(3, id);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DeliveryMen.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() == 1;
    }
}
