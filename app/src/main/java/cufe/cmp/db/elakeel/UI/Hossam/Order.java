package cufe.cmp.db.elakeel.UI.Hossam;

public class Order {
    private String RestaurantName;
    private String OrderDate;
    private float TotalPrice;

    public Order(String Restuarantname, String Date, float Totalprice) {
        setOrderDate(Date);
        setRestaurantName(Restuarantname);
        setTotalPrice(Totalprice);
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

}
