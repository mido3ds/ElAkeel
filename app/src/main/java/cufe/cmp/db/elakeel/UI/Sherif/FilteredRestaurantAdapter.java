package cufe.cmp.db.elakeel.UI.Sherif;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class FilteredRestaurantAdapter extends ArrayAdapter<FilteredRestaurant> {
    public FilteredRestaurantAdapter(Activity context, ArrayList<FilteredRestaurant> PendingOrders) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null)//lw mfesh view n3rf n reuse
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_filtered_restaurants_item, parent, false);
        }
        //layoutinflater dh by7wl el layout dh l actual views ely gwah we y7tohom 3la el activity

        // Get the {@link AndroidFlavor} object located at this position in the list
        FilteredRestaurant currentFilteredRestaurant = getItem(position);

        TextView RestaurantName =(TextView) listItemView.findViewById(R.id.FilteredRestaurantName);
        RestaurantName.setText(currentFilteredRestaurant.getRestaurantName());

        return listItemView;
    }
}
