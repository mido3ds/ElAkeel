package cufe.cmp.db.elakeel.Data.Entities.Users;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cufe.cmp.db.elakeel.Data.Entities.Entity;
import cufe.cmp.db.elakeel.Data.Utility.PasswordAuthentication;

import static cufe.cmp.db.elakeel.Data.Database.DbConstants.Users;

public class User extends Entity {
    private static final PasswordAuthentication PASSWORD_AUTHENTICATION = new PasswordAuthentication();

    private long id;
    private String name;
    private String email;
    private String hashedPassword;
    private byte[] image;
    private Users.Type type;

    public User(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(Users.ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(Users.NAME));
        email = cursor.getString(cursor.getColumnIndexOrThrow(Users.EMAIL));
        hashedPassword = cursor.getString(cursor.getColumnIndexOrThrow(Users.PASSWORD));
        image = cursor.getBlob(cursor.getColumnIndexOrThrow(Users.IMAGE));
        type = Users.Type.values()[cursor.getInt(cursor.getColumnIndexOrThrow(Users.TYPE))];
    }

    public User(String name, String email, String password, byte[] image, Users.Type type) {
        this.name = name;
        this.email = email;
        setPassword(password);
        this.image = image;
        this.type = type;
    }

    public static User getUser(String username, String password) throws Exception {
        return null;// TODO: 23/12/2018
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean authenticate(String password) {
        return PASSWORD_AUTHENTICATION.authenticate(password.toCharArray(), hashedPassword);
    }

    public void setPassword(String password) {
        if (password.isEmpty()) throw new IllegalArgumentException("Password is empty");

        this.hashedPassword = PASSWORD_AUTHENTICATION.hash(password.toCharArray());
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Users.Type getType() {
        return type;
    }

    public void setType(Users.Type type) {
        this.type = type;
    }

    private void bindData(SQLiteStatement statement) {
        statement.bindString(0, name);
        statement.bindString(1, email);
        statement.bindString(2, hashedPassword);
        statement.bindBlob(3, image);
        statement.bindLong(4, type.ordinal());
    }

    @Override
    public boolean insert() {
        SQLiteStatement statement = db.compileStatement(Users.SQL_INSERT);
        bindData(statement);
        id = statement.executeInsert();
        return id != -1;
    }

    @Override
    public boolean update() {
        SQLiteStatement statement = db.compileStatement(Users.SQL_UPDATE_ALL);
        bindData(statement);
        statement.bindLong(5, id);
        return statement.executeUpdateDelete() == 1;
    }

    @Override
    public boolean delete() {
        SQLiteStatement statement = db.compileStatement(Users.SQL_DELETE);
        statement.bindLong(0, id);
        return statement.executeUpdateDelete() == 1;
    }
}
