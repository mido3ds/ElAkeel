package cufe.cmp.db.elakeel.Data.Entities.Users;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.RestaurantManagers;

public class RestaurantManager implements Entity {
    private User user;
    private Restaurant restaurant;

    public RestaurantManager(User user, Restaurant restaurant) {
        this.user = user;
        this.restaurant = restaurant;
    }

    public RestaurantManager(Cursor cursor) {
        user = new User(cursor);
        restaurant = new Restaurant(cursor);
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(RestaurantManagers.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, restaurant.getReviewable().getId());
        statement.bindLong(1, user.getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        return false;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        return false;
    }
}
