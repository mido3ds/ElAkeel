package cufe.cmp.db.elakeel.UI.Sherif;

public class MenuItem {
    private String ItemName;
    private int trend;
    private String Type;
    private int Price;
    private String Ingredients;

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public int getTrend() {
        return trend;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public MenuItem(String itemName, int trend, String type, int price, String ingredients) {
        setItemName(itemName);
        setTrend(trend);
        setType(type);
        setPrice(price);
        setIngredients(ingredients);
    }
}
