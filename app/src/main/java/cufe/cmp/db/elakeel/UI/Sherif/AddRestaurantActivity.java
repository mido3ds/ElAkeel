package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import cufe.cmp.db.elakeel.Data.Database.DbConstants;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;
import cufe.cmp.db.elakeel.R;

public class AddRestaurantActivity extends AppCompatActivity {
    private Bitmap image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        EditText nameEditText = findViewById(R.id.Name);
        Spinner servTypeSpinner = findViewById(R.id.serviceType);
        EditText restPhoneNo = findViewById(R.id.RestaurantPhoneNo);
        Spinner regSpinner = findViewById(R.id.RestaurantRegion);
        EditText streetNoEditText = findViewById(R.id.RestaurantStreetNo);
        EditText buildNoEditText = findViewById(R.id.RestaurnatBuildingNo);

        findViewById(R.id.RestaurantImage).setOnClickListener(v -> pickImage());
        findViewById(R.id.addRestaurant).setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            if (name == null) {
                Toast.makeText(this, "some info is invalid or missing", Toast.LENGTH_SHORT).show();
                return;
            }

            DbConstants.Restaurants.ServiceType serviceType = DbConstants.Restaurants.ServiceType.Food;
            switch (servTypeSpinner.getSelectedItemPosition()) {
                case 0:
                    serviceType = DbConstants.Restaurants.ServiceType.Food;
                    break;
                case 1:
                    serviceType = DbConstants.Restaurants.ServiceType.Drinks;
                    break;
            }

            String phoneNo = restPhoneNo.getText().toString();
            if (phoneNo == null) {
                Toast.makeText(this, "some info is invalid or missing", Toast.LENGTH_SHORT).show();
                return;
            }

            String buildNo = buildNoEditText.getText().toString();
            if (buildNo == null) {
                Toast.makeText(this, "some info is invalid or missing", Toast.LENGTH_SHORT).show();
                return;
            }

            String region = ((String) regSpinner.getSelectedItem());
            String streetNo = streetNoEditText.getText().toString();
            if (streetNo == null) {
                Toast.makeText(this, "some info is invalid or missing", Toast.LENGTH_SHORT).show();
                return;
            }

            Restaurant restaurant = new Restaurant(name, serviceType, image, phoneNo);
            if (!restaurant.insert()) {
                Toast.makeText(this, "error, couldn't insert restaurant", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == 1) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                image = extras.getParcelable("data");
            }
        }
    }
}
