package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Meal;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;

import java.util.ArrayList;
import java.util.Date;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Orders;

public class Order extends Entity {
    private long id;
    private Orders.Status status;
    private Date time;

    public Order(Orders.Status status, Date time) {
        this.status = status;
        this.time = time;
    }

    public Order(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Orders.ID));
        status = Orders.Status.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Orders.STATUS))];
        time = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(Orders.TIME)));
    }

    public long getId() {
        return id;
    }

    public Orders.Status getStatus() {
        return status;
    }

    public void setStatus(Orders.Status status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean insert() {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, status.ordinal());
        statement.bindLong(1, time.getTime());
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(2, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete() {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }

    public ArrayList<Restaurant> getRestaurants() {
        Cursor cursor = db.rawQuery("SELECT * FROM Restaurants WHERE ReviewableID in (SELECT m.RestrID FROM Meals as m, Orders as o, OrdersContainMeals as ocm WHERE o.ID = ? AND m.ID = ocm.MealID AND o.ID = ocm.OrderId)", new String[]{
                Long.toString(id)
        });
        cursor.moveToFirst();
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            restaurants.add(new Restaurant(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return restaurants;
    }

    public ArrayList<Meal> getMeals() {
        Cursor cursor = db.rawQuery("SELECT m.* FROM Meals as m, Orders as o, OrdersContainMeals as ocm WHERE o.ID = ? AND m.ID = ocm.MealID AND o.ID = ocm.OrderId", new String[]{
                Long.toString(id)
        });
        cursor.moveToFirst();
        ArrayList<Meal> meals = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            meals.add(new Meal(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return meals;
    }
}
