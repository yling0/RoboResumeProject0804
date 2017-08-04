package me.yling.roboresumeproject0804.models;

public class Resume {

    private String name;
    private String email;
    private String Organisation;
    private String stdate;
    private String endate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return Organisation;
    }

    public void setOrganisation(String organisation) {
        Organisation = organisation;
    }

    public String getStdate() {
        return stdate;
    }

    public void setStdate(String date) {
        this.stdate = date;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

}
