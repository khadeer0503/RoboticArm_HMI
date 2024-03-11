package com.HCLProject.Aladino.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Service.BoxesService;

@Controller
@RequestMapping("/Place")
public class PlaceRobotController {
	@Autowired
	private BoxesService boxesService;

	public BoxesService getBoxesService()
		{
			return boxesService;
		}
	public void setBoxesService(BoxesService boxesService)
		{
			this.boxesService = boxesService;
		}

	private static final String ROBODK_MESSAGE = "--- Program is Running in RoboDK Application, kindly do check.";

	 // Keep track of the boxes and their status

	//Left
    private Map<String, Boolean> boxStatus = new HashMap<>();
    private Map<String, Boolean> boxMid = new HashMap<>();
    private Map<String, Boolean> boxEnd = new HashMap<>();
   public PlaceRobotController() {
        // Initialize the box status as available
    	//Side Left- Position Start(1)
        boxStatus.put("Box1", false);
        boxStatus.put("Box2", false);
        boxStatus.put("Box3", false);
        boxStatus.put("Box4", false);
        boxStatus.put("Box5", false);
        boxStatus.put("Box6", false);
    }
//  public void PlaceRobotController1() {
/*
      //Side Left- Position Mid(2)
    	boxMid.put("Box7", false);
    	boxMid.put("Box8", false);
    	boxMid.put("Box9", false);
    	boxMid.put("Box10", false);
    	boxMid.put("Box11", false);
    	//boxMid.put("Box12", false);

  //  public void PlaceRobotController() {
        //Side Left- Position End(3)
    	boxEnd.put("Box1", false);
    	boxEnd.put("Box2", false);
        boxEnd.put("Box3", false);
        boxEnd.put("Box4", false);
        boxEnd.put("Box5", false);
        boxEnd.put("Box6", false);
        boxEnd.put("Box7", false);
        boxEnd.put("Box8", false);
        boxEnd.put("Box9", false);
        boxEnd.put("Box10", false);
        boxEnd.put("Box11", false);
        boxEnd.put("Box12", false);
        boxEnd.put("Box1_200x200", false);
        boxEnd.put("Box2_200x200", false);
        boxEnd.put("Box3_200x200", false);
        boxEnd.put("Box4_200x200", false);
        boxEnd.put("Box5_200x200", false);
        boxEnd.put("Box6_200x200", false);
    }
        // Add more boxes as needed
         *
         * @PostMapping("/place-boxes")
public ResponseEntity<String> placeBoxesOnRack() {
    List<Boxes> boxes = boxesService.getAllBoxes();
    List<PositionPoint> positionPoints = positionPointService.getAllPositionPoints();

    for(PositionPoint positionPoint : positionPoints) {
        if(!positionPoint.isOccupied()) {
            Boxes box = getAvailableBox(boxes);
            if(box != null) {
                // pick and place the box
                robot.pickAndPlace(box, positionPoint);
                // update the box and position point status
                box.setStatus(BoxStatus.OCCUPIED);
                box.setPositionPoint(positionPoint);
                positionPoint.setOccupied(true);
                // save the changes to the database
                boxService.saveBox(box);
                positionPointService.savePositionPoint(positionPoint);
            }
        }
    }

    return ResponseEntity.ok("Boxes placed on the rack successfully.");
}

// helper method to get the first available box
private Box getAvailableBox(List<Box> boxes) {
    for(Box box : boxes) {
        if(box.getStatus() == BoxStatus.AVAILABLE) {
            return box;
        }
    }
    return null;
}

 */

 	private String runPythonScript(String scriptName) {
 	       StringBuilder output = new StringBuilder();
 	          try {
 	               ProcessBuilder processBuilder = new ProcessBuilder("python", "src/" + scriptName);
 	               processBuilder.redirectErrorStream(true);
 	               Process process = processBuilder.start();

 	               BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
 	               String line;
 	               while ((line = reader.readLine()) != null)
 	               {
 	            	output.append(line).append("\n");
 	               }

 	               int exitCode = process.waitFor();
 	               output.append("---Number of Process are waiting: " + exitCode).append("\n");
 	              } catch (IOException | InterruptedException e)
 	                   {
 	               output.append("Error: " + e.getMessage()).append("\n");
 	                   }
 	           return output.toString()
 	        		   .concat(ROBODK_MESSAGE);
}

//------------------PLACING THE OBJECTS SIDE LEFT ----------------------------------------------------

