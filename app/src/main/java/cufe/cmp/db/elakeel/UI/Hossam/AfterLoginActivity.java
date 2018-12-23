package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import cufe.cmp.db.elakeel.Data.Entities.Order;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class AfterLoginActivity extends AppCompatActivity {
    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        customer = (Customer) getIntent().getSerializableExtra(Customer.class.getName());

        ArrayList<Order> prevOrders = customer.getOrders();
        final ListView List = findViewById(R.id.Prev_orders_List_view);
        final PrevOrdersAdapter prevOrdersAdapter = new PrevOrdersAdapter(this, prevOrders);
        List.setOnItemClickListener((adapterView, view, position, ID) -> {
            Order prevOrder = prevOrdersAdapter.getItem(position);
            Intent intent = new Intent(AfterLoginActivity.this, ReviewAcivity.class);
            intent.putExtra(Order.class.getName(), prevOrder);
            startActivity(intent);
        });
        List.setAdapter(prevOrdersAdapter);

        Button makeneworder = findViewById(R.id.MakeNewOrderButton);
        makeneworder.setOnClickListener(v -> {
            //intent to open Restaurants list
            // TODO: 23/12/2018 what activity?
            Intent neworderIntent = new Intent(AfterLoginActivity.this, ReviewAcivity.class);
            startActivity(neworderIntent);
        });
    }
}

