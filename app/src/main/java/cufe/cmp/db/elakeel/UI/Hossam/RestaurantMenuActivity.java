package cufe.cmp.db.elakeel.UI.Hossam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Meal;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;
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

        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra(Restaurant.class.getName());

        ArrayList<Meal> MenuElements = restaurant.getAllMeals();
        final ListView List = findViewById(R.id.Menu_List_view);
        final MenuAdpater MenuElementsItem = new MenuAdpater(this, MenuElements);
        List.setAdapter(MenuElementsItem);

        Button Confirmbtn = findViewById(R.id.ConfirmOrder);
        Confirmbtn.setOnClickListener(v -> {
            //Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
            //intent.putExtra("EXTRA_Selected_Meals", SelectedMeals);//el mfrod hna ab3t el arraylist ely fo2 de
            //startActivity(intent);
            // el mfrod hna signoutActivity dh ykon el activty ely m7tag akon 3arf feh asm el order ely a5taro
        });
    }

    private static class MenuAdpater extends ArrayAdapter<Meal> {
        public MenuAdpater(Activity context, ArrayList<Meal> MenuItems) {
            super(context, 0, MenuItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.content_menu__list__view, parent, false);
            }

            Meal currentMenuItem = getItem(position);

            TextView MenuItemNameTextView = listItemView.findViewById(R.id.MealNameINOrderList);
            MenuItemNameTextView.setText(currentMenuItem.getName());

            TextView MenuItemPriceTextView = listItemView.findViewById(R.id.Meal_Price);
            MenuItemPriceTextView.setText(Double.toString(currentMenuItem.getPrice()));

            ImageView MealPicImageView = listItemView.findViewById(R.id.Image);
            MealPicImageView.setImageBitmap(currentMenuItem.getImage());

            Button addElementbtn = listItemView.findViewById(R.id.addMealToOrder);
            addElementbtn.setOnClickListener(v -> {

            });

            return listItemView;
        }
    }
}
