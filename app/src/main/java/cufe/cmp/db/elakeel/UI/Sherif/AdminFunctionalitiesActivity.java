package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import cufe.cmp.db.elakeel.R;

public class AdminFunctionalitiesActivity extends AppCompatActivity {
    Button AddRestaurant;
    Button AddAdmin;
    Button ViewStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functionalities);
        AddRestaurant = findViewById(R.id.AddRestaurant);
        AddAdmin = findViewById(R.id.AddAdmin);
        ViewStatistics = findViewById(R.id.ViewStatistics);
        AddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminFunctionalitiesActivity.this, AddRestaurantActivity.class);
                startActivity(I);
            }
        });
        AddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminFunctionalitiesActivity.this, AddAdminActivity.class);
                startActivity(I);
            }
        });
    }
}
