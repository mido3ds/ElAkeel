package cufe.cmp.db.elakeel.Data.Entities.Users;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Admins;
import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Users;

public class Admin implements Entity {
    private User user;
    private Admins.Rank rank;

    public Admin(User user, Admins.Rank rank) {
        if (user.getType() != Users.Type.Admin) throw new IllegalArgumentException("user not admin");

        this.user = user;
        this.rank = rank;
    }

    public Admin(Cursor cursor) {
        user = new User(cursor);
        rank = Admins.Rank.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Admins.RANK))];
    }

    public static Admin from(User user) {
        return null; // TODO: 23/12/2018
    }

    public User getUser() {
        return user;
    }

    public Admins.Rank getRank() {
        return rank;
    }

    public void setRank(Admins.Rank rank) {
        this.rank = rank;
    }

    @Override
    public boolean insert(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Admins.SQL_INSERT);
        statement.bindLong(0, rank.ordinal());
        statement.bindLong(1, user.getId());
        return statement.executeInsert() != -1;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        SQLiteStatement statement = db.compileStatement(Admins.SQL_UPDATE_ALL);
        statement.bindLong(0, rank.ordinal());
        statement.bindLong(1, user.getId());
        return statement.executeUpdateDelete() != 0;
    }

    @Override
    public boolean delete(SQLiteDatabase db) {
        return user.delete(db);
    }
}
