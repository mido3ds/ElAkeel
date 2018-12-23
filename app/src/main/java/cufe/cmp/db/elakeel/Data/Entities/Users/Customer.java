package cufe.cmp.db.elakeel.Data.Entities.Users;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Entities.Order;

import java.util.ArrayList;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Customers;
import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Users;

public class Customer implements Entity {
    private User user;
    private String phone;
    private String region, streetNo, buildingNo;
    private long points;
    private Customers.PaymentMethod paymentMethod;
    private String cardNo, cardSecNo, cardExpireData;

    public Customer(User user, String phone, String region, String streetNo, String buildingNo, long points,
                    Customers.PaymentMethod paymentMethod, String cardNo, String cardSecNo, String cardExpireData) {
        if (user.getType() != Users.Type.Customer) throw new IllegalArgumentException("user is not customer");
        this.user = user;

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
        user = new User(cursor);
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

    public static Customer from(User user) throws Exception {
        return null;// TODO: 23/12/2018
    }

    public User getUser() {
        return user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public Customers.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Customers.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardSecNo() {
        return cardSecNo;
    }

    public void setCardSecNo(String cardSecNo) {
        this.cardSecNo = cardSecNo;
    }

    public String getCardExpireData() {
        return cardExpireData;
    }

    public void setCardExpireData(String cardExpireData) {
        this.cardExpireData = cardExpireData;
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

        statement.bindLong(9, user.getId());
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        return user.delete(db);
    }

    public ArrayList<Order> getOrders() {
        return null; // TODO: 23/12/2018
    }
}
