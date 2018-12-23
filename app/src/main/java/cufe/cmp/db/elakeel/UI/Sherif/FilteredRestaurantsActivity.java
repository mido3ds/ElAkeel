package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.Hossam.RestaurantMenuActivity;

import java.util.ArrayList;

public class FilteredRestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_restaurants);

        ArrayList<FilteredRestaurant> FilteredRestaurants = new ArrayList<FilteredRestaurant>();
        final ListView List = (ListView) findViewById(R.id.ListOfFilteredRestaurants);
        final FilteredRestaurantAdapter FilteredRestaurantAdapter = new FilteredRestaurantAdapter(this,FilteredRestaurants);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FilteredRestaurant FilteredRestaurant = FilteredRestaurantAdapter.getItem(position);
                Intent ReviewOrderIntent = new Intent(FilteredRestaurantsActivity.this , RestaurantMenuActivity.class);//go to hossam's menu (selected restaurat menu)
                startActivity(ReviewOrderIntent);
            }
        });

//        List.setAdapter(PendingOrdersAdapter);
    }
}
