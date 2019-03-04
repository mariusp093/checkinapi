package org.fasttrackit.dto;

import java.util.ArrayList;
import java.util.List;


public class CheckinListDTO {
    private Long id;
    
    private String name;

    private List<PassportDTO> contacte = new ArrayList<>();

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

    public List<PassportDTO> getContacte() {
        return contacte;
    }

    public void setContacte(List<PassportDTO> contacte) {
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckinListDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", contacte=").append(contacte);
        sb.append('}');
        return sb.toString();
    }
}
