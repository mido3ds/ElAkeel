package cufe.cmp.db.elakeel.UI.sherif;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

public class MainActivity extends AppCompatActivity {
    Button SignUP;
    Button LogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogIn = (Button)findViewById(R.id.MainLogIn);
        SignUP = (Button)findViewById(R.id.MainSignUp);
        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(I);
            }
        });
    }
}
