package cufe.cmp.db.elakeel.Data.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.*;

public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] creates = {
                Admins.SQL_CREATE_TABLE,
                BillContainsOrders.SQL_CREATE_TABLE,
                Bills.SQL_CREATE_TABLE,
                Branches.SQL_CREATE_TABLE,
                ChefsCookMeals.SQL_CREATE_TABLE,
                Chefs.SQL_CREATE_TABLE,
                Customers.SQL_CREATE_TABLE,
                Deliveries.SQL_CREATE_TABLE,
                DeliveryMen.SQL_CREATE_TABLE,
                Meals.SQL_CREATE_TABLE,
                OrdersContainMeals.SQL_CREATE_TABLE,
                Orders.SQL_CREATE_TABLE,
                PromoCodes.SQL_CREATE_TABLE,
                RestaurantManagers.SQL_CREATE_TABLE,
                Restaurants.SQL_CREATE_TABLE,
                Reviewables.SQL_CREATE_TABLE,
                Reviews.SQL_CREATE_TABLE,
                Users.SQL_CREATE_TABLE,
                Ingredients.SQL_CREATE_TABLE,
                MealsContainIngredients.SQL_CREATE_TABLE
        };

        for (String s:creates)
            db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String[] drops = {
                Admins.TABLE_NAME,
                BillContainsOrders.TABLE_NAME,
                Bills.TABLE_NAME,
                Branches.TABLE_NAME,
                ChefsCookMeals.TABLE_NAME,
                Chefs.TABLE_NAME,
                Customers.TABLE_NAME,
                Deliveries.TABLE_NAME,
                DeliveryMen.TABLE_NAME,
                Meals.TABLE_NAME,
                OrdersContainMeals.TABLE_NAME,
                Orders.TABLE_NAME,
                PromoCodes.TABLE_NAME,
                RestaurantManagers.TABLE_NAME,
                Restaurants.TABLE_NAME,
                Reviewables.TABLE_NAME,
                Reviews.TABLE_NAME,
                Users.TABLE_NAME,
                Ingredients.TABLE_NAME,
                MealsContainIngredients.SQL_CREATE_TABLE
        };

        for (String s:drops)
            db.execSQL("DROP TABLE IF EXISTS " + s + ";");

        onCreate(db);
    }
}
