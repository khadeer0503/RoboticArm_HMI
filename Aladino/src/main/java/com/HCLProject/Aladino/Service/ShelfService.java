package com.HCLProject.Aladino.Service;

import com.HCLProject.Aladino.Model.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf creatShelfs(Shelf shelfs);
    Shelf getShelfsById(Long id);
    List<Shelf> getAllShelfs();
    void deleteById(Long id);

}
