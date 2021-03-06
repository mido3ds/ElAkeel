package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;

import java.util.ArrayList;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Bills;

public class Bill extends Entity {
    private long id;
    private Bills.Status status;
    private double amount;
    private double discount;
    private Customer customer;

    public Bill(Bills.Status status, double amount, double discount, Customer customer) {
        this.status = status;
        this.amount = amount;
        this.discount = discount;
        this.customer = customer;
    }

    public Bill(Cursor cursor) {
        status = Bills.Status.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Bills.STATUS))];
        amount = cursor.getDouble(cursor.getColumnIndexOrThrow(Bills.AMOUNT));
        discount = cursor.getDouble(cursor.getColumnIndexOrThrow(Bills.DISCOUNT));
        customer = new Customer(cursor);
    }

    public long getId() {
        return id;
    }

    public Bills.Status getStatus() {
        return status;
    }

    public void setStatus(Bills.Status status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean insert() {
        SQLiteStatement statement = db.compileStatement(Bills.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, status.ordinal());
        statement.bindDouble(1, amount);
        statement.bindDouble(2, discount);
        statement.bindLong(3, customer.getUser().getId());
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Bills.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(4, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete() {
        SQLiteStatement statement = db.compileStatement(Bills.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }

    public ArrayList<Order> getOrders() {
        Cursor cursor = db.rawQuery("SELECT o.ID, o.Status, o.Time FROM Orders o, Bills b, BillContainsOrders bco WHERE o.ID = bco.OrderID AND b.ID = bco.BillID AND b.ID = ?", new String[]{
            Long.toString(id)
        });
        cursor.moveToFirst();
        ArrayList<Order> orders = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            orders.add(new Order(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return orders;
    }
}
