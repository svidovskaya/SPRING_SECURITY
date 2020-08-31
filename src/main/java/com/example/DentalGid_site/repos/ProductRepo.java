package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.Dop_category;
import com.example.DentalGid_site.domain.Manufacturer;
import com.example.DentalGid_site.domain.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepo extends CrudRepository<Product, Long> {

  List<Product> findByNameContaining(String name);
  List<Product> findByShtrih(String name);
  Product findById(int id);
  //List<Product> findByManufacturer(String name);
  List<Product> findByManufacturer(Optional<Manufacturer> manufacturer);
  List<Product> findByManufacturerAndNameContaining(Optional<Manufacturer> manufacturer, String name);

  @Query("SELECT id, name, price FROM Product where price>= :min and price <= :max order by name asc")
  List<Product> findProductByPriceParams(@Param("min") Float min, @Param("max") Float max);

  List<Product> findByPriceBetweenOrderByNameAsc(Float min, Float max);

}