 //	 -------------------------   START   ---------------------------------------------------------

 	//Box status of availability
 	@RequestMapping("/PositionsAvailability")
		@GetMapping("/BoxStatus")
		public String getBoxState(Model model) {
			// Add the box state to the model
		    model.addAttribute("boxStatus_Start", boxStatus);
		    return "RackPositionsLayout";
		}

		@GetMapping("/BoxMid")
		public String getBoxState1(Model model) {
			// Add the box state to the model
		    model.addAttribute("boxMid", boxMid);
		    return "RackPositionsLayout";
		}
		
		@GetMapping("/BoxEnd")
		public String getBoxState2(Model model) {
			// Add the box state to the model
		    model.addAttribute("boxEnd", boxEnd);
		    return "RackPositionsLayout";
		}

 	//1 - dimension of the Box is : 100*100*100

		@GetMapping("/Place_Left_1")
		@ResponseBody
		public Map<String, String> Place_Left_1(Long id,Boxes boxes) {

		    // Mark the box as occupied
		    boxStatus.put("Box1", true);

		    // Run the Python script
		    String response = runPythonScript("python/PlaceLeft/S_Place_Left_1.py");

		    // Construct the JSON response
		    Map<String, String> jsonResponse = new HashMap<>();
		    jsonResponse.put("box", "Box1");
		    jsonResponse.put("rack", "Left_1");
		    jsonResponse.put("message", response);

		return jsonResponse;
		}

/*       @GetMapping("/Place_Left_1")
 		       @ResponseBody
 		       public String Place_Left_1() {
 		    	// Mark the box as occupied
 		    	  boxStatus.put("Box1", true);

 		           return runPythonScript("python/PlaceLeft/S_Place_Left_1.py");
 		       }
*/
 	//2 - dimension of the Box is : 100*100*100

 		       @GetMapping("/Place_Left_2")
 		       @ResponseBody
 		       public String Place_Left_2() {
 		    	  boxStatus.put("Box2", true);
 		           return runPythonScript("python/PlaceLeft/S_Place_Left_2.py");
 		       }
 	//3 - dimension of the Box is : 100*100*100

 		       @GetMapping("/Place_Left_3")
 		       @ResponseBody
 		       public String Place_Left_3() {
 		    	  boxStatus.put("Box3", true);
 		           return runPythonScript("python/PlaceLeft/S_Place_Left_3.py");
 		       }
 	//4 - dimension of the Box is : 100*100*100

 		       @GetMapping("/Place_Left_4")
 		       @ResponseBody
 		       public String Place_Left_4() {
 		    	  boxStatus.put("Box4", true);
 		           return runPythonScript("python/PlaceLeft/S_Place_Left_4.py");
 		       }
 	//5 - dimension of the Box is : 100*100*100
 		       
 		       @GetMapping("/Place_Left_5")
 		       @ResponseBody
 		       public String Place_Left_5() {
 		    	  boxStatus.put("Box5", true);
 		           return runPythonScript("python/PlaceLeft/S_Place_Left_5.py");
 		       }
 	//6 - dimension of the Box is : 100*100*100
 		       
 		       @GetMapping("/Place_Left_6")
 		       @ResponseBody
 		       public String Place_Left_6() {
 		    	  boxStatus.put("Box6", true);
 		           return runPythonScript("python/PlaceLeft/S_Place_Left_6.py");
 		       }
 		       
 		       
// 	 ----------------------------  MID   ---------------------------------------------------------
 		  	 
	   	//1 - dimension of the Box is : 100*100*100
 		   		       
