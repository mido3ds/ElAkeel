package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import cufe.cmp.db.elakeel.Data.Entities.Order;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;
import cufe.cmp.db.elakeel.UI.Sherif.FiltrationActivity;

import java.util.ArrayList;

public class AfterLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Customer customer = (Customer) getIntent().getSerializableExtra(Customer.class.getName());
        ArrayList<Order> orders = customer.getOrders();

        ListView listView = findViewById(R.id.Prev_orders_List_view);
        PrevOrdersAdapter prevOrdersAdapter = new PrevOrdersAdapter(this, orders, customer);
        listView.setAdapter(prevOrdersAdapter);

        Button makeneworder = findViewById(R.id.MakeNewOrderButton);
        makeneworder.setOnClickListener(v -> {
            Intent neworderIntent = new Intent(AfterLoginActivity.this, FiltrationActivity.class);
            neworderIntent.putExtra(customer.getClass().getName(), customer);
            startActivity(neworderIntent);
        });
    }
}

