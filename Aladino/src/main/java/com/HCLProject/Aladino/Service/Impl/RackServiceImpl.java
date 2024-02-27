package com.HCLProject.Aladino.Service.Impl;

import com.HCLProject.Aladino.Model.Rack;
import com.HCLProject.Aladino.Repo.RackRepo;
import com.HCLProject.Aladino.Service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackServiceImpl implements RackService {

    @Autowired
    private RackRepo rackRepo;


    @Override
    public Rack createRack(Rack rack) {
        return this.rackRepo.save(rack);
    }

    @Override
    public List<Rack> getAll() {
        return this.rackRepo.findAll();
    }

    @Override
    public Rack getRackById(Long id) {
        return this.rackRepo.findById(id).get();
    }

    @Override
    public Rack save(Rack rack, long id) {
        Rack rackById =  this.rackRepo.findById(id).get();
        return this.rackRepo.save(rackById);
    }

    @Override
    public void deleteRack(Long id) {
this.rackRepo.deleteById(id);
    }
}
