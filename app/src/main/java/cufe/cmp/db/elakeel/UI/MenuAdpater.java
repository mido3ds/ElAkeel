package cufe.cmp.db.elakeel.UI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class MenuAdpater extends ArrayAdapter<MenuElement> {
    public MenuAdpater(Activity context, ArrayList<MenuElement> MenuItems) {
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
                    R.layout.content_menu__list__view, parent, false);
        }
        //layoutinflater dh by7wl el layout dh l actual views ely gwah we y7tohom 3la el activity

        // Get the {@link AndroidFlavor} object located at this position in the list
        MenuElement currentMenuItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MenuItemNameTextView = (TextView) listItemView.findViewById(R.id.MealNameINOrderList);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MenuItemNameTextView.setText(currentMenuItem.getElemwntName());

        TextView MenuItemPriceTextView = (TextView) listItemView.findViewById(R.id.Meal_Price);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MenuItemPriceTextView.setText(currentMenuItem.getELementprice());


        ImageView MealPicImageView = (ImageView) listItemView.findViewById(R.id.Image);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MealPicImageView.setImageResource(currentMenuItem.getPic());

        Button addElementbtn = (Button) listItemView.findViewById(R.id.addMealToOrder);
        addElementbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return listItemView;
    }

}
