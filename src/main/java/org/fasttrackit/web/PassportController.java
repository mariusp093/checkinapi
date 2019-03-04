package org.fasttrackit.web;

import org.fasttrackit.dto.PassportDTO;
import org.fasttrackit.service.CheckinListService;
import org.fasttrackit.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PassportController {


    @Autowired
    private CheckinListService service;
    @Autowired
    private PassportService passportService;

    @RequestMapping(path = "/agenda/{agendaId}/contact", method = RequestMethod.GET)
    @ResponseBody
    public List<PassportDTO> getContactsByAgendaId(@PathVariable long agendaId) {

        return service.getAgenda(agendaId).getContacte();
    }


    @CrossOrigin
    @RequestMapping(path = "/agenda/{agendaId}/contact/{contactId}", method = RequestMethod.PUT)
    @ResponseBody
    public PassportDTO editContact(@PathVariable long agendaId, @PathVariable long contactId,
                                   @RequestBody PassportDTO request) {
        request.setId(contactId);
        passportService.update(request);
        return request;
    }

    @RequestMapping(path = "/agenda/{agendaId}/contact", method = RequestMethod.POST)
    @ResponseBody
    public PassportDTO saveContact(@PathVariable long agendaId,
                                   @RequestBody PassportDTO request) {

        passportService.create(request, agendaId);
        return request;
    }

}


