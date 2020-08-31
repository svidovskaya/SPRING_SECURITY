package com.example.DentalGid_site.repos;

import com.example.DentalGid_site.domain.Order;
import com.example.DentalGid_site.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {

    List<OrderProduct> findByOrder(Order order);




}
