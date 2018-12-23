package cufe.cmp.db.elakeel.UI.Sherif;

public class ManagerMealsReview {
    String MealName;
    public void setMealName(String mealName) {
        MealName = mealName;
    }
    public String getMealName() {
        return MealName;
    }

    int StarsNum;
    public void setStarsNum(int starsNum) {
        StarsNum = starsNum;
    }
    public int getStarsNum() {
        return StarsNum;
    }

    public ManagerMealsReview(String mealName, int starsNum) {
        MealName = mealName;
        StarsNum = starsNum;
    }
}
