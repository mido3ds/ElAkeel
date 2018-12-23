package cufe.cmp.db.elakeel.UI.Sherif;

public class ManagerRestaurantReview {
    int RestaurantStars;
    String ChefNsmr;
    int ChefStras;
    String DeliveryManName;
    int DeliveryManStars;

    public void setRestaurantStars(int restaurantStars) {
        RestaurantStars = restaurantStars;
    }

    public void setChefNsmr(String chefNsmr) {
        ChefNsmr = chefNsmr;
    }

    public void setChefStras(int chefStras) {
        ChefStras = chefStras;
    }

    public void setDeliveryManName(String deliveryManName) {
        DeliveryManName = deliveryManName;
    }

    public void setDeliveryManStars(int deliveryManStars) {
        DeliveryManStars = deliveryManStars;
    }

    public int getRestaurantStars() {
        return RestaurantStars;
    }

    public String getChefNsmr() {
        return ChefNsmr;
    }

    public int getChefStras() {
        return ChefStras;
    }

    public String getDeliveryManName() {
        return DeliveryManName;
    }

    public int getDeliveryManStars() {
        return DeliveryManStars;
    }

    public ManagerRestaurantReview(int restaurantStars, String chefNsmr, int chefStras, String deliveryManName, int deliveryManStars) {
        RestaurantStars = restaurantStars;
        ChefNsmr = chefNsmr;
        ChefStras = chefStras;
        DeliveryManName = deliveryManName;
        DeliveryManStars = deliveryManStars;
    }
}
