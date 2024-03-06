package com.HCLProject.Aladino.Service.Impl;

import com.HCLProject.Aladino.Model.Shelf;
import com.HCLProject.Aladino.Repo.ShelfRepo;
import com.HCLProject.Aladino.Service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfRepo shelfRepo;

    @Override
    public Shelf creatShelfs(Shelf shelfs) {
        return this.shelfRepo.save(shelfs);
    }

    @Override
    public Shelf getShelfsById(Long id) {
        return this.shelfRepo.findById(id).get();
    }

    @Override
    public List<Shelf> getAllShelfs() {
        return this.shelfRepo.findAll();
    }

    @Override
    public void deleteById(Long id) { this.shelfRepo.deleteById(id);    }
}
