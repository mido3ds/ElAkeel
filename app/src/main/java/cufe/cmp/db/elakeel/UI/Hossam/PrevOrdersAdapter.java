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
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class PrevOrdersAdapter extends ArrayAdapter<Order> {
    public PrevOrdersAdapter(Activity context, ArrayList<Order> orders) {
        super(context, 0, orders);
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
        restautantNameTextView.setText(order.getRestaurant().getName());

        TextView orderDAteTextView = listItemView.findViewById(R.id.OrderDate);
        orderDAteTextView.setText(order.getTime().toString());

        Button revieworderbtn = listItemView.findViewById(R.id.ReviewOrder);
        revieworderbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ReviewAcivity.class);
            intent.putExtra(Order.class.getName(), order);
            getContext().startActivity(intent);
        });

        return listItemView;
    }
}
