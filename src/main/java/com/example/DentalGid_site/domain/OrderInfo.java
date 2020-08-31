package com.example.DentalGid_site.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_info")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long info_id;


    @OneToOne(mappedBy = "orderInfo")
    private Order order;

    private String dostavka_method;
    private String dostavka_adr;
    private String opl_method;

    public OrderInfo() {
    }

    public Long getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Long info_id) {
        this.info_id = info_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDostavka_method() {
        return dostavka_method;
    }

    public void setDostavka_method(String dostavka_method) {
        this.dostavka_method = dostavka_method;
    }

    public String getDostavka_adr() {
        return dostavka_adr;
    }

    public void setDostavka_adr(String dostavka_adr) {
        this.dostavka_adr = dostavka_adr;
    }

    public String getOpl_method() {
        return opl_method;
    }

    public void setOpl_method(String opl_method) {
        this.opl_method = opl_method;
    }
}
