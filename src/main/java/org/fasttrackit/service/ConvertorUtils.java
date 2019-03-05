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
        List<PassportDTO> passportDTOS = new ArrayList<>();
        for (Passport passport : one.getPassports()) {
            PassportDTO passportDTO = convertToDto(passport);
            passportDTOS.add(passportDTO);
        }

        dto.setPassports(passportDTOS);
        return dto;
    }

    public static PassportDTO convertToDto(Passport passport) {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setFirstName(passport.getFirstName());
        passportDTO.setLastName(passport.getLastName());
        passportDTO.setPassportNumber(passport.getPassportnumber());
        passportDTO.setId(passport.getId());
        return passportDTO;
    }
}
