package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.Dop_category;
import com.example.DentalGid_site.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface DopCategoryRepo extends CrudRepository<Dop_category, Long> {

  List<Dop_category> findAll();
  List<Dop_category> findByCategory_Id(Long id);
  // findByCategory_Id(Long id);


}
