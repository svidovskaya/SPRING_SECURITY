package com.example.DentalGid_site.repos;


import com.example.DentalGid_site.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoRepo extends CrudRepository<UserInfo, Long> {

  List<UserInfo> findAll();



}
