package cufe.cmp.db.elakeel.UI.Hossam;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import cufe.cmp.db.elakeel.Data.Entities.Order;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class PrevOrdersAdapter extends ArrayAdapter<Order> {
    private final Customer customer;

    public PrevOrdersAdapter(Activity context, ArrayList<Order> orders, Customer customer) {
        super(context, 0, orders);
        this.customer = customer;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_prev_orders_list__view, parent, false);
        }

        Order order = getItem(position);

        TextView restautantNameTextView = listItemView.findViewById(R.id.Restuarant_Name);
        restautantNameTextView.setText(order.getRestaurants().get(0).getName());

        TextView orderDAteTextView = listItemView.findViewById(R.id.OrderDate);
        orderDAteTextView.setText(order.getTime().toString());

        Button revieworderbtn = listItemView.findViewById(R.id.ReviewOrder);
        revieworderbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ReviewActivity.class);
            intent.putExtra(order.getClass().getName(), order);
            intent.putExtra(customer.getClass().getName(), customer);
            getContext().startActivity(intent);
        });

        return listItemView;
    }
}
