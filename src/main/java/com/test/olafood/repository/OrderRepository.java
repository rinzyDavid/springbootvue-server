package com.test.olafood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.olafood.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long>{

}
