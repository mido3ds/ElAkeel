package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import cufe.cmp.db.elakeel.Data.Database.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Entities.Order;
import cufe.cmp.db.elakeel.Data.Utility.BitmapUtil;

import java.util.ArrayList;

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

    public Restaurant(String name, ServiceType serviceType, Bitmap image, String phoneNo) {
        reviewable = new Reviewable(DbConstants.Reviewables.Type.Restaurant);
        this.name = name;
        this.serviceType = serviceType;
        this.image = BitmapUtil.bitmapToBytes(image);
        this.phoneNo = phoneNo;
    }

    public static Restaurant from(Order order) {
        Cursor mealCursor = db.rawQuery("SELECT MealID FROM OrdersContainMeals WHERE OrderID = " + order.getId(), null);
        mealCursor.moveToFirst();
        int mealId = mealCursor.getInt(0);

        Cursor restrIdCursor = db.rawQuery("SELECT RestrID FROM Meals WHERE ReviewableID = " + mealId, null);
        restrIdCursor.moveToFirst();
        int restrId = restrIdCursor.getInt(0);

        Cursor restrCursor = db.rawQuery("SELECT * FROM Restaurants WHERE ReviewableID = " + restrId, null);
        restrCursor.moveToFirst();
        Restaurant restaurant = new Restaurant(restrCursor);

        restrCursor.close();
        mealCursor.close();
        restrIdCursor.close();

        return restaurant;
    }

    public static ArrayList<Restaurant> getRestaurants(ServiceType serviceType, String region) {
        Cursor cursor = db.rawQuery("SELECT * FROM Restaurants WHERE ServiceType = " + serviceType.ordinal(), null);
        cursor.moveToFirst();
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            restaurants.add(new Restaurant(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return restaurants;
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
        reviewable.insert();
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
        return reviewable.delete();
    }

    public ArrayList<Meal> getAllMeals() {
        return null; // TODO: 23/12/2018
    }
}
