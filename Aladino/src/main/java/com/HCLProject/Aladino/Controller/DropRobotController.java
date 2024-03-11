package com.HCLProject.Aladino.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Drop")
public class DropRobotController {

	private static final String ROBODK_MESSAGE = "--- Program is Running in RoboDK Application, kindly do check.";


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
 	           return output.toString().concat(ROBODK_MESSAGE);
 	       }

//------------------DROPING THE OBJECTS PICKING SIDE LEFT ----------------------------------------------------

 //	 -------------------------   START   ---------------------------------------------------------


//1 - dimension of the Box is : 100*100*100

						@GetMapping("/S_Drop_Left_{number}")
							@ResponseBody
								public String S_Drop_Left(@PathVariable String number) {
								String S_Drop_Left = String.format("python/DropLeft/S_Drop_Left_%s.py", number);
								return runPythonScript(S_Drop_Left);
								}
// 	 ----------------------------  MID   ---------------------------------------------------------
						@GetMapping("/M_Drop_Left_{number}")
							@ResponseBody
								public String M_Drop_Left(@PathVariable String number) {
								String M_Drop_Left = String.format("python/DropLeft/M_Drop_Left_%s.py", number);
								return runPythonScript(M_Drop_Left);
								}
// 	 ---------------------------    END   ---------------------------------------------------------
						@GetMapping("/E_Drop_Left_{number}")
							@ResponseBody
								public String E_Drop_Left(@PathVariable String number) {
								String E_Drop_Left = String.format("python/DropLeft/E_Drop_Left_%s.py", number);
								return runPythonScript(E_Drop_Left);
								}

//1 - dimension of the Box is : 200*200*200
						@GetMapping("/E_Drop_Left_200x200_{number}")
						@ResponseBody
							public String E_Drop_Left_200x200(@PathVariable String number) {
							String E_Drop_Left_200x200 = String.format("python/DropLeft/E_Drop_Left_200x200_%s.py", number);
							return runPythonScript(E_Drop_Left_200x200);
							}


//------------------DROPPING THE OBJECTS SIDE RIGHT ----------------------------------------------------

//	 -------------------------   START   ---------------------------------------------------------


//1 - dimension of the Box is : 100*100*100

						@GetMapping("/S_Drop_Right_{number}")
							@ResponseBody
								public String S_Drop_Right(@PathVariable String number) {
								String S_Drop_Right = String.format("python/DropRight/S_Drop_Right_%s.py", number);
								return runPythonScript(S_Drop_Right);
								}
// 	 ----------------------------  MID   ---------------------------------------------------------

							@GetMapping("/M_Drop_Right_{number}")
							@ResponseBody
								public String M_Drop_Right(@PathVariable String number) {
								String M_Drop_Right = String.format("python/DropRight/M_Drop_Right_%s.py", number);
								return runPythonScript(M_Drop_Right);
								}


// 		   		 		  	 ---------------------------    END   ---------------------------------------------------------
							@GetMapping("/E_Drop_Right_{number}")
							@ResponseBody
								public String E_Drop_Right(@PathVariable String number) {
								String E_Drop_Right = String.format("python/DropRight/E_Drop_Right_%s.py", number);
								return runPythonScript(E_Drop_Right);
								}

//1 - dimension of the Box is : 200*200*200
							@GetMapping("/E_Drop_Right_200x200_{number}")
							@ResponseBody
								public String E_Drop_Right_200x200(@PathVariable String number) {
								String E_Drop_Right_200 = String.format("python/DropRight/E_Drop_Right_200x200_%s.py", number);
								return runPythonScript(E_Drop_Right_200);
								}

}



/*   ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//1 - dimension of the Box is : 200*200*200

 		   		 		       @GetMapping("/E_Drop_Left_200x200_1")
 		   		 		    @ResponseBody
 		   		 		    public String E_Drop_Left_200x200_1() {
 		   		 		        return runPythonScript("python/DropLeft/E_Drop_Left_200x200_1.py");
							}


//------------------DROPING THE OBJECTS SIDE RIGHT ----------------------------------------------------

 	 //	 -------------------------   START   ---------------------------------------------------------

 		   		 		  	//1 - dimension of the Box is : 100*100*100

 		   		 		  		       @GetMapping("/S_Drop_Right_1")
 		   		 		  		       @ResponseBody
 		   		 		  		       public String S_Drop_Right_1() {
 		   		 		  		           return runPythonScript("python/DropRight/S_Drop_Right_1.py");
 		   		 		  		       }



// 	 ----------------------------  MID   ---------------------------------------------------------

 		   		 		 	   	//1 - dimension of the Box is : 100*100*100

 		   		 		  		   		       @GetMapping("/M_Drop_Right_1")
 		   		 		  		   		       @ResponseBody
 		   		 		  		   		       public String M_Drop_Right_1() {
 		   		 		  		   		           return runPythonScript("python/DropRight/M_Drop_Right_1.py");
 		   		 		  		   		       }


// 		   		 		  	 ---------------------------    END   ---------------------------------------------------------

 		   		 		  		   		 	//1 - dimension of the Box is : 100*100*100

 		   		 		  		   		 		       @GetMapping("/E_Drop_Right_1")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Drop_Right_1() {
 		   		 		  		   		 		           return runPythonScript("python/DropRight/E_Drop_Right_1.py");
 		   		 		  		   		 		       }

 		   		 		 	//1 - dimension of the Box is : 200*200*200

 		   		 		  		   		 		       @GetMapping("/E_Drop_Right_200x200_1")
 		   		 		  		   		 		       @ResponseBody
 		   		 		  		   		 		       public String E_Drop_Right_200x200_1() {
 		   		 		  		   		 		           return runPythonScript("python/DropRight/E_Drop_Right_200x200_1.py");
 		   		 		  		   		 		       }


*/

// *********************************************************************************************************************************************************
/*


 */