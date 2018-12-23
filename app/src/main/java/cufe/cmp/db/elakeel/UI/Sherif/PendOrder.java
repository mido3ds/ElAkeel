package cufe.cmp.db.elakeel.UI.Sherif;

public class PendOrder {
    int Customerid;
    String dateandTime;
    int price;
    String CustomerName;
    boolean status; //false means not prepared
    //true means done.


    public void setDateandTime(String dateandTime) {
        this.dateandTime = dateandTime;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getDateandTime() {
        return dateandTime;
    }

    public void setCustomerid(int customerid) {
        Customerid = customerid;
    }

    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public PendOrder(int Customerid, int price, String Date,String customerName,Boolean status)
    {
        setCustomerid(Customerid);
        setCustomerName(CustomerName);
        setDateandTime(Date);
        setPrice(price);
        setStatus(status);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus()
    {
      return status;
    }
}
