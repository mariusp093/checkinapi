package org.fasttrackit;

import org.fasttrackit.model.CheckinList;
import org.fasttrackit.model.Passport;
import org.fasttrackit.repo.CheckinListRepository;
import org.fasttrackit.service.CheckinListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CheckinlistApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class CheckinListRepoTest {

    @Autowired
    private CheckinListRepository repository;

    @Autowired
    private CheckinListService service;

    @Test
    public void testSave() {

        CheckinList checkinList = getCheckinList("checkinList0","firtsname", "ln","0000");
        repository.save(checkinList);


        CheckinList checkinList2 = getCheckinList("checkinList1","Ala", "bala","11111");
        repository.save(checkinList2);




    }





    @Test
    public void testFindByName() {

        List<CheckinList> checkinList1List = repository.findByName("checkinList1");
        System.out.println(checkinList1List.size());

        System.out.println("-----------------------REZULTAT TEST");
        System.out.println(checkinList1List.get(0));


        List<CheckinList> checkinListLikeList = repository.findCheckinListWhereNameLike("agenda");
        System.out.println(checkinListLikeList.size());

        System.out.println("-----------------------REZULTAT TEST LIKE");

        for(CheckinList checkinList : checkinListLikeList) {
            System.out.println(checkinList);
        }

    }



    private CheckinList getCheckinList(String checkinListName, String firtsname, String lastName, String passportNumber) {
        CheckinList checkinList = new CheckinList();
        checkinList.setName(checkinListName);
        List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();
        passport.setFirstName(firtsname);
        passport.setLastName(lastName);
        passport.setPassportnumber(passportNumber);
        passports.add(passport);
        checkinList.setPassports(passports);
        return checkinList;
    }

}
