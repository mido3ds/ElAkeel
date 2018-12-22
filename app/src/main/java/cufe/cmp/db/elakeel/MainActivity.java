package cufe.cmp.db.elakeel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.ui.LoginActivity;
import cufe.cmp.db.elakeel.ui.SignUpActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logIn = findViewById(R.id.MainLogIn);
        logIn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        Button signUP = findViewById(R.id.MainSignUp);
        signUP.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));
    }
}
