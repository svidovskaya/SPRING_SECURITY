package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.Manufacturer;
import com.example.DentalGid_site.domain.UserDevice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDeviceRepo extends CrudRepository<UserDevice, Long> {

  UserDevice findAllByUsername(String username);





}
