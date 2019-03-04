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
    private List<Passport> contacte = new ArrayList<>();

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

    public List<Passport> getContacte() {
        return contacte;
    }

    public void setContacte(List<Passport> contacte) {
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckinList{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
       // sb.append(", contacte=").append(contacte);
        sb.append('}');
        return sb.toString();
    }
}
