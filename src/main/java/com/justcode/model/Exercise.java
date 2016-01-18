package com.justcode.model;

import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(generator = "incrementGen")
    @GenericGenerator(name = "incrementGen", strategy = "increment")
    private Long id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SupportedTechnologies technology;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SupportedLevels level;

    @NotNull
    private String description;

    @ManyToOne
    private User author;

    @NotNull
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SupportedTechnologies getTechnology() {
        return technology;
    }

    public void setTechnology(SupportedTechnologies technology) {
        this.technology = technology;
    }

    public SupportedLevels getLevel() {
        return level;
    }

    public void setLevel(SupportedLevels level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
