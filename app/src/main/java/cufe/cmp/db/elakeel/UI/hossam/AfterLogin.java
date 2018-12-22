package cufe.cmp.db.elakeel.UI.hossam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        ArrayList<Prevorder> PrevOrders = new ArrayList<Prevorder>();
        final ListView List = findViewById(R.id.Prev_orders_List_view);
        final PrevOrdersAdapter prevOrdersItem = new PrevOrdersAdapter(this, PrevOrders);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {
                Prevorder Prevorder = prevOrdersItem.getItem(position);
                Intent ReviewOrderIntent = new Intent(AfterLogin.this, ReviewAcivity.class);
                startActivity(ReviewOrderIntent);
            }
        });


        List.setAdapter(prevOrdersItem);


        Button makeneworder = findViewById(R.id.MakeNewOrderButton);
        makeneworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to open Restaurants list
                Intent neworderIntent = new Intent(AfterLogin.this, ReviewAcivity.class);
                startActivity(neworderIntent);
            }
        });

    }


}

