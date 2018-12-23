package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import cufe.cmp.db.elakeel.Data.Database.DbConstants;
import cufe.cmp.db.elakeel.Data.Database.DbConstants.Customers;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.Data.Entities.Users.User;
import cufe.cmp.db.elakeel.R;

public class SignUpActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText FirstName;
    private EditText LastName;
    private Button ProfilePic;
    private EditText PhoneNo;
    private Spinner Region;
    private EditText StreetNo;
    private EditText BuildingNo;
    private Spinner PaymentType;
    private EditText CardNo;
    private EditText SecurityCode;
    private EditText ExpireDate;

    private Bitmap image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Region = findViewById(R.id.Region);
        ArrayAdapter<CharSequence> regAdapter = ArrayAdapter.createFromResource(this, R.array.Region_array, android.R.layout.simple_spinner_item);
        regAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Region.setAdapter(regAdapter);

        PaymentType = findViewById(R.id.PaymentType);
        ArrayAdapter<CharSequence> payAdapter = ArrayAdapter.createFromResource(this, R.array.PaymentType_array, android.R.layout.simple_spinner_item);
        payAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PaymentType.setAdapter(payAdapter);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        ProfilePic = findViewById(R.id.Image);
        PhoneNo = findViewById(R.id.PhoneNo);
        StreetNo = findViewById(R.id.StreetNo);
        BuildingNo = findViewById(R.id.BuildingNo);
        CardNo = findViewById(R.id.CardNo);
        SecurityCode = findViewById(R.id.SecurityCode);
        ExpireDate = findViewById(R.id.ExpireDate);

        ProfilePic.setOnClickListener(v -> pickImage());

        findViewById(R.id.signUpBtn).setOnClickListener(v -> {
            String email1 = email.getText().toString();
            String password1 = password.getText().toString();
            String fname = FirstName.getText().toString();
            String lname = LastName.getText().toString();
            String cardNo = CardNo.getText().toString();
            String securityCode = SecurityCode.getText().toString();
            String phoneNo = PhoneNo.getText().toString();
            String region = Region.getSelectedItem().toString();
            String street = StreetNo.getText().toString();
            String building = BuildingNo.getText().toString();
            String expire = ExpireDate.getText().toString();

            Customers.PaymentMethod paymentMethod = Customers.PaymentMethod.CreditCard;
            switch (PaymentType.getSelectedItemPosition()) {
                case 0:
                    paymentMethod = Customers.PaymentMethod.CreditCard;
                    break;
                case 1:
                    paymentMethod = Customers.PaymentMethod.Cash;
                    break;
            }

            if (email1 == null || password1 == null || fname == null || lname == null || phoneNo == null || region == null || street == null
            || building == null) {
                Toast.makeText(this, "Invalid or incomplete info", Toast.LENGTH_SHORT).show();
                return;
            }

            if (paymentMethod == Customers.PaymentMethod.CreditCard) {
                if (expire == null || cardNo == null || securityCode == null) {
                    Toast.makeText(this, "Invalid or incomplete info", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            User user = new User(fname + " " + lname, email1, password1, image, DbConstants.Users.Type.Customer);
            Customer customer = new Customer(user, phoneNo, region, street, building, 0, paymentMethod, cardNo, securityCode, expire);

            if (!user.insert()) {
                Toast.makeText(this, "Error in inserting user", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!customer.insert()) {
                Toast.makeText(this, "Error in inserting customer", Toast.LENGTH_SHORT).show();
                user.delete();
                return;
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
                //Get image
                image = extras.getParcelable("data");
            }
        }
    }

}
