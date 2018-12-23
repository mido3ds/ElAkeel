package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cufe.cmp.db.elakeel.Data.Entities.Users.Admin;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.Data.Entities.Users.RestaurantManager;
import cufe.cmp.db.elakeel.Data.Entities.Users.User;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.Sherif.AdminFunctionalitiesActivity;
import cufe.cmp.db.elakeel.UI.Sherif.ManagerActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Login = findViewById(R.id.btnLogin);
        Login.setOnClickListener(view -> {
            try {
                String username = ((TextView) findViewById(R.id.edt_userName)).getText().toString();
                String password = ((TextView) findViewById(R.id.passwordEditView)).getText().toString();
                User user = User.getUser(username, password);

                switch (user.getType()) {
                    case Customer: {
                        Customer customer = Customer.from(user);
                        Intent intent = new Intent(LoginActivity.this, AfterLoginActivity.class);
                        intent.putExtra(customer.getClass().getName(), customer);
                        startActivity(intent);
                        break;
                    }
                    case RestaurantManager: {
                        RestaurantManager manager = RestaurantManager.from(user);
                        Intent intent = new Intent(this, ManagerActivity.class);
                        intent.putExtra(manager.getClass().getName(), manager);
                        startActivity(intent);
                        break;
                    }
                    case Admin: {
                        Admin admin = Admin.from(user);
                        Intent intent = new Intent(this, AdminFunctionalitiesActivity.class);
                        intent.putExtra(admin.getClass().getName(), admin);
                        startActivity(intent);
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "User name or password is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
