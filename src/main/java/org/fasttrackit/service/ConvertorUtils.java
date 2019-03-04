package org.fasttrackit.service;

import org.fasttrackit.dto.CheckinListDTO;
import org.fasttrackit.dto.PassportDTO;
import org.fasttrackit.model.CheckinList;
import org.fasttrackit.model.Passport;

import java.util.ArrayList;
import java.util.List;


public class ConvertorUtils {

    public static CheckinListDTO convertToDto(CheckinList one) {
        CheckinListDTO dto = new CheckinListDTO();
        dto.setId(one.getId());
        dto.setName(one.getName());
        List<PassportDTO> contacteDto = new ArrayList<>();
        for (Passport c : one.getContacte()) {
            PassportDTO cd = convertToDto(c);
            contacteDto.add(cd);
        }

        dto.setContacte(contacteDto);
        return dto;
    }

    public static PassportDTO convertToDto(Passport c) {
        PassportDTO cd = new PassportDTO();
        cd.setFirstName(c.getFirstName());
        cd.setLastName(c.getLastName());
        cd.setPhone(c.getPhone());
        cd.setId(c.getId());
        return cd;
    }
}
