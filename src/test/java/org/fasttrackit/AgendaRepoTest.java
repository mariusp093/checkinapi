package org.fasttrackit;

import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.repo.AgendaRepository;
import org.fasttrackit.service.AgendaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 1/8/2019
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AgendaApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class AgendaRepoTest {

    @Autowired
    private AgendaRepository repository;

    @Autowired
    private AgendaService service;

    @Test
    public void testSave() {

        Agenda agenda = getAgenda("agenda0","firtsname", "ln","0000");
        repository.save(agenda);


        Agenda agenda2 = getAgenda("agenda1","Ala", "bala","11111");
        repository.save(agenda2);




    }


    @Test
    public void testGetAll() {

        System.out.println(service.getAllAgendas());



    }

    @Test
    public void testFindByName() {

        List<Agenda> agenda1List = repository.findAgendaByName("agenda1");
        System.out.println(agenda1List.size());

        System.out.println("-----------------------REZULTAT TEST");
        System.out.println(agenda1List.get(0));


        List<Agenda> agendaLikeList = repository.findAgendaWhereNameLike("agenda");
        System.out.println(agendaLikeList.size());

        System.out.println("-----------------------REZULTAT TEST LIKE");

        for(Agenda agenda : agendaLikeList) {
            System.out.println(agenda);
        }

    }



    private Agenda getAgenda(String agendaName, String firtsname, String ln, String phone) {
        Agenda agenda = new Agenda();
        agenda.setName(agendaName);
        List<Contact> contacte = new ArrayList<>();
        Contact c = new Contact();
        c.setFirstName(firtsname);
        c.setLastName(ln);
        c.setPhone(phone);
        contacte.add(c);
        agenda.setContacte(contacte);
        return agenda;
    }

}
