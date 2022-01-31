package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "engine_number", unique = true)
    private String number;

    @Column
    private Integer cubature;

    @Column
    private Integer hoursPower;

    public Engine() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCubature() {
        return this.cubature;
    }

    public void setCubature(Integer cubature) {
        this.cubature = cubature;
    }

    public Integer getHoursPower() {
        return this.hoursPower;
    }

    public void setHoursPower(Integer hoursPower) {
        this.hoursPower = hoursPower;
    }
}
