package org.fasttrackit.dto;

import java.util.ArrayList;
import java.util.List;


public class CheckinListDTO {
    private Long id;
    
    private String name;

    private List<PassportDTO> passports = new ArrayList<>();

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

    public List<PassportDTO> getPassports() {
        return passports;
    }

    public void setPassports(List<PassportDTO> passports) {
        this.passports = passports;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckinListDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", passports=").append(passports);
        sb.append('}');
        return sb.toString();
    }
}
