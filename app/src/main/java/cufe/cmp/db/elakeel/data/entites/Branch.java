package cufe.cmp.db.elakeel.data.entites;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.data.entites.reviewable.Restaurant;

import static cufe.cmp.db.elakeel.data.database.DbConstants.Branches;

public class Branch implements Entity {
    private long id;
    private String region;
    private String streetNo;
    private String buildingNo;
    private Restaurant restaurant;

    public Branch(String region, String streetNo, String buildingNo, Restaurant restaurant) {
        this.region = region;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.restaurant = restaurant;
    }

    public Branch(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Branches.ID));
        region = cursor.getString(cursor.getColumnIndexOrThrow(Branches.REGION));
        streetNo = cursor.getString(cursor.getColumnIndexOrThrow(Branches.STREET_NO));
        buildingNo = cursor.getString(cursor.getColumnIndexOrThrow(Branches.BUILDING_NO));
        restaurant = new Restaurant(cursor);
    }

    public long getId() {
        return id;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Branches.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, region);
        statement.bindString(1, streetNo);
        statement.bindString(2, buildingNo);
        statement.bindLong(3, restaurant.getReviewable().getId());
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement sqLiteStatement = db.compileStatement(Branches.SQL_UPDATE_ALL);
        bindData(sqLiteStatement);
        sqLiteStatement.bindLong(4, id);
        return sqLiteStatement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Branches.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() != 0;
    }
}
