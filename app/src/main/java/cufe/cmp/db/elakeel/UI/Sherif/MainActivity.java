package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.Hossam.LoginActivity;

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
