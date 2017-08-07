package me.yling.roboresumeproject0804.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Resume {

    //id is used in the resume table as the key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    private String email;
    private String Organisation;

    //validate dates
    @NotNull
    @Size(min = 10, max = 10)
    private String stdate;

    private String endate;

    private long diffDays;


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStdate() {
        return stdate;
    }

    public void setStdate(String stdate) {
        this.stdate = stdate;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public long getDiffDays() {
        return diffDays;
    }

    public void setDiffDays(long diffDays) {
        this.diffDays = diffDays;
    }

}
