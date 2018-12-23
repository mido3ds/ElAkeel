package cufe.cmp.db.elakeel.UI.Hossam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

public class MealRateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal__rate__list_view);

        // TODO: 23/12/2018
        ((TextView) findViewById(R.id.ReviewedMealName)).setText("");
        RatingBar ratingBar = (RatingBar) findViewById(R.id.MealRate);
        ratingBar.setRating(0);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {

        });
    }

}
