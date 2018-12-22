package cufe.cmp.db.elakeel.UI.sherif;

public class MenuItem {
    private String ItemName;
    private int trend;
    private String Type;
    private int Price;
    private String Ingredients;

    public MenuItem(String itemName, int trend, String type, int price, String ingredients) {
        setItemName(itemName);
        setTrend(trend);
        setType(type);
        setPrice(price);
        setIngredients(ingredients);
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getTrend() {
        return trend;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }
}
