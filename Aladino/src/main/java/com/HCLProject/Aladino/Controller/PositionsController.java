package com.HCLProject.Aladino.Controller;

import java.util.List;

//import javax.persistence.EntityNotFoundException;

import com.HCLProject.Aladino.Exception.ResourceNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.Positions;
import com.HCLProject.Aladino.Model.Rack;
import com.HCLProject.Aladino.Model.Shelf;
import com.HCLProject.Aladino.Service.BoxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Service.PositionsService;
import com.HCLProject.Aladino.Service.RackService;
import com.HCLProject.Aladino.Service.ShelfService;

@Controller
@RequestMapping("/Positions")
public class PositionsController {
	@Autowired
	private PositionsService positionService;
	@Autowired
	private BoxesService boxesService;
	@Autowired
	private RackService rackService;
	@Autowired
	private ShelfService shelfService;





	//  listing all the Boxes.
					@GetMapping("/getAll")
					public String getAllpositions(Model m)
					{
						List<Positions> getAll = this.positionService.getAllPosition();
						m.addAttribute("ListPositions", getAll);
						m.addAttribute("title","HCL Aladino");
						return "getAllPositions";
					}

// GET SINGLE BOX
					@GetMapping("/{id}")
					public String getSingleBox(@PathVariable("id") Long id,Model m) throws BoxNotFoundException, PositionNotFoundException
					{
						m.addAttribute("title","HCL Aladino");
						Positions singlePosition = this.positionService.getSinglePosition(id);
						m.addAttribute("Positions", singlePosition);
						return "redirect:/Positions/getAll";
					}

//Delete
		@GetMapping("/delete/{id}")
			public String deletePosition(@PathVariable Long id) {
				try
					{
						positionService.deletePosition(id);
					} catch (PositionNotFoundException e)
					{
						e.printStackTrace();
					}
				    return "redirect:/Positions/getAll";
				    }
//update

		    @PostMapping("/edit/{id}")
		    public String updatePosition(Positions position, @PathVariable Long id, BindingResult bindingResult, Model model) {
		        try {
		            positionService.updatePosition(position, id);
		            return "redirect:/Positions/getAll";
		        } catch (PositionNotFoundException | PositionAlreadyFullException e) {
		           model.addAttribute("error", e.getMessage());
		        return e.getMessage();
		        }
		    }

//   Add a new Boxes Position on a Rack
	@GetMapping("/addPosition")
	public String addPositions(Model m)
	{
		//rack
		List<Rack> listRack = this.rackService.getAll();
        m.addAttribute("listRack", listRack);
		// shelfs
		List<Shelf> listShelf = this.shelfService.getAllShelfs();
        m.addAttribute("listShelf", listShelf);
		// boxes
		List<Boxes> listBoxes = this.boxesService.getAllBoxes();
        m.addAttribute("listBoxes", listBoxes);

		m.addAttribute("title","HCL Aladino_Add");
		m.addAttribute("positions", new Positions());
		return "addPositions";
	}


// save the Data from Add a new Boxes Position on a Rack
	@PostMapping("/savePosition")
	public String addBoxesPositionPoints(@ModelAttribute("positions") Positions positions, Model m, RedirectAttributes ra,BindingResult bindingResult) throws MethodArgumentNotValidException, ResourceNotFoundException
	{
		try {
			m.addAttribute("title","HCL Aladino");
			Positions position = this.positionService.createPosition(positions);
			m.addAttribute("positions", position);
			ra.addFlashAttribute("message"," Position is successfully Added");
			return "redirect:/Positions/getAll";
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
			if (bindingResult.hasErrors()) ra.addFlashAttribute("message", "Something went wrong");
			return "redirect:/Positions/getAll";
		}
	}


	}


