package com.HCLProject.Aladino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HCLProject.Aladino.Service.BoxesService;
import com.HCLProject.Aladino.Service.PositionPointsService;


@Controller
public class GUIController {
	
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
	
	
	@Autowired
	private PositionPointsService positionPointsService;
	
    public PositionPointsService getPositionPointsService() {
		return positionPointsService;
	}

	public void setPositionPointsService(PositionPointsService positionPointsService) {
		this.positionPointsService = positionPointsService;
	}

	
// Normal home page
			@RequestMapping("/")
			public String Home(Model m)
			{
				m.addAttribute("title","HCL - Aladino");
				return "home";
			}
			
//Pick controller		
			@RequestMapping("/pick")
			public String HomePick(Model m)
			{
				m.addAttribute("title","HCL - Aladino");
				return "Pick/pick";
			}
	
			
			
//place left controller		
			@RequestMapping("/place")
			public String PlaceLeft(Model m)
			{
				m.addAttribute("title","HCL - Aladino");
				return "Place_Left/place_Left";
			}
						
		//Left_Start			
					@RequestMapping("/place_Start")
					public String place_Start(Model m)
					{
						m.addAttribute("title","HCL - Aladino");
						return "Place_Left/place_Start";
					}
		//Left_Mid	
					@RequestMapping("/place_Mid")
					public String place_Mid(Model m)
					{
						m.addAttribute("title","HCL - Aladino");
						return "Place_Left/place_Mid";
					}
		//Left_End			
					@RequestMapping("/place_End")
					public String place_End(Model m)
					{
						m.addAttribute("title","HCL - Aladino");
						return "Place_Left/place_End";
					}
	
					
					
//Place_Right controller
					@RequestMapping("/place_Right")
					public String PlaceRight(Model m)
					{
						m.addAttribute("title","HCL - Aladino");
						return "Place_Right/place_Right";
					}
		
					
		//Right_start					
							@RequestMapping("/place_Start_Right")
							public String place_Start_Right(Model m)
							{
								m.addAttribute("title","HCL - Aladino");
								return "Place_Right/place_Start";
							}
		//Right_Mid			
							@RequestMapping("/place_Mid_Right")
							public String place_Mid_Right(Model m)
							{
								m.addAttribute("title","HCL - Aladino");
								return "Place_Right/place_Mid";
							}
		//Right_End					
							@RequestMapping("/place_End_Right")
							public String place_End_Right(Model m)
							{
								m.addAttribute("title","HCL - Aladino");
								return "Place_Right/place_End";
							}
						
							
//drop left controller		
					@RequestMapping("/drop_Left")
					public String dropLeft(Model m)
					{
					  m.addAttribute("title","HCL - Aladino");
					  return "drop_Left/drop_Left";
					}
										
						//Left_Start			
									@RequestMapping("/drop_Start")
									public String drop_Start(Model m)
									{
										m.addAttribute("title","HCL - Aladino");
										return "drop_Left/drop_Start";
									}
						//Left_Mid	
									@RequestMapping("/drop_Mid")
									public String drop_Mid(Model m)
									{
										m.addAttribute("title","HCL - Aladino");
										return "drop_Left/drop_Mid";
									}
						//Left_End			
									@RequestMapping("/drop_End")
									public String drop_End(Model m)
									{
										m.addAttribute("title","HCL - Aladino");
										return "drop_Left/drop_End";
									}
//drop right controller		
					@RequestMapping("/drop_Right")
					public String dropRight(Model m)
					{
					   m.addAttribute("title","HCL - Aladino");
					   return "drop_Right/drop_Right";
					}
														
						//Left_Start			
								@RequestMapping("/drop_Start_Right")
								public String drop_Start_Right(Model m)
								{
									m.addAttribute("title","HCL - Aladino");
									return "drop_Right/drop_Start";
									}
						//Left_Mid	
								@RequestMapping("/drop_Mid_Right")
								public String drop_Mid_Right(Model m)
								{
									m.addAttribute("title","HCL - Aladino");
									return "drop_Right/drop_Mid";
								}
						//Left_End			
								@RequestMapping("/drop_End_Right")
								public String drop_End_Right(Model m)
								{
									m.addAttribute("title","HCL - Aladino");
									return "drop_Right/drop_End";
								}					

}
