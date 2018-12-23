package cufe.cmp.db.elakeel.UI.Hossam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class RestaurantMenuActivity extends AppCompatActivity {
    ArrayList<MealActivity> OrderList = new ArrayList<MealActivity>();

    public ArrayList<MealActivity> getOrderList() {
        return OrderList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant__menu);

        ArrayList<MenuElement> MenuElements = new ArrayList<MenuElement>();
        final ListView List = findViewById(R.id.Menu_List_view);

        final MenuAdpater MenuElementsItem = new MenuAdpater(this, MenuElements);

        List.setAdapter(MenuElementsItem);

        Button Confirmbtn = findViewById(R.id.ConfirmOrder);
        Confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
                //intent.putExtra("EXTRA_Selected_Meals", SelectedMeals);//el mfrod hna ab3t el arraylist ely fo2 de
                //startActivity(intent);
                // el mfrod hna signoutActivity dh ykon el activty ely m7tag akon 3arf feh asm el order ely a5taro
            }
        });
    }

    private static class MenuAdpater extends ArrayAdapter<MenuElement> {
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
            TextView MenuItemNameTextView = listItemView.findViewById(R.id.MealNameINOrderList);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            MenuItemNameTextView.setText(currentMenuItem.getElemwntName());

            TextView MenuItemPriceTextView = listItemView.findViewById(R.id.Meal_Price);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            MenuItemPriceTextView.setText(currentMenuItem.getELementprice());


            ImageView MealPicImageView = listItemView.findViewById(R.id.Image);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            MealPicImageView.setImageResource(currentMenuItem.getPic());

            Button addElementbtn = listItemView.findViewById(R.id.addMealToOrder);
            addElementbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            return listItemView;
        }

    }
}
