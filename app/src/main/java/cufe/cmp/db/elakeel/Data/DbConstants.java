package cufe.cmp.db.elakeel.Data;

import android.provider.BaseColumns;

public class DbConstants {
    public static final String DB_NAME = "ElAkeel.db";
    public static final int DB_VERSION = 1;

    // TODO: 24/11/2018 add tables

//    public static final class #### implements BaseColumns {
//        public static final String TABLE_NAME = "";
//        public static final String
//                _ID = "";
//
//        public static final String SQL_CREATE_TABLE =
//                "CREATE TABLE " + TABLE_NAME +
//                        "(" +
//                        ");";
//        public static final String SQL_DROP_TABLE =
//                "DROP TABLE " + TABLE_NAME + ";";
//    }

    public static final class Restaurant implements BaseColumns {
        public static final String TABLE_NAME = "Restaurant";
        public static final String
                _ID = "ID",
                NAME = "Name",
                SERVICE_TYPE = "ServiceType",
                IMAGE = "Image",
                PHONE = "Phone";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        _ID + " INT PRIMARY KEY NOT NULL, " +
                        NAME + " TEXT, " +
                        SERVICE_TYPE + " TEXT, " +
                        IMAGE + " BLOB, " +
                        PHONE + " TEXT, " +
                        ");";
        public static final String SQL_DROP_TABLE =
                "DROP TABLE " + TABLE_NAME + ";";
    }

    public static final class Chef implements BaseColumns {
        public static final String TABLE_NAME = "Chef";
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
                        WORK_HOURS + " TEXT, " +
                        ");";
        public static final String SQL_DROP_TABLE =
                "DROP TABLE " + TABLE_NAME + ";";
    }

    public static final class DeliveryMan implements BaseColumns {
        public static final String TABLE_NAME = "DeliverMan";
        public static final String
                _ID = "ID",
                NAME = "Name",
                IMAGE = "Image",
                PHONE = "Phone";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" +
                        ");";
        public static final String SQL_DROP_TABLE =
                "DROP TABLE " + TABLE_NAME + ";";
    }
}
