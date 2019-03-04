package org.fasttrackit.service;

import org.fasttrackit.dto.PassportDTO;
import org.fasttrackit.model.CheckinList;
import org.fasttrackit.model.Passport;
import org.fasttrackit.repo.CheckinListRepository;
import org.fasttrackit.repo.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class PassportService {

    @Autowired
    private CheckinListRepository checkinListRepository;
    @Autowired
    private PassportRepository passportRepository;

    @Transactional
    public void update(PassportDTO contact) {
        Passport one = passportRepository.findOne(contact.getId());
        if (one == null) {
            throw new IllegalArgumentException("Invalid id");

        }
        one.setPassportnumber(contact.getPassportnumber());
        one.setLastName(contact.getLastName());
        one.setFirstName(contact.getFirstName());
        passportRepository.save(one);

    }

    @Transactional
    public void create(PassportDTO contact, long checkinListId) {

        Passport one = new Passport();
        one.setPassportnumber(contact.getPassportnumber());
        one.setLastName(contact.getPassportnumber());
        one.setFirstName(contact.getFirstName());

        CheckinList checkinList = checkinListRepository.findOne(checkinListId);
        checkinList.getPassports().add(one);
        checkinListRepository.save(checkinList);
    }
}
