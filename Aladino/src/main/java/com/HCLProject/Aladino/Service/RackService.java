package com.HCLProject.Aladino.Service;

import com.HCLProject.Aladino.Model.Rack;

import java.util.List;

public interface RackService {
    Rack createRack(Rack rack);
    List<Rack> getAll();
    Rack getRackById(Long id);
    Rack save(Rack rack,long id);
    void deleteRack(Long id);

}
