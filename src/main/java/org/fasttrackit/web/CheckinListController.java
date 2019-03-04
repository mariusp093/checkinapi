package org.fasttrackit.web;

import org.fasttrackit.dto.CheckinListDTO;
import org.fasttrackit.service.CheckinListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CheckinListController {


    @Autowired
    private CheckinListService service;

    @RequestMapping(path = "/agenda/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CheckinListDTO getAgendaById(@PathVariable long id) {
        return service.getAgenda(id);
    }

    @RequestMapping(path = "/agenda", method = RequestMethod.GET)
    @ResponseBody
    public List<CheckinListDTO> getAgendas() {
        return service.getAllAgendas();
    }

}


