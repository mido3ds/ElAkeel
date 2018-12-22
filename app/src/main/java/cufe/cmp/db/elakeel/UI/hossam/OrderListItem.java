package cufe.cmp.db.elakeel.UI.hossam;

public class OrderListItem {

    private String MealName;
    private int rate;

    public OrderListItem(String Mealname, int rate) {
        setRate(rate);
        setMealName(Mealname);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String mealName) {
        MealName = mealName;
    }
}
