package com.HCLProject.Aladino.Controller;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Service.BoxesService;
import com.HCLProject.Aladino.Service.RobotWithBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RobotWithBoxController {

    @Autowired
    private BoxesService boxesService;
    @Autowired
    private RobotWithBoxService robotWithBoxService;

    public BoxesService getBoxesService() {   return boxesService;    }

    public void setBoxesService(BoxesService boxesService) {  this.boxesService = boxesService;    }

    public RobotWithBoxService getRobotWithBoxService() {   return robotWithBoxService;    }

    public void setRobotWithBoxService(RobotWithBoxService robotWithBoxService) {  this.robotWithBoxService = robotWithBoxService;    }


    @DeleteMapping("/{id}")
    public void pickBox(@PathVariable Long id) throws BoxNotFoundException {
        this.robotWithBoxService.pickBox(id);

    }


}
