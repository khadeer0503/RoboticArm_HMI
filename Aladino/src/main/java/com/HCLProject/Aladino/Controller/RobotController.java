/*
package com.HCLProject.Aladino.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import subprocess

@Controller
@RequestMapping("/Robot")
public class RobotController {

	       private static final String ROBODK_MESSAGE = "--- Program is Running in RoboDK Application, kindly do check.";
 

	  	 private String runPythonScript(String scriptName) {
	  	       StringBuilder output = new StringBuilder();
	  	          try {
	  	               ProcessBuilder processBuilder = new ProcessBuilder("python", "J:/Aladino/Aladino/src/" + scriptName);
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
	  	           return output.toString().concat(ROBODK_MESSAGE);
	  	       }
	  	 
//Home position-----
	  	 
	       @GetMapping("/Robot_Home_Pos")
	       @ResponseBody
	       public String Robot_Home_Pos() {
	           return runPythonScript("Robot_Home_Pos.py");
	       }
// Moving objects to its default position
	       @GetMapping("/Replace_Objects")
	       @ResponseBody
	       public String Replace_Objects() {
	           return runPythonScript("Replace_Objects.py");
	       }
//Approaching movement to pick the objects
	       @GetMapping("/Pick_Approach")
	       @ResponseBody
	       public String runRobotProgram() {
	           return runPythonScript("Pick_Approach_Basic.py");
	       }
	       
	       
//----------------------  PICKING THE OBJECTS---------------------------------------------------
	       
	       
//1 - dimension of the Box is : 100*100*100
	       
	       @GetMapping("/Pick_Box_Layer_1")
	       @ResponseBody
	       public String Pick_Box_Layer_1() {
	           return runPythonScript("Pick_Box_Layer_1.py");
	       }
//2       
	       @GetMapping("/Pick_Box_Layer_2")
	       @ResponseBody
	       public String Pick_Box_Layer_2() {
	           return runPythonScript("Pick_Box_Layer_2.py");
	       }
//3	       
	       @GetMapping("/Pick_Box_Layer_3")
	       @ResponseBody
	       public String Pick_Box_Layer_3() {
	           return runPythonScript("Pick_Box_Layer_3.py");
	       }
//4	       
	       @GetMapping("/Pick_Box_Layer_4")
	       @ResponseBody
	       public String Pick_Box_Layer_4() {
	           return runPythonScript("Pick_Box_Layer_4.py");
	       }
//5	       
	       @GetMapping("/Pick_Box_Layer_5")
	       @ResponseBody
	       public String Pick_Box_Layer_5() {
	           return runPythonScript("Pick_Box_Layer_5.py");
	       }
//6	       
	       @GetMapping("/Pick_Box_Layer_6")
	       @ResponseBody
	       public String Pick_Box_Layer_6() {
	           return runPythonScript("Pick_Box_Layer_6.py");
	       }
//7-1	       
	       @GetMapping("/Pick_Box_1")
	       @ResponseBody
	       public String Pick_Box_1() {
	           return runPythonScript("Pick_Box_1.py");
	       }
//8-2	       
	       @GetMapping("/Pick_Box_2")
	       @ResponseBody
	       public String Pick_Box_2() {
	           return runPythonScript("Pick_Box_2.py");
	       }
//9-3	       
	       @GetMapping("/Pick_Box_3")
	       @ResponseBody
	       public String Pick_Box_3() {
	           return runPythonScript("Pick_Box_3.py");
	       }
//10-4	       
	       @GetMapping("/Pick_Box_4")
	       @ResponseBody
	       public String Pick_Box_4() {
	           return runPythonScript("Pick_Box_4.py");
	       }
//11-5	       
	       @GetMapping("/Pick_Box_5")
	       @ResponseBody
	       public String Pick_Box_5() {
	           return runPythonScript("Pick_Box_5.py");
	       }
//12-6	       
	       @GetMapping("/Pick_Box_6")
	       @ResponseBody
	       public String Pick_Box_6() {
	           return runPythonScript("Pick_Box_6.py");
	       }
//1 - dimension of the Box is : 200*200*200       
	       @GetMapping("/Pick_Box_200_Layer_1")
	       @ResponseBody
	       public String Pick_Box_200_Layer_1() {
	           return runPythonScript("Pick_Box_200_Layer_1.py");
	       }
	     //12-6	       
	       @GetMapping("/Pick_Box_200_Layer_2")
	       @ResponseBody
	       public String Pick_Box_200_Layer_2() {
	           return runPythonScript("Pick_Box_200_Layer_2.py");
	       }
	     //12-6	       
	       @GetMapping("/Pick_Box_200_Layer_3")
	       @ResponseBody
	       public String Pick_Box_200_Layer_3() {
	           return runPythonScript("Pick_Box_200_Layer_3.py");
	       }
	     //12-6	       
	       @GetMapping("/Pick_Box_200x200_1")
	       @ResponseBody
	       public String Pick_Box_200x200_1() {
	           return runPythonScript("Pick_Box_200x200_1.py");
	       }
	     //12-6	       
	       @GetMapping("/Pick_Box_200x200_2")
	       @ResponseBody
	       public String Pick_Box_200x200_2() {
	           return runPythonScript("Pick_Box_200x200_2.py");
	       }
	     //12-6	       
	       @GetMapping("/Pick_Box_200x200_3")
	       @ResponseBody
	       public String Pick_Box_200x200_3() {
	           return runPythonScript("Pick_Box_200x200_3.py");
	       }
	       
//------------------PLACING THE OBJECTS SIDE LEFT ----------------------------------------------------	       
	       
	       
     
	   }
   
	*/   
	   
	   
