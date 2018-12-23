package cufe.cmp.db.elakeel.UI.Sherif;

public class ManagerReviews {
    int ReviewID;
    boolean Staues;

    public int getReviewID() {
        return ReviewID;
    }

    public void setReviewID(int reviewID) {
        ReviewID = reviewID;
    }

    public boolean getStaues() {
        return Staues;
    }

    public void setStaues(boolean staues) {
        Staues = staues;
    }

    public ManagerReviews(int reviewID, boolean staues) {
        ReviewID = reviewID;
        Staues = staues;
    }
}
