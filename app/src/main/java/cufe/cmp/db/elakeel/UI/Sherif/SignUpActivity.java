package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        ProfilePic = findViewById(R.id.Image);
        PhoneNo = findViewById(R.id.PhoneNo);
        Region = findViewById(R.id.Region);
        StreetNo = findViewById(R.id.StreetNo);
        BuildingNo = findViewById(R.id.BuildingNo);
        PaymentType = findViewById(R.id.PaymentType);
        CardNo = findViewById(R.id.CardNo);
        SecurityCode = findViewById(R.id.SecurityCode);
        ExpireDate = findViewById(R.id.ExpireDate);

        ProfilePic.setOnClickListener(v -> pickImage());

//        String email1 = email.getText().toString();
//        String password1 = password.getText().toString();
//        String fname = FirstName.getText().toString();
//        String lname = LastName.getText().toString();
//        int cardNo;
//        int securityCode;
//        String phoneNo = PhoneNo.getText().toString();
//        String region = Region.getSelectedItem().toString();
//        int street = Integer.parseInt(StreetNo.getText().toString());
//        int building = Integer.parseInt(BuildingNo.getText().toString());
//        String expire = ExpireDate.getText().toString();
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
                Bitmap newProfilePic = extras.getParcelable("data");
            }
        }
    }

}
