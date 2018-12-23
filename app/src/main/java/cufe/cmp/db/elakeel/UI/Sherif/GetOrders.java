package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class GetOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_orders);

        ArrayList<PendOrder> PendingOrders = new ArrayList<PendOrder>();
        final ListView List = (ListView) findViewById(R.id.PendingOrders_List_view);
        final PendingOrdersAdapter PendingOrdersAdapter = new PendingOrdersAdapter(this,PendingOrders);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PendOrder pendOrder = PendingOrdersAdapter.getItem(position);
                Intent ReviewOrderIntent = new Intent(GetOrders.this ,CustomerInfoActivity.class);
                startActivity(ReviewOrderIntent);
            }
        });

        List.setAdapter(PendingOrdersAdapter);



    }
}
