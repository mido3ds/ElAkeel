package cufe.cmp.db.elakeel.Data.Database;

public class DbConstants {
    public static final String DB_NAME = "ElAkeel.db";
    public static final int DB_VERSION = 1;

    public static final class Restaurants {
        public static final String TABLE_NAME = "Restaurants";
        public static final String
                REVIEWABLE_ID = "ReviewableID",
                NAME = "Name",
                SERVICE_TYPE = "ServiceType",
                IMAGE = "Image",
                PHONE = "Phone";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s INT DEFAULT %d, " +
                                "%s BLOB, " +
                                "%s TEXT NOT NULL);",
                        TABLE_NAME,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables.ID,
                        NAME,
                        SERVICE_TYPE, ServiceType.Food.ordinal(),
                        IMAGE,
                        PHONE
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?);",
                        TABLE_NAME, NAME, SERVICE_TYPE, IMAGE, PHONE, REVIEWABLE_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, SERVICE_TYPE, IMAGE, PHONE, REVIEWABLE_ID
                );

        public enum ServiceType {
            Food, Drinks
        }
    }

    public static final class Chefs {
        public static final String TABLE_NAME = "Chefs";
        public static final String
                REVIEWABLE_ID = "ReviewableID",
                NAME = "Name",
                NATIONALITY = "Nationality",
                IMAGE = "Image",
                WORK_HOURS = "WorkHours";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s TEXT, " +
                                "%s BLOB, " +
                                "%s TEXT);",
                        TABLE_NAME,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables.ID,
                        NAME,
                        NATIONALITY,
                        IMAGE,
                        WORK_HOURS
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?);",
                        TABLE_NAME, NAME, NATIONALITY, IMAGE, WORK_HOURS, REVIEWABLE_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, NATIONALITY, IMAGE, WORK_HOURS, REVIEWABLE_ID
                );
    }

    public static final class DeliveryMen {
        public static final String TABLE_NAME = "DeliveryMen";
        public static final String
                REVIEWABLE_ID = "ReviewableID",
                NAME = "Name",
                IMAGE = "Image",
                PHONE = "Phone";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s BLOB, " +
                                "%s TEXT NOT NULL);",
                        TABLE_NAME,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables.ID,
                        NAME,
                        IMAGE,
                        PHONE
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s) VALUES(?, ?, ?, ?);",
                        TABLE_NAME, NAME, IMAGE, PHONE, REVIEWABLE_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, IMAGE, PHONE, REVIEWABLE_ID
                );
    }

    public static final class Customers {
        public static final String TABLE_NAME = "Customers";
        public static final String
                USER_ID = "UserID",
                PHONE = "Phone",
                REGION = "Region",
                STREET_NO = "StreetNo",
                BUILDING_NO = "BuildingNo",
                POINTS = "Points",
                PAYMENT_METHOD = "PaymentMethod",
                CARD_NO = "CardNo",
                CARD_SEC_NO = "CardSecNo",
                CARD_EXPIRE_DATA = "CardExpireData";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s INT DEFAULT 0, " +
                                "%s INT DEFAULT %d, " +
                                "%s TEXT, " +
                                "%s TEXT, " +
                                "%s TEXT);",
                        TABLE_NAME,
                        USER_ID, Users.TABLE_NAME, Users.ID,
                        PHONE,
                        REGION,
                        STREET_NO,
                        BUILDING_NO,
                        POINTS,
                        PAYMENT_METHOD, PaymentMethod.Cash.ordinal(),
                        CARD_NO,
                        CARD_SEC_NO,
                        CARD_EXPIRE_DATA
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                        TABLE_NAME, PHONE,
                        REGION, STREET_NO,
                        BUILDING_NO, POINTS,
                        PAYMENT_METHOD, CARD_NO,
                        CARD_SEC_NO, CARD_EXPIRE_DATA, USER_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, PHONE,
                        REGION, STREET_NO,
                        BUILDING_NO, POINTS,
                        PAYMENT_METHOD, CARD_NO,
                        CARD_SEC_NO, CARD_EXPIRE_DATA, USER_ID
                );

        public enum PaymentMethod {
            CreditCard, Cash
        }
    }

    public static final class Reviews {
        public static final String TABLE_NAME = "Reviews";
        public static final String
                ID = "ID",
                STARS = "Stars",
                COMMENT = "Comment",
                TIME = "Time",
                STATUS = "Status",
                CUSTOMER_ID = "CustomerID",
                REVIEWABLE_ID = "ReviewableID";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s(" +
                                "%s INT PRIMARY KEY, " +
                                "%s INT DEFAULT 1, " +
                                "%s TEXT, " +
                                "%s INT NOT NULL, " +
                                "%s INT DEFAULT %d, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE);",
                        TABLE_NAME,
                        ID,
                        STARS,
                        COMMENT,
                        TIME,
                        STATUS, Status.Posted.ordinal(),
                        CUSTOMER_ID, Customers.TABLE_NAME, Customers.USER_ID,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables.ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?);",
                        TABLE_NAME, STARS, COMMENT,
                        TIME, STATUS, CUSTOMER_ID, REVIEWABLE_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, STARS, COMMENT,
                        TIME, STATUS, CUSTOMER_ID, REVIEWABLE_ID, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Status {
            Posted, Seen, Solved
        }
    }

    public static final class Admins {
        public static final String TABLE_NAME = "Admins";
        public static final String
                USER_ID = "UserID",
                RANK = "Rank";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME,
                        USER_ID, Users.TABLE_NAME, Users.ID,
                        RANK
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s) VALUES(?, ?);",
                        TABLE_NAME, RANK, USER_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=? WHERE %s=?;",
                        TABLE_NAME, RANK, USER_ID
                );

        public enum Rank {
            First, Second
        }
    }

    public static final class RestaurantManagers {
        public static final String TABLE_NAME = "RestaurantManagers";
        public static final String
                USER_ID = "UserID",
                RESTR_ID = "RestrID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "PRIMARY KEY(%s, %s));",
                        TABLE_NAME,
                        USER_ID, Users.TABLE_NAME, Users.ID,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants.REVIEWABLE_ID,
                        USER_ID, RESTR_ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s) VALUES(?, ?);",
                        TABLE_NAME, RESTR_ID, USER_ID
                );
    }

    public static final class Users {
        public static final String TABLE_NAME = "Users";
        public static final String
                ID = "ID",
                NAME = "Name",
                EMAIL = "Email",
                PASSWORD = "Password",
                IMAGE = "Image",
                TYPE = "Type";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s TEXT NOT NULL, " +
                                "%s BLOB, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME,
                        ID,
                        NAME,
                        EMAIL,
                        PASSWORD,
                        IMAGE,
                        TYPE
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?);",
                        TABLE_NAME, NAME, EMAIL,
                        PASSWORD, IMAGE, TYPE
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, EMAIL,
                        PASSWORD, IMAGE, TYPE, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Type {
            Customer, RestaurantManager, Admin
        }
    }

    public static final class Reviewables {
        public static final String TABLE_NAME = "Reviewables";
        public static final String
                ID = "ID",
                TYPE = "Type";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME,
                        ID,
                        TYPE
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s) VALUES(?);",
                        TABLE_NAME, TYPE
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=? WHERE %s=?;",
                        TABLE_NAME, TYPE, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Type {
            Restaurant, Chef, Meal, DeliveryMan
        }
    }

    public static final class Branches {
        public static final String TABLE_NAME = "Branches";
        public static final String
                ID = "ID",
                REGION = "Region",
                STREET_NO = "StreetNo",
                BUILDING_NO = "BuildingNo",
                RESTR_ID = "RetrID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s TEXT NOT NULL, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE);",
                        TABLE_NAME,
                        ID,
                        REGION,
                        STREET_NO,
                        BUILDING_NO,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants.REVIEWABLE_ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s) VALUES(?, ?, ?, ?);",
                        TABLE_NAME, REGION, STREET_NO, BUILDING_NO, RESTR_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, REGION, STREET_NO, BUILDING_NO, RESTR_ID, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );
    }

    public static final class ChefsCookMeals {
        public static final String TABLE_NAME = "ChefsCookMeals";
        public static final String
                CHEF_ID = "ChefID",
                MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE," +
                                "PRIMARY KEY(%s, %s));",
                        TABLE_NAME,
                        CHEF_ID, Chefs.TABLE_NAME, Chefs.REVIEWABLE_ID,
                        MEAL_ID, Meals.TABLE_NAME, Meals.ID,
                        CHEF_ID, MEAL_ID
                );
    }

    public static final class Meals {
        public static final String TABLE_NAME = "Meals";
        public static final String
                REVIEWABLE_ID = "ReviewableID",
                NAME = "Name",
                IMAGE = "Image",
                PRICE = "Price",
                TYPE = "Type",
                RESTR_ID = "RestrID",

        ID = REVIEWABLE_ID;
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT UNIQUE NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s TEXT NOT NULL UNIQUE, " +
                                "%s BLOB, " +
                                "%s REAL NOT NULL, " +
                                "%s INT, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE);",
                        TABLE_NAME,
                        REVIEWABLE_ID, Reviewables.TABLE_NAME, Reviewables.ID,
                        NAME,
                        IMAGE,
                        PRICE,
                        TYPE,
                        RESTR_ID, Restaurants.TABLE_NAME, Restaurants.REVIEWABLE_ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?, ?);",
                        TABLE_NAME, NAME, IMAGE,
                        PRICE, TYPE, RESTR_ID, REVIEWABLE_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, IMAGE,
                        PRICE, TYPE, RESTR_ID, REVIEWABLE_ID
                );

        public enum Type {
            Big, Medium
        }
    }

    public static final class Orders {
        public static final String TABLE_NAME = "Orders";
        public static final String
                ID = "ID",
                STATUS = "Status",
                TIME = "Time";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL);",
                        TABLE_NAME,
                        ID,
                        STATUS,
                        TIME
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s) VALUES(?, ?);",
                        TABLE_NAME, STATUS, TIME
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, STATUS, TIME, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Status {
            NotDone, Done
        }
    }

    public static final class Bills {
        public static final String TABLE_NAME = "Bills";
        public static final String
                ID = "ID",
                STATUS = "Status",
                AMOUNT = "Amount",
                DISCOUNT = "Discount",
                CUSTOMER_ID = "CustomerID";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s INT DEFAULT 0, " +
                                "%s REAL NOT NULL, " +
                                "%s REAL NOT NULL, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE);",
                        TABLE_NAME,
                        ID,
                        STATUS,
                        AMOUNT,
                        DISCOUNT,
                        CUSTOMER_ID, Customers.TABLE_NAME, Customers.USER_ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s) VALUES(?, ?, ?, ?);",
                        TABLE_NAME, STATUS, AMOUNT,
                        DISCOUNT, CUSTOMER_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, STATUS, AMOUNT,
                        DISCOUNT, CUSTOMER_ID, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Status {
            Unpaid, paid
        }
    }

    public static final class Deliveries {
        public static final String TABLE_NAME = "Deliveries";
        public static final String
                ID = "ID",
                STATUS = "Status",
                LEAVE_TIME = "LeaveTime",
                ARRIVAL_TIME = "ArrivalTime",
                DELIVERY_MAN_ID = "DeliveryManID",
                BILL_ID = "BillID";
        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE);",
                        TABLE_NAME,
                        ID,
                        STATUS,
                        LEAVE_TIME,
                        ARRIVAL_TIME,
                        DELIVERY_MAN_ID, DeliveryMen.TABLE_NAME, DeliveryMen.REVIEWABLE_ID,
                        BILL_ID, Bills.TABLE_NAME, Bills.ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s, %s, %s, %s) VALUES(?, ?, ?, ?, ?);",
                        TABLE_NAME, STATUS, LEAVE_TIME,
                        ARRIVAL_TIME, DELIVERY_MAN_ID, BILL_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, STATUS, LEAVE_TIME,
                        ARRIVAL_TIME, DELIVERY_MAN_ID, BILL_ID, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );

        public enum Status {
            OnWay, Delivered
        }
    }

    public static final class BillContainsOrders {
        public static final String TABLE_NAME = "BillContainsOrders";
        public static final String
                BILL_ID = "BillID", ORDER_ID = "OrderID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "PRIMARY KEY(%s, %s));",
                        TABLE_NAME,
                        BILL_ID, Bills.TABLE_NAME, Bills.ID,
                        ORDER_ID, Orders.TABLE_NAME, Orders.ID,
                        BILL_ID, ORDER_ID
                );
    }

    public static final class OrdersContainMeals {
        public static final String TABLE_NAME = "OrdersContainMeals";
        public static final String
                ORDER_ID = "OrderID", MEAL_ID = "MealID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "PRIMARY KEY(%s, %s));",
                        TABLE_NAME,
                        ORDER_ID, Orders.TABLE_NAME, Orders.ID,
                        MEAL_ID, Meals.TABLE_NAME, Meals.ID,
                        ORDER_ID, MEAL_ID
                );
    }

    public static final class PromoCodes {
        public static final String TABLE_NAME = "PromoCodes";
        public static final String
                ID = "ID",
                CODE_NO = "CodeNo",
                CUSTOMER_ID = "CustomerID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s TEXT NOT NULL UNIQUE," +
                                "%s INT REFERENCES %s(%s));",
                        TABLE_NAME,
                        ID,
                        CODE_NO,
                        CUSTOMER_ID, Customers.TABLE_NAME, Customers.USER_ID
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s, %s) VALUES(?, ?);",
                        TABLE_NAME, CODE_NO, CUSTOMER_ID
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=?, %s=? WHERE %s=?;",
                        TABLE_NAME, CODE_NO, CUSTOMER_ID, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );
    }

    public static final class Ingredients {
        public static final String TABLE_NAME = "Ingredients";
        public static final String
                ID = "ID",
                NAME = "Name";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT PRIMARY KEY, " +
                                "%s TEXT NOT NULL UNIQUE);",
                        TABLE_NAME,
                        ID,
                        NAME
                );
        public static final String SQL_INSERT =
                String.format(
                        "INSERT INTO %s(%s) VALUES(?, ?);",
                        TABLE_NAME, NAME
                );
        public static final String SQL_UPDATE_ALL =
                String.format(
                        "UPDATE %s SET %s=? WHERE %s=?;",
                        TABLE_NAME, NAME, ID
                );
        public static final String SQL_DELETE =
                String.format(
                        "DELETE FROM %s WHERE %s=?;",
                        TABLE_NAME, ID
                );
    }

    public static final class MealsContainIngredients {
        public static final String TABLE_NAME = "PromoCodes";
        public static final String
                MEAL_ID = "MealID",
                INGRED_ID = "IngredID";

        public static final String SQL_CREATE_TABLE =
                String.format(
                        "CREATE TABLE %s" +
                                "(%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "%s INT NOT NULL REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                "PRIMARY KEY(%s, %s));",
                        TABLE_NAME,
                        MEAL_ID, Meals.TABLE_NAME, Meals.ID,
                        INGRED_ID, Ingredients.TABLE_NAME, Ingredients.ID,
                        MEAL_ID, INGRED_ID
                );
    }
}
