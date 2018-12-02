package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.DataBase.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;

public class PromoCode implements Entity {
    private long id;
    private String code;
    private Customer customer;

    public PromoCode(String code, Customer customer) {
        this.code = code;
        this.customer = customer;
    }

    public PromoCode(Cursor cursor) {
        code = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.PromoCodes.CODE_NO));
        customer = new Customer(cursor);
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.PromoCodes.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, code);
        statement.bindLong(1, customer.getUser().getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.PromoCodes.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(2, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(DbConstants.PromoCodes.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }

    /**
     * generates randomized promo codes
     * @param n num of promo codes to generate
     * @return promo codes
     */
    static PromoCode[] generatePromoCodes(int n) {
        //TODO
        return null;
    }
}
