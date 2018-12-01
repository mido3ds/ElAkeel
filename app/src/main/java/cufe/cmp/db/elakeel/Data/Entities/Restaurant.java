package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Restaurants;
import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Restaurants.ServiceType;

public class Restaurant implements Entity {
    private long reviewableID;
    private String name;
    private ServiceType serviceType;
    private byte[] image;
    private String phoneNo;

    public Restaurant(Cursor cursor) {
        reviewableID = cursor.getLong(cursor.getColumnIndexOrThrow(Restaurants.REVIEWABLE_ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Restaurants.IMAGE));
        serviceType = Restaurants.ServiceType.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Restaurants.SERVICE_TYPE))];
        phoneNo = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.PHONE));
    }

    public Restaurant(long reviewableID, String name, ServiceType serviceType, byte[] image, String phoneNo) {
        this.reviewableID = reviewableID; //TODO make it an object of Reviewable
        this.name = name;
        this.serviceType = serviceType;
        this.image = image;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getReviewableID() {
        return reviewableID;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindLong(1, serviceType.ordinal());
        statement.bindBlob(2, image);
        statement.bindString(3, phoneNo);

        statement.bindLong(4, reviewableID);
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Restaurants.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Restaurants.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Restaurants.SQL_DELETE);
        statement.bindLong(0, reviewableID);
        return statement.executeUpdateDelete() == 1;
    }
}
