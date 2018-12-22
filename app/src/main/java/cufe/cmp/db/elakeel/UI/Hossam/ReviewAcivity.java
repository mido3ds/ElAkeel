package cufe.cmp.db.elakeel.UI.Hossam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class ReviewAcivity extends AppCompatActivity {

    private int RestaurantRate;
    private int ChefRate;
    private int DeliveryRate;
    private String RestaurantName;
    private String ChefName;
    private String DeliveryManName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_acivity);

        TextView RestaurantNameTextView = findViewById(R.id.Restuarant_Name);
        RestaurantNameTextView.setText(RestaurantName);

        TextView ChefNameTextView = findViewById(R.id.Chef_Name);
        ChefNameTextView.setText(ChefName);

        TextView DeliveryManNameTextView = findViewById(R.id.Delivery_Man_Name);
        DeliveryManNameTextView.setText(DeliveryManName);

        ArrayList<OrderListItem> OrderListItems = new ArrayList<OrderListItem>();
        final ListView List = findViewById(R.id.Order_Elements);
        final OrderItemListAdapter OrderListItemsItem = new OrderItemListAdapter(this, OrderListItems);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {
                OrderListItem OrderListItem = OrderListItemsItem.getItem(position);
            }
        });


        List.setAdapter(OrderListItemsItem);

        Button BackToOrdersbtn = findViewById(R.id.Back_TO_orders_List);
        BackToOrdersbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(ReviewAcivity.this, AfterLoginActivity.class);
                startActivity(numbersIntent);

            }
        });


    }

}


