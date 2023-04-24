package com.infy.workflixbackend42.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name ="defect")
public class Defect {
    @Id
    @Column(name = "defect_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer defectId;

    @Column(name="category")
    private String category;

    @Column(name="priority")
    private Integer priority;

    @Column(name="status")
    private String status;

    @Column(name="description")
    private String description;

    public Integer getDefectId() {
        return defectId;
    }

    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
