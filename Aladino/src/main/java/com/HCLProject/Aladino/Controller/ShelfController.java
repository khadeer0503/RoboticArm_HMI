package com.HCLProject.Aladino.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCLProject.Aladino.Model.Rack;
import com.HCLProject.Aladino.Model.Shelf;
import com.HCLProject.Aladino.Service.RackService;
import com.HCLProject.Aladino.Service.ShelfService;


@Controller
@RequestMapping("/shelf")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;
    @Autowired
    private RackService rackService;

    //create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model m) {
        m.addAttribute("shelf", new Shelf());
        List<Rack> listRack = this.rackService.getAll();
        m.addAttribute("listRack", listRack);
        m.addAttribute("title","Robotic Arm");
        return "Shelf/addShelf";
    }
//Handling save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Shelf shelf, Model m) {
        m.addAttribute("title","Robotic Arm");
        Shelf saveshelf = this.shelfService.creatShelfs(shelf);
        m.addAttribute("shelf", saveshelf);
        return "redirect:/shelf/";
    }


    //getAll
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model m) {
        m.addAttribute("title","Robotic Arm");
        List<Shelf> listShelf = this.shelfService.getAllShelfs();
        m.addAttribute("listShelf", listShelf);
        //List<Rack> listRack = this.rackService.getAll();
       // m.addAttribute("listRack", listRack);
        return "Shelf/shelfList";
    }

    //getById

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public String getById() {
        return "redirect:/shelf/";
    }


    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id,Model m) {
        this.rackService.deleteRack(id);
        m.addAttribute("title","Robotic Arm");
        return "redirect:/shelf/";
    }

    //update
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        return "redirect:/shelf/";
    }

}
