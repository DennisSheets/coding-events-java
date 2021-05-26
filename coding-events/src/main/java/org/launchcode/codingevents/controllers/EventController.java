package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping ("events")
public class EventController {


    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title","All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }


    @GetMapping ("create")
    public String renderCreateEventsForm(Model model){
        model.addAttribute("title","Create Events");
        return "events/create";
    }

    @PostMapping ("create")

    public String processCreateEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Events");
            model.addAttribute("errorMsg", "You have bad data!");
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect: ";
    }


    @GetMapping ("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping ("delete")
    public String processEventDelete(@RequestParam (required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
}
