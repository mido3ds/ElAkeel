package cufe.cmp.db.elakeel.UI.Hossam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import cufe.cmp.db.elakeel.Data.Entities.Order;
import cufe.cmp.db.elakeel.Data.Entities.Review;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Chef;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.DeliveryMan;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Meal;
import cufe.cmp.db.elakeel.Data.Entities.Reviewable.Restaurant;
import cufe.cmp.db.elakeel.Data.Entities.Users.Customer;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private TextView chefNameTextView;
    private TextView restaurantNameTextView;
    private TextView deliveryManNameTextView;
    private RatingBar chefRate;
    private RatingBar restRate;
    private RatingBar delManRate;
    private Button backToOrders;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_acivity);

        Customer customer = (Customer) getIntent().getSerializableExtra(Customer.class.getName());
        Order order = (Order) getIntent().getSerializableExtra(Order.class.getName());
        DeliveryMan deliveryMan = DeliveryMan.from(order);
        Restaurant restaurant = Restaurant.from(order);
        Chef chef = Chef.from(order);
        Review restReview = Review.from(customer, restaurant.getReviewable());
        Review chefReview = Review.from(customer, chef.getReviewable());
        Review deliveryReview = Review.from(customer, deliveryMan.getReviewable());
        ArrayList<Meal> meals = order.getMeals();

        getViews();

        restaurantNameTextView.setText(restaurant.getName());
        chefNameTextView.setText(chef.getName());
        deliveryManNameTextView.setText(deliveryMan.getName());

        restRate.setRating(restReview.getStars());
        restRate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            restReview.setStars((int) rating);
            restReview.update();
        });

        chefRate.setRating(chefReview.getStars());
        chefRate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            chefReview.setStars((int) rating);
            chefReview.update();
        });

        delManRate.setRating(deliveryReview.getStars());
        delManRate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            deliveryReview.setStars((int) rating);
            deliveryReview.update();
        });

        OrderItemListAdapter orderItemListAdapter = new OrderItemListAdapter(this, meals, customer);
        listView.setAdapter(orderItemListAdapter);
        listView.setOnItemClickListener((adapterView, view, position, ID) -> {
            Meal meal = orderItemListAdapter.getItem(position);
            // TODO: 23/12/2018
        });

        backToOrders.setOnClickListener(v -> finish());
    }

    private void getViews() {
        chefNameTextView = findViewById(R.id.Chef_Name);
        restaurantNameTextView = findViewById(R.id.Restuarant_Name);
        deliveryManNameTextView = findViewById(R.id.Delivery_Man_Name);
        restRate = findViewById(R.id.Restaurant_Rate);
        chefRate = findViewById(R.id.Chef_Rate);
        delManRate = findViewById(R.id.Delivery_Man_Rate);
        listView = findViewById(R.id.Order_Elements);
        backToOrders = findViewById(R.id.Back_TO_orders_List);
    }
}


