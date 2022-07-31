package com.example.mdbspringboot;

import javax.persistence.*;

@Table(name = "modules_permissions", indexes = {
        @Index(name = "modules_permissions_user_id_key", columnList = "user_id", unique = true)
})
@Entity
public class ModulesPermission {
    @Id
    @Column(name = "permission_id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private EmrModule module;

    @ManyToOne(optional = false)
    @JoinColumn(name = "form_id", nullable = false)
    private ModulesForm form;

    @Column(name = "\"create\"", nullable = false)
    private Boolean create = false;

    @Column(name = "update", nullable = false)
    private Boolean update = false;

    @Column(name = "view", nullable = false)
    private Boolean view = false;

    @Column(name = "delete", nullable = false)
    private Boolean delete = false;

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
    }

    public ModulesForm getForm() {
        return form;
    }

    public void setForm(ModulesForm form) {
        this.form = form;
    }

    public EmrModule getModule() {
        return module;
    }

    public void setModule(EmrModule module) {
        this.module = module;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}