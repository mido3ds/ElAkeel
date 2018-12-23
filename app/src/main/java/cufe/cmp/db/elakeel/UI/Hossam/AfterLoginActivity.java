package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import cufe.cmp.db.elakeel.Data.Entities.Users.User;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class AfterLoginActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        user = ((User) getIntent().getSerializableExtra("user"));

        ArrayList<Order> prevOrders = new ArrayList<Order>();
        final ListView List = findViewById(R.id.Prev_orders_List_view);
        final PrevOrdersAdapter prevOrdersAdapter = new PrevOrdersAdapter(this, prevOrders);
        List.setOnItemClickListener((adapterView, view, position, ID) -> {
            Order prevOrder = prevOrdersAdapter.getItem(position);
            Intent ReviewOrderIntent = new Intent(AfterLoginActivity.this, ReviewAcivity.class);
            startActivity(ReviewOrderIntent);
        });
        List.setAdapter(prevOrdersAdapter);

        Button makeneworder = findViewById(R.id.MakeNewOrderButton);
        makeneworder.setOnClickListener(v -> {
            //intent to open Restaurants list
            Intent neworderIntent = new Intent(AfterLoginActivity.this, ReviewAcivity.class);
            startActivity(neworderIntent);
        });
    }
}

