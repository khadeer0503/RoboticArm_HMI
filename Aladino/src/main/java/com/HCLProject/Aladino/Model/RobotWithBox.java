package com.HCLProject.Aladino.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RobotWithBox {
    @Id
    private Long id;
    @Column(name="RobotWithBox")
    private Boolean isPresent = false;

    public RobotWithBox() {
    }

    public RobotWithBox(Long id, Boolean isPresent) {
        this.id = id;
        this.isPresent = isPresent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "RobotWithBox{" +
                "id=" + id +
                ", isPresent=" + isPresent +
                '}';
    }
}
