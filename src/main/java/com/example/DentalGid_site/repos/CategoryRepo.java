package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.Category;
import com.example.DentalGid_site.domain.Dop_category;
import com.example.DentalGid_site.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Long> {

  List<Category> findAll();




}
