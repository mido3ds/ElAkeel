package cufe.cmp.db.elakeel.Data.Entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Reviewable;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;

import java.util.Date;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Reviews;

public class Review implements Entity {
    private long id;
    private int stars;
    private String comment;
    private Date time;
    private Reviews.Status status;
    private Customer customer;
    private Reviewable reviewable;

    public Review(int stars, String comment, Date time, Reviews.Status status, Customer customer, Reviewable reviewable) {
        this.stars = stars;
        this.comment = comment;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.reviewable = reviewable;
    }

    public Review(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Reviews.ID));
        stars = cursor.getInt(cursor.getColumnIndexOrThrow(Reviews.STARS));
        comment = cursor.getString(cursor.getColumnIndexOrThrow(Reviews.COMMENT));
        time = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(Reviews.TIME)));
        status = Reviews.Status.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Reviews.STATUS))];
        customer = new Customer(cursor);
        reviewable = new Reviewable(cursor);
    }

    public long getId() {
        return id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Reviews.Status getStatus() {
        return status;
    }

    public void setStatus(Reviews.Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reviewable getReviewable() {
        return reviewable;
    }

    public void setReviewable(Reviewable reviewable) {
        this.reviewable = reviewable;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviews.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindLong(0, stars);
        statement.bindString(1, comment);
        statement.bindLong(2, time.getTime());
        statement.bindLong(3, status.ordinal());
        statement.bindLong(4, customer.getUser().getId());
        statement.bindLong(5, reviewable.getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviews.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(6, id);
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Reviews.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
