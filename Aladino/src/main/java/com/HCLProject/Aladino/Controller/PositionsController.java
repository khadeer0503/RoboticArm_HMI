package com.HCLProject.Aladino.Controller;

import java.util.List;

//import javax.persistence.EntityNotFoundException;

import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.Positions;
import com.HCLProject.Aladino.Service.BoxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
//@RestController
@RequestMapping("/Positions")
public class PositionsController {
	@Autowired
	private PositionsService positionPointsService;
	@Autowired
	private BoxesService boxesService;

    public PositionsService getPositionPointsService() {
		return positionPointsService;
	}
	public void setPositionPointsService(PositionsService positionPointsService) {	this.positionPointsService = positionPointsService;	}
	//getter boxes Service
	public BoxesService getBoxesService() {
		return boxesService;
	}
	//setter boxes Service
	public void setBoxesService(BoxesService boxesService) {
		this.boxesService = boxesService;
	}


	//  listing all the Boxes.
					@GetMapping("/getAll")
					public String getAllpositions(Model m)
					{
						List<Positions> getAll = this.positionPointsService.getAllPosition();
						List<Boxes> getAllBoxes = this.boxesService.getAllBoxes();
						m.addAttribute("ListPositions", getAll);
						m.addAttribute("title","HCL Aladino");
						return "getAllPositions";
					}

// GET SINGLE BOX
					@GetMapping("/{id}")
					public String getSingleBox(@PathVariable("id") Long id,Model m) throws BoxNotFoundException, PositionNotFoundException 
					{
						m.addAttribute("title","HCL Aladino");
						Positions singlePosition = this.positionPointsService.getSinglePosition(id);
						m.addAttribute("Positions", singlePosition);
						return "redirect:/Positions/getAll";
						/*
						try {
            Positions position = positionPointsService.getSinglePosition(id);
            model.addAttribute("position", position);
            return "position-details";
        } catch (PositionNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
						  */
					}

//Delete
		@GetMapping("/delete/{id}")
			public String deletePosition(@PathVariable Long id) {
				try
					{
						positionPointsService.deletePosition(id);
					} catch (PositionNotFoundException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    return "redirect:/Positions/getAll";
				    }
//update

		    @PostMapping("/edit/{id}")
		    public String updatePosition(Positions position, @PathVariable Long id, BindingResult bindingResult, Model model) {
		        try {
		            positionPointsService.updatePosition(position, id);
		            return "redirect:/Positions/getAll";
		        } catch (PositionNotFoundException | PositionAlreadyFullException e) {
		           model.addAttribute("error", e.getMessage());
		            return e.getMessage();
		        }
		    }

//   Add a new Boxes Position on a Rack
	@GetMapping("/addPosition")
	public String addPositionsPoints(Model m)
	{
		m.addAttribute("title","HCL Aladino_Add");
		m.addAttribute("positionsPoints", new Positions());
		return "addPositionsPoints";
	}


// save the Data from Add a new Boxes Position on a Rack
	@PostMapping("/savePosition")
	public String addBoxesPositionPoints(@ModelAttribute("positions") Positions positions, Model m, RedirectAttributes ra,Boxes boxes)
	{
		m.addAttribute("title","HCL Aladino");
		Positions position = this.positionPointsService.createPosition(positions);
		//m.addAttribute("Positions", positions);
		ra.addFlashAttribute("message","Box Position is successfully Added");
		System.out.println(positions);
		return "redirect:/Positions/getAll";
	}

//getting the position and checking the status of the position on Rack

	//    @GetMapping("/Availability/{id}")
	//     public String Availability(@PathVariable Long id, Model model) {
	//         try {
	//           //  boolean isAvailable = positionPointsService.isAvailable(id);
	//          //   model.addAttribute("isAvailable", isAvailable);
	//             return "toggle-success";
	//         } catch (EntityNotFoundException e) {
	//             model.addAttribute("error", e.getMessage());
	//             return e.getMessage();
	//         }
	//     }

	@PutMapping("/{positionOnRack}")
	  public ResponseEntity<String> updatePosition(@PathVariable String positionOnRack) {
	    try {
	      positionPointsService.updateposition(positionOnRack);
	      return ResponseEntity.ok("positionOnRack " + positionOnRack + " is now full");

	    } catch (PositionNotFoundException e) {
	      return ResponseEntity.notFound().build();

	    } catch (PositionAlreadyFullException e) {
	      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

	    }
	  }

	}
	//In this implementation, we use ResponseEntity to provide more control over the HTTP response.
//The PositionNotFoundException is handled by returning a 404 Not Found response,
//and the PositionAlreadyFullException is handled by returning a 409 Conflict response with the exception message in the body.



/*
		// This code is for Rest-full web services

	//Creating boxes Position on a Rack

		@PostMapping("/create")
	    public ResponseEntity<Positions>  create(@RequestBody Positions positionsPoints){
	    	Positions addPositionsPoints = null;
	        try {
	        	addPositionsPoints= this.positionPointsService.createPosition(addPositionsPoints);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    //Updating boxes
	    @PutMapping("/update/{id}")
	    public  ResponseEntity<Positions> update(@RequestBody Positions positionsPoints, @PathVariable("id") Long id) {
	        try {
	        	Positions updating= this.positionPointsService.updatePosition(positionsPoints, id);
	            return ResponseEntity.status(HttpStatus.OK).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        //return new ResponseEntity<Boxes>("Boxes is updated successfully", HttpStatus.OK);
	    }


	    //deleting boxes
	    @DeleteMapping("/delete/{id}")
	    public  ResponseEntity<Positions> delete(@RequestBody Positions positionsPoints, @PathVariable("id") Long id) {
	        try {
	            this.positionPointsService.deletePosition(id);
	            return ResponseEntity.status(HttpStatus.GONE).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    //getting one boxes
	    @GetMapping("/get/{id}")
	    public  ResponseEntity<Positions> getById(@RequestBody Positions positionsPoints, @PathVariable("id") Long id) {
	        try {
	        Positions getId=this.positionPointsService.getSinglePosition(id);
	            if (getId == null) {
	                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	            }
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.FOUND).build();
	    }

	  //list all boxes
	    @GetMapping("/getAll")
	    public ResponseEntity<List<Positions>> getAll() {

	        List<Positions> all =this.positionPointsService.getAllPosition();

	        try {
	            if(all.size() <= 0 )
	                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return ResponseEntity.status(HttpStatus.FOUND).build();
	    }

	  //checking the position available or not on a rack
	    @GetMapping("/available")
	    public List<Positions> findByIsAvailable() {
	        return this.positionPointsService.findByIsAvailable(true);
	    }
	*/

