package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Customers;
import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Users;

public class Customer implements Entity {
    private long userID;
    private String phone;
    private String region, streetNo, buildingNo;
    private long points;
    private Customers.PaymentMethod paymentMethod;
    private String cardNo, cardSecNo, cardExpireData;

    public Customer(User user, String phone, String region, String streetNo, String buildingNo, long points,
                    Customers.PaymentMethod paymentMethod, String cardNo, String cardSecNo, String cardExpireData) {
        this.userID = user.getId();
        if (user.getType() != Users.Type.Customer) throw new IllegalArgumentException("user is not customer");

        this.phone = phone;
        this.region = region;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.points = points;
        this.paymentMethod = paymentMethod;
        this.cardNo = cardNo;
        this.cardSecNo = cardSecNo;
        this.cardExpireData = cardExpireData;
    }

    public Customer(Cursor cursor) {
        userID = cursor.getLong(cursor.getColumnIndexOrThrow(Customers.USER_ID));
        phone = cursor.getString(cursor.getColumnIndexOrThrow(Customers.PHONE));
        region = cursor.getString(cursor.getColumnIndexOrThrow(Customers.REGION));
        streetNo = cursor.getString(cursor.getColumnIndexOrThrow(Customers.STREET_NO));
        buildingNo = cursor.getString(cursor.getColumnIndexOrThrow(Customers.BUILDING_NO));
        points = cursor.getLong(cursor.getColumnIndexOrThrow(Customers.POINTS));
        paymentMethod = Customers.PaymentMethod.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Customers.PAYMENT_METHOD))];
        cardNo = cursor.getString(cursor.getColumnIndexOrThrow(Customers.CARD_NO));
        cardSecNo = cursor.getString(cursor.getColumnIndexOrThrow(Customers.CARD_SEC_NO));
        cardExpireData = cursor.getString(cursor.getColumnIndexOrThrow(Customers.CARD_EXPIRE_DATA));
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Customers.SQL_INSERT);
        bindData(statement);
        return statement.executeInsert() != -1;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Customers.SQL_UPDATE_ALL);
        bindData(statement);
        return statement.executeUpdateDelete() == 1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, phone);
        statement.bindString(1, region);
        statement.bindString(2, streetNo);
        statement.bindString(3, buildingNo);
        statement.bindLong(4, points);
        statement.bindLong(5, paymentMethod.ordinal());
        statement.bindString(6, cardNo);
        statement.bindString(7, cardSecNo);
        statement.bindString(8, cardExpireData);

        statement.bindLong(9, userID);
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Customers.SQL_DELETE);
        statement.bindLong(0, userID);
        return statement.executeUpdateDelete() == 1;
    }
}
