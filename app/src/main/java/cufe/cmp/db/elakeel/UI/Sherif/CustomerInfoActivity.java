package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import cufe.cmp.db.elakeel.R;

public class CustomerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        Button Return = (Button) findViewById(R.id.CustomerInfoReturn);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(CustomerInfoActivity.this,GetOrders.class);
                startActivity(I);
            }
        });
    }
}
