package com.HCLProject.Aladino.Service;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;

public interface RobotWithBoxService {
    Boolean isPresent(Long id);
    public void pickBox(Long id) throws BoxNotFoundException;
}