 		   		       @GetMapping("/MidPlace_Left_1")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_1() {
 		   		    	boxMid.put("Box1", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_1.py");
 		   		       }

 		   	//2 - dimension of the Box is : 100*100*100
 		   		       
 		   		       @GetMapping("/MidPlace_Left_2")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_2() {
 		   		    	boxMid.put("Box2", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_2.py");
 		   		       }
 		   	//3 - dimension of the Box is : 100*100*100
 		   		       
 		   		       @GetMapping("/MidPlace_Left_3")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_3() {
 		   		    	boxMid.put("Box3", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_3.py");
 		   		       }
 		   	//4 - dimension of the Box is : 100*100*100
 		   		       
 		   		       @GetMapping("/MidPlace_Left_4")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_4() {
 		   		    	boxMid.put("Box4", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_4.py");
 		   		       }
 		   	//5 - dimension of the Box is : 100*100*100

 		   		       @GetMapping("/MidPlace_Left_5")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_5() {
 		   		    	boxMid.put("Box5", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_5.py");
 		   		       }
 		   	//6 - dimension of the Box is : 100*100*100

 		   		       @GetMapping("/MidPlace_Left_6")
 		   		       @ResponseBody
 		   		       public String MidPlace_Left_6() {
 		   		    	boxMid.put("Box6", true);
 		   		           return runPythonScript("python/PlaceLeft/M_Place_Left_6.py");
 		   		       }

// 	 ---------------------------    END   ---------------------------------------------------------

 		   		 	//1 - dimension of the Box is : 100*100*100

 		   		 		       @GetMapping("/EndPlace_Left_1")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_1() {
 		   		 		    	boxEnd.put("Box1", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_1.py");
 		   		 		       }

 		   		 	//2 - dimension of the Box is : 100*100*100

 		   		 		       @GetMapping("/EndPlace_Left_2")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_2() {
 		   		 		    	boxEnd.put("Box2", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_2.py");
 		   		 		       }
 		   		 	//3 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_3")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_3() {
 		   		 		    	boxEnd.put("Box3", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_3.py");
 		   		 		       }
 		   		 	//4 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_4")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_4() {
 		   		 		    	boxEnd.put("Box4", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_4.py");
 		   		 		       }
 		   		 	//5 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_5")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_5() {
 		   		 		    	boxEnd.put("Box5", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_5.py");
 		   		 		       }
 		   		 	//6 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_6")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_6() {
 		   		 		    	boxEnd.put("Box6", true);
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_6.py");
 		   		 		       }
 		   		   //7 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_7")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_7() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_7.py");
 		   		 		       }

 		   		 	//8 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_8")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_8() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_8.py");
 		   		 		       }
 		   		 	//9 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_9")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_9() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_9.py");
 		   		 		       }
 		   		 	//10 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_10")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_10() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_10.py");
 		   		 		       }
 		   		 	//11 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_11")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_11() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_11.py");
 		   		 		       }
 		   		 	//12 - dimension of the Box is : 100*100*100
 		   		 		       
 		   		 		       @GetMapping("/EndPlace_Left_12")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_12() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_12.py");
 		   		 		       }
 		   		 		       
 		   		 		       
	//1 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_1")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_1() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_1.py");
 		   		 		       }
//2 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_2")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_2() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_2.py");
 		   		 		       }
//3 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_3")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_3() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_3.py");
 		   		 		       }
//4 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_4")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_4() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_4.py");
 		   		 		       }
//5 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_5")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_5() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_5.py");
 		   		 		       }
//6 - dimension of the Box is : 200*200*200
 		   		 		       
 		   		 		       @GetMapping("/E_Place_Left_200x200_6")
 		   		 		       @ResponseBody
 		   		 		       public String EndPlace_Left_200_Layer_6() {
 		   		 		           return runPythonScript("python/PlaceLeft/E_Place_Left_6.py");
 		   		 		       }
 		   		 		       
//------------------PLACING THE OBJECTS SIDE RIGHT ----------------------------------------------------	   
 		   		 		   
 	 //	 -------------------------   START   ---------------------------------------------------------
 		   		 		 	 
 		   		 		  	//1 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_1")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_1() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_1.py");
 		   		 		  		       }

 		   		 		  	//2 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_2")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_2() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_2.py");
 		   		 		  		       }
 		   		 		  	//3 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_3")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_3() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_3.py");
 		   		 		  		       }
 		   		 		  	//4 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_4")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_4() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_4.py");
 		   		 		  		       }
 		   		 		  	//5 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_5")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_5.py");
 		   		 		  		       }
 		   		 		  	//6 - dimension of the Box is : 100*100*100
 		   		 		  		       
 		   		 		  		       @GetMapping("/S_Place_Right_6")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Place_Right_6() {
 		   		 		  		           return runPythonScript("python/PlaceRight/S_Place_Right_6.py");
 		   		 		  		       }
 		   		 		  		       
 		   		 		  		       
