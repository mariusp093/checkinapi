package org.fasttrackit.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class CheckinList {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenda_id")
    private List<Passport> passports = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckinList{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
       // sb.append(", passports=").append(passports);
        sb.append('}');
        return sb.toString();
    }
}
