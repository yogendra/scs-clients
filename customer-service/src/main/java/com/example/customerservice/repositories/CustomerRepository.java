package com.example.customerservice.repositories;


import com.example.customerservice.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @RestResource(path = "customerName", rel = "customerName")
    Page<Customer> findByCustomerNameIgnoreCase(@Param("q") String name, Pageable pageable);

    @RestResource(path = "customerNameContains", rel = "customerNameContains")
    Page<Customer> findByCustomerNameContainsIgnoreCase(@Param("q") String name, Pageable pageable);

    @Query(value ="select c from Customer c where c.country = :country")
    Page<Customer> findByCountry(@Param("country") String country, Pageable pageable);
}
