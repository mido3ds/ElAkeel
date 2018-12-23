package cufe.cmp.db.elakeel.UI.Sherif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

public class FilterationActivity extends AppCompatActivity {
    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filteration);

        customer = (Customer) getIntent().getSerializableExtra(Customer.class.getName());

        // TODO: 23/12/2018
    }
}
