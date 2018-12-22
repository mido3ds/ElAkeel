package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.DeliveryMan;

import java.util.Date;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Deliveries;

public class Delivery implements Entity {
    private long id;
    private Deliveries.Status status;
    private Date leaveTime, arriveTime;
    private DeliveryMan deliveryMan;
    private Bill bill;

    public Delivery(Deliveries.Status status, Date leaveTime, Date arriveTime, DeliveryMan deliveryMan, Bill bill) {
        this.status = status;
        this.leaveTime = leaveTime;
        this.arriveTime = arriveTime;
        this.deliveryMan = deliveryMan;
        this.bill = bill;
    }

    public Delivery(Cursor cursor) {
        deliveryMan = new DeliveryMan(cursor);
        bill = new Bill(cursor);

        status = Deliveries.Status.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Deliveries.STATUS))];
        leaveTime = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(Deliveries.LEAVE_TIME)));
        arriveTime = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(Deliveries.ARRIVAL_TIME)));
    }

    public long getId() {
        return id;
    }

    public Deliveries.Status getStatus() {
        return status;
    }

    public void setStatus(Deliveries.Status status) {
        this.status = status;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Deliveries.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, status.ordinal());
        statement.bindLong(1, leaveTime.getTime());
        statement.bindLong(2, arriveTime.getTime());
        statement.bindLong(3, deliveryMan.getReviewable().getId());
        statement.bindLong(4, bill.getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Deliveries.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(5, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Deliveries.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
