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

    @RequestMapping(path = "/check-in-list/{checkinListId}/passport", method = RequestMethod.GET)
    @ResponseBody
    public List<PassportDTO> getPassportsByCheckinLists(@PathVariable long checkinListId) {

        return service.getCheckinList(checkinListId).getPassports();
    }


    @CrossOrigin
    @RequestMapping(path = "/check-in-list/{checkinListId}/passport/{passportId}", method = RequestMethod.PUT)
    @ResponseBody
    public PassportDTO editPassport(@PathVariable long checkinListId, @PathVariable long passportId,
                                   @RequestBody PassportDTO request) {
        request.setId(passportId);
        passportService.update(request);
        return request;
    }

    @RequestMapping(path = "/check-in-list/{checkinListId}/passport", method = RequestMethod.POST)
    @ResponseBody
    public PassportDTO savePassport(@PathVariable long checkinListId,
                                   @RequestBody PassportDTO request) {

        passportService.create(request, checkinListId);
        return request;
    }


    @CrossOrigin
    @RequestMapping(path = "/check-in-list/passport/{passportId}", method = RequestMethod.DELETE)

    public void deletePassport( @PathVariable long passportId)
                                    {

        passportService.delete(passportId);

    }
}


