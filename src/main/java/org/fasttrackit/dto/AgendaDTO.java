package org.fasttrackit.dto;

import java.util.ArrayList;
import java.util.List;


public class AgendaDTO {
    private Long id;
    
    private String name;

    private List<ContactDTO> contacte = new ArrayList<>();

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

    public List<ContactDTO> getContacte() {
        return contacte;
    }

    public void setContacte(List<ContactDTO> contacte) {
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AgendaDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", contacte=").append(contacte);
        sb.append('}');
        return sb.toString();
    }
}
