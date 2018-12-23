package cufe.cmp.db.elakeel.UI.Hossam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import cufe.cmp.db.elakeel.Data.Entities.Review;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Meal;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class OrderItemListAdapter extends ArrayAdapter<Meal> {
    private final Customer customer;

    public OrderItemListAdapter(Activity context, ArrayList<Meal> meals, Customer customer) {
        super(context, 0, meals);
        this.customer = customer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_meal__rate__list_view, parent, false);
        }

        Meal meal = getItem(position);
        Review mealReview = Review.from(customer, meal.getReviewable());

        TextView MealNameTextView = listItemView.findViewById(R.id.ReviewedMealName);
        MealNameTextView.setText(meal.getName());

        RatingBar RateRatingBar = listItemView.findViewById(R.id.MealRate);
        RateRatingBar.setRating(mealReview.getStars());
        RateRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            mealReview.setStars((int) rating);
            mealReview.update();
        });

        return listItemView;
    }
}
