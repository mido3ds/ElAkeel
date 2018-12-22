package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import cufe.cmp.db.elakeel.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Login = findViewById(R.id.btnLogin);
        Login.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "After login in ", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(LoginActivity.this, AfterLoginActivity.class));
        });
    }

}
