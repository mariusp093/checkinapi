package org.fasttrackit.dto;

public class PassportDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String passportnumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
