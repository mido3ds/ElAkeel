package cufe.cmp.db.elakeel.UI.hossam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class Restuarant_Chefs extends AppCompatActivity {
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
        final ListView List = (ListView) findViewById(R.id.RestaurantChef_List_view);
        final Chef_Adapter ChefsItem = new Chef_Adapter(this, Chefs);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {
                Chef Chef = ChefsItem.getItem(position);
                setSelectedChef(Chef.getChef_Name());
            }
        });


        List.setAdapter(ChefsItem);

        Button Confirmbtn = (Button) findViewById(R.id.ConfirmChef);
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
