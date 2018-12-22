package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.Date;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Orders;

public class Order implements Entity {
    private long id;
    private Orders.Status status;
    private Date time;

    public Order(Orders.Status status, Date time) {
        this.status = status;
        this.time = time;
    }

    public Order(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Orders.ID));
        status = Orders.Status.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Orders.STATUS))];
        time = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(Orders.TIME)));
    }

    public long getId() {
        return id;
    }

    public Orders.Status getStatus() {
        return status;
    }

    public void setStatus(Orders.Status status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, status.ordinal());
        statement.bindLong(1, time.getTime());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(2, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Orders.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
