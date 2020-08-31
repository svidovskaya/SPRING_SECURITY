package com.example.DentalGid_site.repos;

import com.example.DentalGid_site.domain.Order;
import com.example.DentalGid_site.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}
