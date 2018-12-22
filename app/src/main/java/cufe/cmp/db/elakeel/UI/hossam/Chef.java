package cufe.cmp.db.elakeel.UI.hossam;

public class Chef {
    private String Chef_Name;
    private String Chef_nationality;


    public Chef(String chef_Name, String ChefNationality) {
        setChef_Name(chef_Name);
        setChef_nationality(ChefNationality);
    }

    public String getChef_nationality() {
        return Chef_nationality;
    }

    public void setChef_nationality(String chef_nationality) {
        Chef_nationality = chef_nationality;
    }

    public String getChef_Name() {
        return Chef_Name;
    }

    public void setChef_Name(String chef_Name) {
        Chef_Name = chef_Name;
    }
}
