package cufe.cmp.db.elakeel.UI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class OrderItemListAdapter extends ArrayAdapter<OrderListItem> {
    public OrderItemListAdapter(Activity context, ArrayList<OrderListItem> OrdersItems) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null)//lw mfesh view n3rf n reuse
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_meal__rate__list_view, parent, false);
        }
        //layoutinflater dh by7wl el layout dh l actual views ely gwah we y7tohom 3la el activity

        // Get the {@link AndroidFlavor} object located at this position in the list
        OrderListItem currentReviewedOrderItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MealNameTextView = (TextView) listItemView.findViewById(R.id.ReviewedMealName);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MealNameTextView.setText(currentReviewedOrderItem.getMealName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        RatingBar RateRatingBar = (RatingBar) listItemView.findViewById(R.id.MealRate);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        currentReviewedOrderItem.setRate((int) RateRatingBar.getRating());

        return listItemView;
    }

}
