package cufe.cmp.db.elakeel.UI.Sherif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cufe.cmp.db.elakeel.Data.Entities.Users.RestaurantManager;
import cufe.cmp.db.elakeel.R;

public class ManagerActivity extends AppCompatActivity {
    private RestaurantManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        manager = (RestaurantManager) getIntent().getSerializableExtra(RestaurantManager.class.getName());
    }
}
