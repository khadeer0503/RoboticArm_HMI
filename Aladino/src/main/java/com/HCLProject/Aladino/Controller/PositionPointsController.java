package com.HCLProject.Aladino.Controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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
import com.HCLProject.Aladino.Model.PositionsPoints;
import com.HCLProject.Aladino.Service.PositionPointsService;

@Controller
//@RestController
@RequestMapping("/Positions")
public class PositionPointsController {
	@Autowired
	private PositionPointsService positionPointsService;
	
    public PositionPointsService getPositionPointsService() {
		return positionPointsService;
	}

	public void setPositionPointsService(PositionPointsService positionPointsService) {
		this.positionPointsService = positionPointsService;
	}
	
//  listing all the Boxes.
					@GetMapping("/getAll")
					public String getAllpositions(Model m)
					{
						List<PositionsPoints> getAll = this.positionPointsService.getAllPosition();
						m.addAttribute("ListPositions", getAll);
						 m.addAttribute("title","HCL Aladino");
						return "getAllPositions";
					}

// GET SINGLE BOX
					@GetMapping("/{id}")
					public String getSingleBox(@PathVariable("id") Long id,Model m) throws BoxNotFoundException, PositionNotFoundException 
					{
						m.addAttribute("title","HCL Aladino");
						PositionsPoints singlePosition = this.positionPointsService.getSinglePosition(id);
						m.addAttribute("PositionsPoints", singlePosition);
						 return "redirect:/Positions/getAll";
						 /* 
						   try {
            PositionsPoints position = positionPointsService.getSinglePosition(id);
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
		    public String updatePosition(PositionsPoints position, @PathVariable Long id, BindingResult bindingResult, Model model) {
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
		m.addAttribute("positionsPoints", new PositionsPoints());
		return "addPositionsPoints";
	} 			


// save the Data from Add a new Boxes Position on a Rack
	@PostMapping("/savePosition")
	public String addBoxesPositionPoints(@ModelAttribute("positionsPoints") PositionsPoints positionsPoints, Model m, RedirectAttributes ra)
	{
		m.addAttribute("title","HCL Aladino");
		PositionPointsService.createPosition(positionsPoints);
		//m.addAttribute("PositionsPoints", positionsPoints);
		ra.addFlashAttribute("message","Box Position is successfully Added");
		System.out.println(positionsPoints);
		return "redirect:/Positions/getAll";
	}
  
//getting the position and checking the status of the position on Rack
	
	   @GetMapping("/Availability/{id}")
	    public String Availability(@PathVariable Long id, Model model) {
	        try {
	            boolean isAvailable = positionPointsService.isAvailable(id);
	            model.addAttribute("isAvailable", isAvailable);
	            return "toggle-success";
	        } catch (EntityNotFoundException e) {
	            model.addAttribute("error", e.getMessage());
	            return e.getMessage();
	        }
	    }
	
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
	    public ResponseEntity<PositionsPoints>  create(@RequestBody PositionsPoints positionsPoints){
	    	PositionsPoints addPositionsPoints = null;
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
	    public  ResponseEntity<PositionsPoints> update(@RequestBody PositionsPoints positionsPoints, @PathVariable("id") Long id) {
	        try {
	        	PositionsPoints updating= this.positionPointsService.updatePosition(positionsPoints, id);
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
	    public  ResponseEntity<PositionsPoints> delete(@RequestBody PositionsPoints positionsPoints, @PathVariable("id") Long id) {
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
	    public  ResponseEntity<PositionsPoints> getById(@RequestBody PositionsPoints positionsPoints, @PathVariable("id") Long id) {
	        try {
	        PositionsPoints getId=this.positionPointsService.getSinglePosition(id);
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
	    public ResponseEntity<List<PositionsPoints>> getAll() {

	        List<PositionsPoints> all =this.positionPointsService.getAllPosition();

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
	    public List<PositionsPoints> findByIsAvailable() {
	        return this.positionPointsService.findByIsAvailable(true);
	    }
	*/	

