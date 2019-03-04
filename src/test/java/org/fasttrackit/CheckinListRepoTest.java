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

/**
 * @author ttritean
 * @since 1/8/2019
 */

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

        CheckinList checkinList = getAgenda("agenda0","firtsname", "ln","0000");
        repository.save(checkinList);


        CheckinList checkinList2 = getAgenda("agenda1","Ala", "bala","11111");
        repository.save(checkinList2);




    }


    @Test
    public void testGetAll() {

        System.out.println(service.getAllAgendas());



    }

    @Test
    public void testFindByName() {

        List<CheckinList> checkinList1List = repository.findAgendaByName("agenda1");
        System.out.println(checkinList1List.size());

        System.out.println("-----------------------REZULTAT TEST");
        System.out.println(checkinList1List.get(0));


        List<CheckinList> checkinListLikeList = repository.findAgendaWhereNameLike("agenda");
        System.out.println(checkinListLikeList.size());

        System.out.println("-----------------------REZULTAT TEST LIKE");

        for(CheckinList checkinList : checkinListLikeList) {
            System.out.println(checkinList);
        }

    }



    private CheckinList getAgenda(String agendaName, String firtsname, String ln, String phone) {
        CheckinList checkinList = new CheckinList();
        checkinList.setName(agendaName);
        List<Passport> contacte = new ArrayList<>();
        Passport c = new Passport();
        c.setFirstName(firtsname);
        c.setLastName(ln);
        c.setPhone(phone);
        contacte.add(c);
        checkinList.setContacte(contacte);
        return checkinList;
    }

}
