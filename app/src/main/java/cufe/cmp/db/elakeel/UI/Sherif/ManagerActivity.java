package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cufe.cmp.db.elakeel.Data.Entities.Users.RestaurantManager;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.StatisticsActivity;

public class ManagerActivity extends AppCompatActivity {
    private RestaurantManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        manager = (RestaurantManager) getIntent().getSerializableExtra(RestaurantManager.class.getName());

        findViewById(R.id.UpdateMenu).setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra(manager.getClass().getName(), manager);
            startActivity(intent);
        });

        findViewById(R.id.UpdateRestaurantInfo).setOnClickListener(v -> {
            Intent intent = new Intent(this, AddRestaurantActivity.class);
            intent.putExtra(manager.getClass().getName(), manager);
            startActivity(intent);
        });

        findViewById(R.id.GetOrders).setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuListViewItemActivity.class);
            intent.putExtra(manager.getClass().getName(), manager);
            startActivity(intent);
        });

        findViewById(R.id.ViewStatistics).setOnClickListener(v -> {
            Intent intent = new Intent(this, StatisticsActivity.class);
            intent.putExtra(manager.getClass().getName(), manager);
            startActivity(intent);
        });

        findViewById(R.id.ViewRates).setOnClickListener(v -> {
            Intent intent = new Intent(this, mm.class);// TODO: 23/12/2018
            intent.putExtra(manager.getClass().getName(), manager);
            startActivity(intent);
        });
    }
}