// 	 ----------------------------  MID   ---------------------------------------------------------
 		   		 		  		  	 
 		   		 		 	   	//1 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_1")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_1() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_1.py");
 		   		 		  		   		       }

 		   		 		  		   	//2 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_2")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_2() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_2.py");
 		   		 		  		   		       }
 		   		 		  		   	//3 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_3")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_3() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_3.py");
 		   		 		  		   		       }
 		   		 		  		   	//4 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_4")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_4() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_4.py");
 		   		 		  		   		       }
 		   		 		  		   	//5 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_5")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_5() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_5.py");
 		   		 		  		   		       }
 		   		 		  		   	//6 - dimension of the Box is : 100*100*100
 		   		 		  		   		       
 		   		 		  		   		       @GetMapping("/M_Place_Right_6")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Place_Right_6() {
 		   		 		  		   		           return runPythonScript("python/PlaceRight/M_Place_Right_6.py");
 		   		 		  		   		       }
 		   		 		  		   		       
	   		 		  		   		       
 		   		 		 	   		       
// 		   		 		  	 ---------------------------    END   ---------------------------------------------------------
 		   		 		  		   		 	 
 		   		 		  		   		 	//1 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_1")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_1() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_1.py");
 		   		 		  		   		 		       }

 		   		 		  		   		 	//2 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_2")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_2() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_2.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//3 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_3")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_3() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_3.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//4 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_4")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_4() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_4.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//5 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_5")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_5() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_5.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//6 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_6")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_6() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_6.py");
 		   		 		  		   		 		       }
 		   		 		  		   		   //7 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_7")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_7() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_7.py");
 		   		 		  		   		 		       }

 		   		 		  		   		 	//8 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_8")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_8() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_8.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//9 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_9")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_9() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_9.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//10 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_10")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_10() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_10.py");
 		   		 		  		   		 		       }
 		   		 		  		   		 	//11 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_11")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_11() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_11.py");
 		   		 		  		   		 		       }
 		   		 		  		  //		 	//12 - dimension of the Box is : 100*100*100
 		   		 		  		   		 		       
 		   		 		  		   	//	 		       @GetMapping("/E_Place_Right_12")
 		   		 		  		   	//	 		       @ResponseBody
 		   		 		  		   	//	 		       public String E_Place_Right_12() {
 		   		 		  		   	//	 		           return runPythonScript("python/PlaceRight/E_Place_Right_12.py");
 		   		 		  		   	//	 		       }
 		   		 		  		   			       
 		   		 		  		   		 		       
 		   		 		 	//1 - dimension of the Box is : 200*200*200
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_1")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_200x200_1() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_1.py");
 		   		 		  		   		 		       }
 		   		 		 //2 - dimension of the Box is : 200*200*200
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_2")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_200x200_2() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_2.py");
 		   		 		  		   		 		       }
 		   		 		 //3 - dimension of the Box is : 200*200*200
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_3")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_200x200_3() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_3.py");
 		   		 		  		   		 		       }
 		   		 		 //4 - dimension of the Box is : 200*200*200
 		   		 		  		   		 		       
 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_4")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_200x200_4() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_4.py");
 		   		 		  		   		 		       }
 		   		 		 //5 - dimension of the Box is : 200*200*200

 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_5")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Place_Right_200x200_5() {
 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_5.py");
 		   		 		  		   		 		       }
 		   		 		 //6 - dimension of the Box is : 200*200*200

		 		   		 		  		   		 		       @GetMapping("/E_Place_Right_200x200_6")
		 		   		 		  		   		 		       @ResponseBody
		 		   		 		  		   		 		       public String E_Place_Right_200x200_6() {
		 		   		 		  		   		 		           return runPythonScript("python/PlaceRight/E_Place_Right_200x200_6.py");
		 		   		 		  		   		 		       }	   		 		       

}
