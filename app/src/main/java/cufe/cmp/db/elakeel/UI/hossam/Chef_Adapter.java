package cufe.cmp.db.elakeel.UI.hossam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class Chef_Adapter extends ArrayAdapter<Chef> {
    public Chef_Adapter(Activity context, ArrayList<Chef> chefs) {
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
                    R.layout.content_chefs_list_view, parent, false);
        }
        //layoutinflater dh by7wl el layout dh l actual views ely gwah we y7tohom 3la el activity

        // Get the {@link AndroidFlavor} object located at this position in the list
        Chef currentChef = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView ChefnationalityTextView = listItemView.findViewById(R.id.chef_nationality);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        ChefnationalityTextView.setText(currentChef.getChef_nationality());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView ChefNameTextView = listItemView.findViewById(R.id.Chef_Name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        ChefNameTextView.setText(currentChef.getChef_Name());

        Button SelectChefbtn = listItemView.findViewById(R.id.ChefSelect);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
