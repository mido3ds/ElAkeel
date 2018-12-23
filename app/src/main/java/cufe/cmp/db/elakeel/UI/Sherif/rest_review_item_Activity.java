package cufe.cmp.db.elakeel.UI.Sherif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class rest_review_item_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_review_item_);

        ArrayList<ManagerMealsReview> Meals = new ArrayList<ManagerMealsReview>();
        final ListView List = (ListView) findViewById(R.id.SmallList);
        final ReviewedMealAdapter ReviewedMealAdapter = new ReviewedMealAdapter(this,Meals);


        List.setAdapter(ReviewedMealAdapter);
    }
}
