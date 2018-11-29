package cufe.cmp.db.elakeel.Data;

import android.provider.BaseColumns;

public class DbConstants {
    public static final String DB_NAME = "ElAkeel.db";
    public static final int DB_VERSION = 1;

    public static final class Restaurants implements BaseColumns {
        public static final String TABLE_NAME = "Restaurants";
        public static final String
                _ID = "ID",
                NAME = "Name",
                SERVICE_TYPE = "ServiceType",
                IMAGE = "Image",
                PHONE = "Phone";

        public enum ServiceType {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s BLOB, " +
                                "%s TEXT);",
                        TABLE_NAME, _ID, NAME, SERVICE_TYPE, IMAGE, PHONE
                );
    }

    public static final class Chefs implements BaseColumns {
        public static final String TABLE_NAME = "Chefs";
        public static final String
                _ID = "ID",
                NAME = "Name",
                NATIONALITY = "Nationality",
                IMAGE = "Image",
                WORK_HOURS = "WorkHours";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s BLOB, " +
                                "%s TEXT);",
                        TABLE_NAME, _ID, NAME, NATIONALITY, IMAGE, WORK_HOURS
                );
    }

    public static final class DeliveryMen implements BaseColumns {
        public static final String TABLE_NAME = "DeliveryMen";
        public static final String
                _ID = "ID",
                NAME = "Name",
                IMAGE = "Image",
                PHONE = "Phone";

        public static final String SQL_CREATE_TABLE =
                String.format("CREATE TABLE %s" +
                        "(%s INT PRIMARY KEY NOT NULL, " +
                        "%s TEXT, " +
                        "%s BLOB, " +
                        "%s TEXT);",
                        TABLE_NAME, _ID, NAME, IMAGE, PHONE
                );
    }

    public static final class Customers implements BaseColumns {
        public static final String TABLE_NAME = "Customers";
        public static final String
                _ID = "ID",
                PHONE = "Phone",
                REGION = "Region",
                STREET_NO = "StreetNo",
                BUILDING_NO = "BuildingNo",
                POINTS = "Points",
                PAYMENT_METHOD = "PaymentMethod",
                CARD_NO = "CardNo",
                CARD_SEC_NO = "CardSecNo",
                CARD_EXPIRE_DATA = "CardExpireData";

        public enum PaymentMethod {
            CreditCard, Promo, Cash
        }

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s INT, " +
                                "%s INT, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s TEXT);",
                        TABLE_NAME, _ID, PHONE,
                        REGION, STREET_NO,
                        BUILDING_NO, POINTS,
                        PAYMENT_METHOD, CARD_NO,
                        CARD_SEC_NO, CARD_EXPIRE_DATA
                );
    }

    public static final class Reviews implements BaseColumns {
        public static final String TABLE_NAME = "Reviews";
        public static final String
                _ID = "ID",
                STARS = "Stars",
                COMMENT = "Comment",
                TIME = "Time",
                STATUS = "Status",
                CUSTOMER_ID = "CustomerID",
                REVIEWABLE_ID = "ReviewableID";

        public enum Status {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                        "(%s INT PRIMARY KEY NOT NULL, " +
                        "%s INT NOT NULL DEFAULT 1, " +
                        "%s TEXT, " +
                        "%s INT NOT NULL, " +
                        "%s INT NOT NULL, " +
                        "%s INT NOT NULL, " +
                        "%s INT NOT NULL, " +
                        "FOREIGN KEY (%s) REFERENCES %s(%s), " +
                        "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, _ID, STARS, COMMENT,
                        TIME, STATUS, CUSTOMER_ID, REVIEWABLE_ID,
                        CUSTOMER_ID, Customers.TABLE_NAME, Customers._ID,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables._ID
                );
    }

    public static final class Admins  implements BaseColumns {
        public static final String TABLE_NAME = "Admins";
        public static final String
                _ID = "ID",
                RANK = "Rank";

        public enum Rank {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME, _ID, RANK
                );
    }

    public static final class RestaurantManagers  implements BaseColumns {
        public static final String TABLE_NAME = "RestaurantManagers";
        public static final String
                _ID = "ID",
                RESTR_ID = "RestrID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT, " +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, _ID, RESTR_ID,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants._ID
                );
    }

    public static final class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String
                _ID = "ID",
                NAME = "Name",
                EMAIL = "Email",
                PASSWORD = "Password",
                IMAGE = "Image",
                TYPE = "Type";

        public enum Type {
            Customer, RestaurantManager, Admin
        }

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s TEXT NOT NULL, " +
                                "%s BLOB, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME, _ID, NAME, EMAIL,
                        PASSWORD, IMAGE, TYPE
                );
    }

    public static final class Reviewables  implements BaseColumns {
        public static final String TABLE_NAME = "Reviewables";
        public static final String
                _ID = "ID",
                TYPE = "Type";

        public enum Type {
            Restaurant, Chef, Meal, DeliveryMan
        }

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME, _ID, TYPE
                );
    }

    public static final class Branches  implements BaseColumns {
        public static final String TABLE_NAME = "Branches";
        public static final String
                _ID = "ID",
                REGION = "Region",
                STREET_NO = "StreetNo",
                BUILDING_NO = "BuildingNo",
                RESTR_ID = "RetrID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s INT NOT NULL, " +
                                "FOREIGN KEY (%s) REFERENCES %s(%s) );",
                        TABLE_NAME, _ID, REGION, STREET_NO, BUILDING_NO, RESTR_ID,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants._ID
                );
    }

    public static final class ChefCooksMeals implements BaseColumns {
        public static final String TABLE_NAME = "ChefCooksMeals";
        public static final String
                CHEF_ID = "ChefID",
                MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s)" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, CHEF_ID, MEAL_ID,
                        CHEF_ID, Chefs.TABLE_NAME, Chefs._ID,
                        MEAL_ID, Meals.TABLE_NAME, Meals._ID
                );
    }

    public static final class Meals implements BaseColumns {
        public static final String TABLE_NAME = "Meals";
        public static final String
                _ID = "ID",
                NAME = "Name",
                IMAGE = "Image",
                PRICE = "Price",
                TYPE = "Type",
                RESTR_ID = "RestrID";

        public enum Type {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s BLOB, " +
                                "%s REAL NOT NULL, " +
                                "%s INT, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, _ID, NAME, IMAGE,
                        PRICE, TYPE, RESTR_ID,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants._ID
                );
    }

    public static final class Orders implements BaseColumns {
        public static final String TABLE_NAME = "Orders";
        public static final String
                _ID = "ID",
                STATUS = "Status",
                TIME = "Time";

        public enum Status {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME, _ID, STATUS, TIME
                );
    }

    public static final class Bills implements BaseColumns {
        public static final String TABLE_NAME = "Bills";
        public static final String
                _ID = "ID",
                STATUS = "Status",
                AMOUNT = "Amount",
                DISCOUNT = "Discount",
                CUSTOMER_ID = "CustomerID";

        public enum Status {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s REAL NOT NULL, " +
                                "%s REAL NOT NULL, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, _ID, STATUS, AMOUNT,
                        DISCOUNT, CUSTOMER_ID,
                        CUSTOMER_ID, Customers.TABLE_NAME, Customers._ID
                );
    }

    public static final class Deliveries implements BaseColumns {
        public static final String TABLE_NAME = "Deliveries";
        public static final String
                _ID = "ID",
                STATUS = "Status",
                LEAVE_TIME = "LeaveTime",
                ARRIVAL_TIME = "ArrivalTime",
                DELIVERY_MAN_ID = "DeliveryManID",
                BILL_ID = "BillID";

        public enum Status {}

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s)" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, _ID, STATUS, LEAVE_TIME,
                        ARRIVAL_TIME, DELIVERY_MAN_ID, BILL_ID,
                        DELIVERY_MAN_ID, DeliveryMen.TABLE_NAME, DeliveryMen._ID,
                        BILL_ID, Bills.TABLE_NAME, Bills._ID
                );
    }

    public static final class BillContainsOrders implements BaseColumns {
        public static final String TABLE_NAME = "BillContainsOrders";
        public static final String
                BILL_ID = "BillID", ORDER_ID = "OrderID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s)" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, BILL_ID, ORDER_ID,
                        BILL_ID, Bills.TABLE_NAME, Bills._ID,
                        ORDER_ID, Orders.TABLE_NAME, Orders._ID
                );
    }

    public static final class OrderContainsMeals implements BaseColumns {
        public static final String TABLE_NAME = "OrderContainsMeals";
        public static final String
                ORDER_ID = "OrderID", MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL, " +
                                "%s INT NOT NULL" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s)" +
                                "FOREIGN KEY (%s) REFERENCES %s(%s));",
                        TABLE_NAME, ORDER_ID, MEAL_ID,
                        ORDER_ID, Orders.TABLE_NAME, Orders._ID,
                        MEAL_ID, Meals.TABLE_NAME, Meals._ID
                );
    }

    public static final class PromoCode implements BaseColumns {
        public static final String TABLE_NAME = "PromoCode";
        public static final String
                _ID = "ID",
                CODE_NO = "CodeNo",
                STATUS = "Status";

        public enum Status {
            Unused, Used
        }

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY NOT NULL, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s INT NOT NULL DEFAULT %d);",
                        TABLE_NAME, _ID, CODE_NO, STATUS,
                        Status.Unused.ordinal()
                );
    }
}
