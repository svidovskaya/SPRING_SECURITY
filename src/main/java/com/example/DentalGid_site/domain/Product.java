package com.example.DentalGid_site.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String kode;
    private String shtrih;
    private String discript;
    private String discription;
    private Float price;
    private String imgname;



@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "manuf_id")
    private Manufacturer manufacturer;
@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "dop_category_products",
            joinColumns = { @JoinColumn(name = "prod_id") },
            inverseJoinColumns = { @JoinColumn(name = "dop_cat_id") })
    private Set<Dop_category> dop_categoriesSet;
//    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
//    private List<Dop_category> dop_categories;
//@ManyToMany(cascade = CascadeType.ALL)
//@JoinTable(name = "dop_category_products",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "dop_id"))
//public Set<Dop_category> dop_cat;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getShtrih() {
        return shtrih;
    }

    public void setShtrih(String shtrih) {
        this.shtrih = shtrih;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public Set<Dop_category> getDop_categoriesSet() {
        return dop_categoriesSet;
    }

    public void setDop_categoriesSet(Set<Dop_category> dop_categoriesSet) {
        this.dop_categoriesSet = dop_categoriesSet;
    }

}
