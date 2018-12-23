package cufe.cmp.db.elakeel.Data.Entities.Reviewable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Meals;
import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Reviewables;

public class Meal extends Entity {
    private Reviewable reviewable;
    private String name;
    private byte[] image;
    private double price;
    private Meals.Type type;
    private Restaurant restaurant;

    public Meal(String name, byte[] image, double price, Meals.Type type, Restaurant restaurant) {
        this.reviewable = new Reviewable(Reviewables.Type.Meal);
        this.restaurant = restaurant;

        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
    }

    public Meal(Cursor cursor) {
        reviewable = new Reviewable(cursor);
        restaurant = new Restaurant(cursor);

        name = cursor.getString(cursor.getColumnIndexOrThrow(Meals.NAME));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Meals.IMAGE));
        price = cursor.getDouble(cursor.getColumnIndexOrThrow(Meals.PRICE));
        type = Meals.Type.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Meals.TYPE))];
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Meals.Type getType() {
        return type;
    }

    public void setType(Meals.Type type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean insert() {
        SQLiteStatement statement = db.compileStatement(Meals.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindBlob(1, image);
        statement.bindDouble(2, price);
        statement.bindLong(3, type.ordinal());
        statement.bindLong(4, restaurant.getReviewable().getId());
        statement.bindLong(5, reviewable.getId());
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Meals.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete() {
        return reviewable.delete(db);
    }
}
