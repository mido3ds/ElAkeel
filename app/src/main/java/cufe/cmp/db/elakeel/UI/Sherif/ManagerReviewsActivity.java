package cufe.cmp.db.elakeel.UI.Sherif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class ManagerReviewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_reviews);
        ArrayList<ManagerReviews> Reviews = new ArrayList<ManagerReviews>();
        final ListView List = (ListView) findViewById(R.id.res_reviews);
        final ManagerReviewsAdapter managerReviewsAdapter = new ManagerReviewsAdapter(this,Reviews);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ManagerReviews ManagerReviews = managerReviewsAdapter.getItem(position);
                Intent ManagerReviewsIntent = new Intent(ManagerReviewsActivity.this ,rest_review_item_Activity.class);
                startActivity(ManagerReviewsIntent);
            }
        });

        List.setAdapter(managerReviewsAdapter);
    }
}