/*
    @Controller
   @RequestMapping("/Robot")
   public class RobotController {
@GetMapping("/Robot_Home_Pos")
    @ResponseBody
    public String Robot_Home_Pos() {
      StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "J:/Aladino/Aladino/src/Robot_Home_Pos.py");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            output.append("Exit code: " + exitCode).append("\n");
        } catch (IOException | InterruptedException e) {
            output.append("Error: " + e.getMessage()).append("\n");
        }
        return output.toString().concat("Robot_Home_Pos Program is Running in RoboDK Application, kindly do check.");
    }

@GetMapping("/Replace_Objects")
    @ResponseBody
    public String Replace_Objects() {
      StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "J:/Aladino/Aladino/src/Replace_Objects.py");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            output.append("Exit code: " + exitCode).append("\n");
        } catch (IOException | InterruptedException e) {
            output.append("Error: " + e.getMessage()).append("\n");
        }
        return output.toString().concat("Replace_Objects Program is Running in RoboDK Application, kindly do check.");
    }


   @GetMapping("/Pick_Approach")
  // @RequestMapping("/Pick_Approach")
    @ResponseBody
    public String runRobotProgram() {
      StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "J:/Aladino/Aladino/src/Pick_Approach_Basic.py");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            output.append("Exit code: " + exitCode).append("\n");
        } catch (IOException | InterruptedException e) {
            output.append("Error: " + e.getMessage()).append("\n");
        }
        return output.toString().concat("Pick_Approach Program is Running in RoboDK Application, kindly do check.");
    }

   
   @GetMapping("/Pick_Box_Layer_1")
	    @ResponseBody
	    public String Pick_Box_Layer_1() {
	      StringBuilder output = new StringBuilder();
	        try {
	            ProcessBuilder processBuilder = new ProcessBuilder("python", "J:/Aladino/Aladino/src/Pick_Box_Layer_1.py");
	            processBuilder.redirectErrorStream(true);
	            Process process = processBuilder.start();

	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	            //System.out.println(line);
	                output.append(line).append("\n");
	            }

	            int exitCode = process.waitFor();
	            output.append("Exit code: " + exitCode).append("\n");
	        } catch (IOException | InterruptedException e) {
	            output.append("Error: " + e.getMessage()).append("\n");
	        }
	        return output.toString().concat("Pick_Box_1 Program is Running in RoboDK Application, kindly do check.");
	    }
  
*/	 
	   
		   
	/*	   try {
			      Process process = Runtime.getRuntime().exec("python F:/HCLProgram/HclProgram/src/test.py");
			      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			      String line;
			      while ((line = in.readLine()) != null) {
			        System.out.println(line);
			      }
			      in.close();
			      process.waitFor();
			    } catch (IOException | InterruptedException e) {
			      e.printStackTrace();
			    }
		   return "pick";
	}  */

	

