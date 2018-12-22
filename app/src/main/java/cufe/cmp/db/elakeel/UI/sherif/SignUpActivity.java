package cufe.cmp.db.elakeel.UI.sherif;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

public class SignUpActivity extends AppCompatActivity {
    EditText email;
    String Email;
    EditText password;
    String Password;
    EditText FirstName;
    String Fname;
    EditText LastName;
    String Lname;
    Button ProfilePic;
    EditText PhoneNo;
    String phoneNo;
    Spinner Region;
    String region;
    EditText StreetNo;
    int street;
    EditText BuildingNo;
    int building;
    Spinner PaymentType;
    EditText CardNo;
    int cardNo;
    EditText SecurityCode;
    int securityCode;
    EditText ExpireDate;
    String expire;

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
        Email = email.getText().toString();
        Password = password.getText().toString();
        Fname = FirstName.getText().toString();
        Lname = LastName.getText().toString();
        ProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });
        phoneNo = PhoneNo.getText().toString();
        region = Region.getSelectedItem().toString();
        street = Integer.parseInt(StreetNo.getText().toString());
        building = Integer.parseInt(BuildingNo.getText().toString());
        expire = ExpireDate.getText().toString();
    }

    public final void pickImage() {
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
