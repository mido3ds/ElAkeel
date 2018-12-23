package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Database.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Entities.Order;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Restaurants;
import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Restaurants.ServiceType;

public class Restaurant extends Entity {
    private Reviewable reviewable;
    private String name;
    private ServiceType serviceType;
    private byte[] image;
    private String phoneNo;

    public Restaurant(Cursor cursor) {
        reviewable = new Reviewable(cursor);
        name = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Restaurants.IMAGE));
        serviceType = Restaurants.ServiceType.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Restaurants.SERVICE_TYPE))];
        phoneNo = cursor.getString(cursor.getColumnIndexOrThrow(Restaurants.PHONE));
    }

    public Restaurant(String name, ServiceType serviceType, byte[] image, String phoneNo) {
        reviewable = new Reviewable(DbConstants.Reviewables.Type.Restaurant);
        this.name = name;
        this.serviceType = serviceType;
        this.image = image;
        this.phoneNo = phoneNo;
    }

    public static Restaurant from(Order order) {
        return null; // TODO: 23/12/2018
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

    public Reviewable getReviewable() {
        return reviewable;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindLong(1, serviceType.ordinal());
        statement.bindBlob(2, image);
        statement.bindString(3, phoneNo);

        statement.bindLong(4, reviewable.getId());
    }

    @Override
    public boolean insert() {
        reviewable.insert(db);
        SQLiteStatement statement = db.compileStatement(Restaurants.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Restaurants.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete() {
        return reviewable.delete(db);
    }
}
