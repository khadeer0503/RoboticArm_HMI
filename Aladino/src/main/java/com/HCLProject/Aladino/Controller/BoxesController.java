package com.HCLProject.Aladino.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.PositionsPoints;
import com.HCLProject.Aladino.Service.BoxesService;





@Controller
//@RestController
@RequestMapping("/Boxes")
public class BoxesController {

@Autowired
	private BoxesService boxesService;
	//getter boxes Service
	public BoxesService getBoxesService() {
		return boxesService;
	}
	//setter boxes Service
	public void setBoxesService(BoxesService boxesService) {
		this.boxesService = boxesService;
	}

/*
	//getting all the Positions occupied /filled
	@GetMapping("/")
	public String showAvailablePositions(Model model) {
	List<PositionsPoints> availablePositions = boxesService.getAvailablePositions();
	model.addAttribute("positions", availablePositions);
	return "positions";
	}
	*/

//   listing all the Boxes.
					@GetMapping("/getAll")
					public String getAllboxes(Model m)
					{
						List<Boxes> getAll = this.boxesService.getAllBoxes();
						m.addAttribute("ListBoxes", getAll);
						m.addAttribute("title","HCL Aladino");
						return "getAllBoxes";
					}

// GET SINGLE BOX
					@GetMapping("/{id}")
					public String getSingleBox(@PathVariable("id") Long id,Model m) throws BoxNotFoundException 
					{
						m.addAttribute("title","HCL Aladino");
						Boxes box =	this.boxesService.findbyId(id);
						m.addAttribute("boxes", box);
						return "redirect:/Boxes/getAll";
					}


//   Add new Boxes 
    	@GetMapping("/addBox")
		public String addBox(Model m)
		{
    		m.addAttribute("title","HCL Aladino_Add");
    		m.addAttribute("boxes", new Boxes());
			return "addBox";
		} 

// save the Data from Add a new Box
		@PostMapping("/saveAddedBox")
		public String addNewBox(@ModelAttribute("boxes") Boxes boxes, Model m, RedirectAttributes ra)
		{
			m.addAttribute("title","HCL Aladino");
			this.boxesService.saveBox(boxes);
			//m.addAttribute("Boxes", boxes);
			ra.addFlashAttribute("message","Box successfully Added");
			return "redirect:/Boxes/getAll";
		}

//updateOrSave Boxes
//@PutMapping("/updatingBox/{id}")
		 @RequestMapping(value="/editForm/{id}",method = {RequestMethod.PUT,RequestMethod.GET }) 
			public String updatingBox(@PathVariable("id") Long id ,@ModelAttribute("boxes") Boxes boxes,Model m) 
		{
			m.addAttribute("title","HCL Aladino");
			try
				{
					this.boxesService.updateBoxes(id, boxes);
				} catch (BoxNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PositionNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PositionAlreadyFullException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("updating box");
			return "editForm";

		}

//@PostMapping("/updatedBox/{id}")
		@RequestMapping(value="/updatedBox/{id}",method = {RequestMethod.PUT ,RequestMethod.POST,RequestMethod.GET })
		public String updateBox(@PathVariable Long id, @ModelAttribute Boxes boxes, Model model) throws BoxNotFoundException {
			Boxes existingBox = boxesService.findbyId(id);
			//.orElseThrow(() -> new IllegalArgumentException("Invalid box id:" + id));
			existingBox.setDimension(boxes.getDimension());
			existingBox.setpositionsPoints(boxes.getpositionsPoints());
			existingBox.setWeight(boxes.getWeight());
			existingBox.setName(boxes.getName());

			Boxes updatedBox = boxesService.saveBox(existingBox);
			model.addAttribute("boxes", updatedBox);
			//return "editForm";
			return "redirect:/Boxes/getAll";
		}

//delete by id
//@DeleteMapping("/delete/{id}")
		@RequestMapping(value="/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET })
		public String  delete(@PathVariable("id") Long id)
		{
			this.boxesService.deleteBoxesById(id);
			return "redirect:/Boxes/getAll";
		}


}



/*

	// This code is for Rest-full web services


	//Creating boxes

	    @PostMapping("/create")
	    public ResponseEntity<Boxes>  create(@RequestBody Boxes box){
		 Boxes addbox = null;
	        try {
	           addbox= this.boxesService.createBoxes(box);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    //Updating boxes
	    @PutMapping("/update/{id}")
	    public  ResponseEntity<Boxes> update(@RequestBody Boxes box, @PathVariable("id") Long id) {
	      /*  try {
	        	Boxes updating= this.boxesService.updateBoxes(box, id);
	            return ResponseEntity.status(HttpStatus.OK).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        //return new ResponseEntity<Boxes>("Boxes is updated successsfully", HttpStatus.OK);
	    }*/

	    /* Boxes existingBox = boxesService.getBoxById(id);
        if (existingBox == null) {
            return ResponseEntity.notFound().build();
        }
        existingBox.setName(boxes.getName());
        existingBox.setDimension(boxes.getDimension());
        existingBox.setWeight(boxes.getWeight());
        existingBox.setPositionPoint(boxes.getPositionPoint());
        existingBox.setOccupied(boxes.isOccupied());
        boxService.updateBox(existingBox);
        return ResponseEntity.ok().build();
    } */

/*
	    //deleting boxes
	    @DeleteMapping("/delete/{id}")
	    public  ResponseEntity<Boxes> delete(@RequestBody Boxes box, @PathVariable("id") Long id) {
	        try {
	            this.boxesService.deleteBoxesById(id);
	            return ResponseEntity.status(HttpStatus.GONE).build();
	        } catch (Exception e) {
	            //e.getStackTrace()
	            e.printStackTrace();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    //getting one boxes
	    @GetMapping("/get/{id}")
	    public  ResponseEntity<Boxes> getById(@RequestBody Boxes box, @PathVariable("id") Long id) {
	        try {
	        	Boxes getId=this.boxesService.findbyId(id);
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
	    public ResponseEntity<List<Boxes>> getAll()
	    	{

	        List<Boxes> all =this.boxesService.getAllBoxes();

	        try {
	            if(all.size() <= 0 )
	                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return ResponseEntity.status(HttpStatus.FOUND).build();
	    }
 
}

*/
