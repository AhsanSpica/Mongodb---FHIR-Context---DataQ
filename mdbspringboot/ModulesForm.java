package com.example.mdbspringboot;

import javax.persistence.*;

@Table(name = "modules_forms")
@Entity
public class ModulesForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}