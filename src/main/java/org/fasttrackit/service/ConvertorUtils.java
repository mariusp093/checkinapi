package org.fasttrackit.service;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.dto.ContactDTO;
import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;

import java.util.ArrayList;
import java.util.List;


public class ConvertorUtils {

    public static AgendaDTO convertToDto(Agenda one) {
        AgendaDTO dto = new AgendaDTO();
        dto.setId(one.getId());
        dto.setName(one.getName());
        List<ContactDTO> contacteDto = new ArrayList<>();
        for (Contact c : one.getContacte()) {
            ContactDTO cd = convertToDto(c);
            contacteDto.add(cd);
        }

        dto.setContacte(contacteDto);
        return dto;
    }

    public static ContactDTO convertToDto(Contact c) {
        ContactDTO cd = new ContactDTO();
        cd.setFirstName(c.getFirstName());
        cd.setLastName(c.getLastName());
        cd.setPhone(c.getPhone());
        cd.setId(c.getId());
        return cd;
    }
}
