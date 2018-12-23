package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import cufe.cmp.db.elakeel.Data.Database.DbConstants.Restaurants;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class FiltrationActivity extends AppCompatActivity {
    private Customer customer;
    private Restaurants.ServiceType serviceType = Restaurants.ServiceType.Drinks;
    private String region = "Cairo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filteration);

        customer = (Customer) getIntent().getSerializableExtra(Customer.class.getName());

        ArrayAdapter<CharSequence> servAdapter = ArrayAdapter.createFromResource(this, R.array.ServiceType_array, android.R.layout.simple_spinner_item);
        servAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner servSpinner = (Spinner) findViewById(R.id.ServiceType);
        servSpinner.setAdapter(servAdapter);
        servSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        serviceType = Restaurants.ServiceType.Drinks;
                        break;
                    case 0:
                        serviceType = Restaurants.ServiceType.Food;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> regAdapter = ArrayAdapter.createFromResource(this, R.array.Region_array, android.R.layout.simple_spinner_item);
        regAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner regSpinner = (Spinner) findViewById(R.id.Region);
        regSpinner.setAdapter(regAdapter);
        regSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                region = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.Filter).setOnClickListener(v -> {
            ArrayList<Restaurant> restaurants = Restaurant.getRestaurants(serviceType, region);
            if (restaurants.isEmpty()) {
                Toast.makeText(this, "No matching!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, FilterationActivity.class);// TODO: 23/12/2018 from sherif
            intent.putExtra(customer.getClass().getName(), customer);
            intent.putExtra("restaurants", restaurants);
            startActivity(intent);
        });
    }
}
