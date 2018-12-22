package cufe.cmp.db.elakeel.UI.Hossam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class RestuarantChefsActivity extends AppCompatActivity {
    private String SelectedChef;

    public String getSelectedChef() {
        return SelectedChef;
    }

    public void setSelectedChef(String selectedChef) {
        SelectedChef = selectedChef;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant__chefs);

        ArrayList<Chef> Chefs = new ArrayList<Chef>();
        final ListView List = findViewById(R.id.RestaurantChef_List_view);
        final ChefAdapter ChefsItem = new ChefAdapter(this, Chefs);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {
                Chef Chef = ChefsItem.getItem(position);
                setSelectedChef(Chef.getChef_Name());
            }
        });


        List.setAdapter(ChefsItem);

        Button Confirmbtn = findViewById(R.id.ConfirmChef);
        Confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
                //intent.putExtra("EXTRA_Selected_Chef_Name", SelectedChef);
                //startActivity(intent);
                // el mfrod hna signoutActivity dh ykon el activty ely m7tag akon 3arf feh asm el chef ely a5taro
            }
        });


    }

}
