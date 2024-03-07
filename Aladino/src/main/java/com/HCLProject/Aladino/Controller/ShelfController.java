package com.HCLProject.Aladino.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HCLProject.Aladino.Model.Rack;
import com.HCLProject.Aladino.Model.Shelf;
import com.HCLProject.Aladino.Service.BoxesService;
import com.HCLProject.Aladino.Service.RackService;
import com.HCLProject.Aladino.Service.ShelfService;


@Controller
@RequestMapping("/shelf")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;
    @Autowired
    private RackService rackService;
    @Autowired
    private BoxesService boxesService;

    //create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(  Model m) {

        List<Rack> listRack = this.rackService.getAll();
        m.addAttribute("listRack", listRack);
        m.addAttribute("shelf", new Shelf());
        m.addAttribute("title","Robotic Arm");
        return "Shelf/addShelf";
    }
//Handling save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("shelf") Shelf shelf, Model m,RedirectAttributes ra, BindingResult bindingResult)
    {
        m.addAttribute("title","Robotic Arm");
//check the placement exits or not
        if(shelf.getPlacement() != 0 || shelf.getPlacement() <= 5){
            List<Shelf> shelfs =this.shelfService.getAllShelfs();
            for(Shelf s: shelfs){
                if(s.getPlacement() == shelf.getPlacement()){
                    ra.addFlashAttribute("message","Position already used");
                    return "redirect:/shelf/";
                }
            }
        }
        // If there are validation errors, return to the form
        if (bindingResult.hasErrors()) {
            List<Rack> listRack = this.rackService.getAll();
            m.addAttribute("listRack", listRack);
            m.addAttribute("title", "Robotic Arm");
            return "Shelf/addShelf";
        }else{
        Shelf saveShelf = this.shelfService.creatShelfs(shelf);
        m.addAttribute("shelf", saveShelf);
        ra.addFlashAttribute("message","Shelf is successfully Added");
        return "redirect:/shelf/";
    }
   // return "redirect:/shelf/";
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
    public String delete(@PathVariable Long id,Model m,RedirectAttributes ra) {
        this.shelfService.deleteById(id);
        m.addAttribute("title","Robotic Arm");
        ra.addFlashAttribute("message","Deleted is successfully Added");
        return "redirect:/shelf/";
    }

    //update
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        return "redirect:/shelf/";
    }

}
