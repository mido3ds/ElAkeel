package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import cufe.cmp.db.elakeel.Data.Entities.Users.Admin;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.StatisticsActivity;

public class AdminFunctionalitiesActivity extends AppCompatActivity {
    private Button AddRestaurant;
    private Button AddAdmin;
    private Button ViewStatistics;
    private Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functionalities);

        admin = (Admin) getIntent().getSerializableExtra(Admin.class.getName());

        AddRestaurant = findViewById(R.id.AddRestaurant);
        AddRestaurant.setOnClickListener(v -> {
            Intent I = new Intent(AdminFunctionalitiesActivity.this, AddRestaurantActivity.class);
            startActivity(I);
        });

        AddAdmin = findViewById(R.id.AddAdmin);
        AddAdmin.setOnClickListener(v -> {
            Intent I = new Intent(AdminFunctionalitiesActivity.this, AddAdminActivity.class);
            startActivity(I);
        });

        ViewStatistics = findViewById(R.id.ViewStatistics);
        ViewStatistics.setOnClickListener(v -> {
            Intent i = new Intent(this, StatisticsActivity.class);
            startActivity(i);
        });
    }
}
