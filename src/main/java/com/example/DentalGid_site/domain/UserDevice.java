package com.example.DentalGid_site.domain;


import javax.persistence.*;

@Entity
@Table(name = "usr_device")
public class UserDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String op_sys;
    private String brauser;

    public UserDevice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getOp_sys() {
        return op_sys;
    }

    public void setOp_sys(String op_sys) {
        this.op_sys = op_sys;
    }

    public String getBrauser() {
        return brauser;
    }

    public void setBrauser(String brauser) {
        this.brauser = brauser;
    }
}
