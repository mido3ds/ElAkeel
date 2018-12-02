package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;

import static cufe.cmp.db.elakeel.Data.DataBase.DbConstants.Bills;

public class Bill implements Entity {
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
    public boolean insert(SQLiteDatabase db) {
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
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Bills.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(4, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Bills.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
