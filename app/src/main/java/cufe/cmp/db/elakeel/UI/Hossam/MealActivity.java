package cufe.cmp.db.elakeel.UI.Hossam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import cufe.cmp.db.elakeel.Data.Entities.Ingredient;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Meal;
import cufe.cmp.db.elakeel.R;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Meal meal = (Meal) getIntent().getSerializableExtra(Meal.class.getName());
        ((TextView) findViewById(R.id.mealNameTextView)).setText(meal.getName());
        ((ImageView) findViewById(R.id.mealImageView)).setImageBitmap(meal.getImage());
        ((TextView) findViewById(R.id.ingredientsTextView)).setText(Ingredient.allIngredientsAsString());
        findViewById(R.id.backToMenuBtn).setOnClickListener(v -> finish());
    }
}
