package cufe.cmp.db.elakeel.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class Restuarant_Menu extends AppCompatActivity {
    ArrayList<Meal> OrderList = new ArrayList<Meal>();

    public ArrayList<Meal> getOrderList() {
        return OrderList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant__menu);

        ArrayList<MenuElement> MenuElements = new ArrayList<MenuElement>();
        final ListView List = (ListView) findViewById(R.id.Menu_List_view);

        final MenuAdpater MenuElementsItem = new MenuAdpater(this, MenuElements);

        List.setAdapter(MenuElementsItem);

        Button Confirmbtn = (Button) findViewById(R.id.ConfirmOrder);
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


}
