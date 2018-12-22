package cufe.cmp.db.elakeel.UI.hossam;

public class MenuElement {
    private String ElemwntName;
    private int ELementprice;
    private int pic;

    public MenuElement(String ElementName, int elementprice, int picres) {
        setELementprice(elementprice);
        setElemwntName(ElementName);
        setPic(picres);
    }

    public int getELementprice() {
        return ELementprice;
    }

    public void setELementprice(int ELementprice) {
        this.ELementprice = ELementprice;
    }

    public String getElemwntName() {
        return ElemwntName;
    }

    public void setElemwntName(String elemwntName) {
        ElemwntName = elemwntName;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
