package com.example.DentalGid_site.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private String ordr_st;
    private Float ordr_summa;
    private String opl_status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ordinfo_id", referencedColumnName = "info_id")
    private OrderInfo orderInfo;


    public Order() {
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getOrdr_st() {
        return ordr_st;
    }

    public void setOrdr_st(String ordr_st) {
        this.ordr_st = ordr_st;
    }

    public Float getOrdr_summa() {
        return ordr_summa;
    }

    public void setOrdr_summa(Float ordr_summa) {
        this.ordr_summa = ordr_summa;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
