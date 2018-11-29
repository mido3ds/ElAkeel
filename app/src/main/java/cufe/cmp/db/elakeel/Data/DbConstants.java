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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT, " +
                        SERVICE_TYPE + " TEXT, " +
                        IMAGE + " BLOB, " +
                        PHONE + " TEXT" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT, " +
                        NATIONALITY + " TEXT, " +
                        IMAGE + " BLOB, " +
                        WORK_HOURS + " TEXT" +
                        ");";
    }

    public static final class DeliveryMen implements BaseColumns {
        public static final String TABLE_NAME = "DeliveryMen";
        public static final String
                _ID = "ID",
                NAME = "Name",
                IMAGE = "Image",
                PHONE = "Phone";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT, " +
                        IMAGE + " BLOB, " +
                        PHONE + " TEXT" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        PHONE + " TEXT, " +
                        REGION + " TEXT, " +
                        STREET_NO + " TEXT, " +
                        BUILDING_NO + " TEXT, " +
                        POINTS + " INT, " +
                        PAYMENT_METHOD + " INT, " +
                        CARD_NO + " TEXT, " +
                        CARD_SEC_NO + " TEXT, " +
                        CARD_EXPIRE_DATA + " TEXT" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        STARS + " INT NOT NULL DEFAULT 1, " +
                        COMMENT + " TEXT, " +
                        TIME + " INT NOT NULL, " +
                        STATUS + " INT NOT NULL," +
                        CUSTOMER_ID + " INT NOT NULL, " +
                        REVIEWABLE_ID + " INT NOT NULL" +
                        ");";
    }

    public static final class Admins  implements BaseColumns {
        public static final String TABLE_NAME = "Admins";
        public static final String
                _ID = "ID",
                RANK = "Rank";

        public enum Rank {}

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        RANK + " INT NOT NULL" +
                        ");";
    }

    public static final class RestaurantManagers  implements BaseColumns {
        public static final String TABLE_NAME = "RestaurantManagers";
        public static final String
                _ID = "ID",
                RESTR_ID = "RestrID";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        RESTR_ID + " INT" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT NOT NULL, " +
                        EMAIL + " TEXT NOT NULL UNIQUE, " +
                        PASSWORD + " TEXT NOT NULL, " +
                        IMAGE + " BLOB, " +
                        TYPE + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        TYPE + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        REGION + " TEXT, " +
                        STREET_NO + " TEXT, " +
                        BUILDING_NO + " TEXT, " +
                        RESTR_ID + " INT NOT NULL" +
                        ");";
    }

    public static final class ChefCooksMeals implements BaseColumns {
        public static final String TABLE_NAME = "ChefCooksMeals";
        public static final String
                CHEF_ID = "ChefID",
                MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        CHEF_ID + " INT NOT NULL, " +
                        MEAL_ID + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT NOT NULL, " +
                        IMAGE + " BLOB, " +
                        PRICE + " REAL NOT NULL, " +
                        TYPE + " INT, " +
                        RESTR_ID + " INT NOT NULL" +
                        ");";
    }

    public static final class Orders implements BaseColumns {
        public static final String TABLE_NAME = "Orders";
        public static final String
                _ID = "ID",
                STATUS = "Status",
                TIME = "Time";

        public enum Status {}

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        STATUS + " INT NOT NULL, " +
                        TIME + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        STATUS + " INT NOT NULL, " +
                        AMOUNT + " REAL NOT NULL, " +
                        DISCOUNT + " REAL NOT NULL, " +
                        CUSTOMER_ID + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        STATUS + " INT NOT NULL, " +
                        LEAVE_TIME + " INT NOT NULL, " +
                        ARRIVAL_TIME + " INT NOT NULL, " +
                        DELIVERY_MAN_ID + " INT NOT NULL, " +
                        BILL_ID + " INT NOT NULL" +
                        ");";
    }

    public static final class BillContainsOrders implements BaseColumns {
        public static final String TABLE_NAME = "BillContainsOrders";
        public static final String
                BILL_ID = "BillID", ORDER_ID = "OrderID";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        BILL_ID + " INT NOT NULL, " +
                        ORDER_ID + " INT NOT NULL" +
                        ");";
    }

    public static final class OrderContainsMeals implements BaseColumns {
        public static final String TABLE_NAME = "OrderContainsMeals";
        public static final String
                ORDER_ID = "OrderID", MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        ORDER_ID + " INT NOT NULL, " +
                        MEAL_ID + " INT NOT NULL" +
                        ");";
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
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        CODE_NO + " TEXT NOT NULL UNIQUE, " +
                        STATUS + " INT NOT NULL DEFAULT " + Status.Unused.ordinal() +
                        ");";
    }
}
