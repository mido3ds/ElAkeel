package cufe.cmp.db.elakeel.UI.sherif;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {

    public MenuAdapter(Activity context, ArrayList<MenuItem> chefs) {
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
                    R.layout.activity_menu_list_view_item, parent, false);
        }
        //layoutinflater dh by7wl el layout dh l actual views ely gwah we y7tohom 3la el activity

        // Get the {@link AndroidFlavor} object located at this position in the list
        MenuItem currentMenuItem = getItem(position);

        EditText ItemName = listItemView.findViewById(R.id.ItemName);
        ItemName.setText(currentMenuItem.getItemName());

        EditText ItemPrice = listItemView.findViewById(R.id.ItemPrice);
        ItemPrice.setText(currentMenuItem.getPrice());

        EditText ItemTrend = listItemView.findViewById(R.id.ItemTrend);
        ItemName.setText(currentMenuItem.getTrend() + " in Trend");


        EditText Ingredients = listItemView.findViewById(R.id.ItemIngrediants);
        Ingredients.setText(currentMenuItem.getIngredients());

        Button Delete = listItemView.findViewById(R.id.Delete);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
