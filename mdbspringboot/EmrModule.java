package com.example.mdbspringboot;

import javax.persistence.*;

@Table(name = "emr_modules")
@Entity
public class EmrModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}