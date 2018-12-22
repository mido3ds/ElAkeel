package cufe.cmp.db.elakeel.UI.hossam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login = (Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "After login in ", Toast.LENGTH_SHORT).show();

                Intent AfterLoginIntent = new Intent(Login.this, AfterLogin.class);
                startActivity(AfterLoginIntent);
            }
        });


    }

}
