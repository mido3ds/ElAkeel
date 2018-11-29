package cufe.cmp.db.elakeel.Data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static cufe.cmp.db.elakeel.Data.DbConstants.*;
import static cufe.cmp.db.elakeel.Data.DbConstants.Restaurants.ServiceType;

public class Restaurant extends Entity {
    private int id;
    private String name;
    private ServiceType serviceType;
    private byte[] image;
    private String phoneNo;

    public Restaurant(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndexOrThrow(Restaurants._ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Restaurants.IMAGE));
//        serviceType = Restaurants.ServiceType(cursor.getInt(cursor.getColumnIndexOrThrow(Restaurants.SERVICE_TYPE))); //TODO
        phoneNo = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.PHONE));
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

    @Override
    public void insert(SQLiteDatabase db) {

    }

    @Override
    public void update(SQLiteDatabase db) {

    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }
}
