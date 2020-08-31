package com.example.DentalGid_site.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dop_category")
public class Dop_category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "category_id")
    private Category category;

//@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Product> products;
@ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
@JoinTable(name = "dop_category_products",
        joinColumns = { @JoinColumn(name = "dop_cat_id") },
        inverseJoinColumns = { @JoinColumn(name = "prod_id") })
private Set<Product> productsSet = new HashSet<>();

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(Set<Product> productsSet) {
        this.productsSet = productsSet;
    }
}
