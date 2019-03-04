package org.fasttrackit.web;

import org.fasttrackit.dto.ContactDTO;
import org.fasttrackit.service.AgendaService;
import org.fasttrackit.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContactController {


    @Autowired
    private AgendaService service;
    @Autowired
    private ContactService contactService;

    @RequestMapping(path = "/agenda/{agendaId}/contact", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactDTO> getContactsByAgendaId(@PathVariable long agendaId) {

        return service.getAgenda(agendaId).getContacte();
    }


    @CrossOrigin
    @RequestMapping(path = "/agenda/{agendaId}/contact/{contactId}", method = RequestMethod.PUT)
    @ResponseBody
    public ContactDTO editContact(@PathVariable long agendaId, @PathVariable long contactId,
                                  @RequestBody ContactDTO request) {
        request.setId(contactId);
        contactService.update(request);
        return request;
    }

    @RequestMapping(path = "/agenda/{agendaId}/contact", method = RequestMethod.POST)
    @ResponseBody
    public ContactDTO saveContact(@PathVariable long agendaId,
                                  @RequestBody ContactDTO request) {

        contactService.create(request, agendaId);
        return request;
    }

}


