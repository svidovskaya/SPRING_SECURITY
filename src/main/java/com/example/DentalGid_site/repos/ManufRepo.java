package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.Category;
import com.example.DentalGid_site.domain.Manufacturer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufRepo extends CrudRepository<Manufacturer, Long> {

  List<Manufacturer> findAll();

  @Query("SELECT id, manuf_name from Manufacturer ")
  Iterable<Manufacturer> findAllS(Sort sort);



}
