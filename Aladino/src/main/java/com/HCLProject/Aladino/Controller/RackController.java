package com.HCLProject.Aladino.Controller;

import com.HCLProject.Aladino.Model.Rack;
import com.HCLProject.Aladino.Service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/racks")
public class RackController {

    @Autowired
    private RackService rackService;

//get All Racks
@GetMapping("/")
    public String getAllRack(Model m) {
    List<Rack> rackList = this.rackService.getAll();
    m.addAttribute("rackList",rackList);
    m.addAttribute("title","Robotic Arm");
    return "Rack/rackList";
    }

    //create a Rack
    @GetMapping("/addRack")
    public String createRack(Model m) {
        m.addAttribute("rack",new Rack());
        m.addAttribute("title","Robotic Arm");
        return "Rack/addRack";
    }

 //Handling add Request of the department
    @PostMapping("/saveRack")
    public String saveRack(@ModelAttribute Rack rack,Model m,RedirectAttributes ra){
        Rack newRack = this.rackService.createRack(rack);
        m.addAttribute("rack",newRack);
        m.addAttribute("title","Robotic Arm");
        ra.addFlashAttribute("message","Rack is successfully Added");
        return "redirect:/racks/";
    }

// delete rack
@RequestMapping(value="/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET })
    public String deleteRack(@PathVariable("id") Long id, Model m, RedirectAttributes ra){
    try {
    this.rackService.deleteRack(id);
    ra.addFlashAttribute("message", "Okay, the rack is deleted !!");
    m.addAttribute("title","Robotic Arm");
    return "redirect:/racks/";
    } catch (Exception e) {
        e.printStackTrace();
        return "redirect:/error"; // Redirect to an error page if an exception occurs
    }
    }


}
