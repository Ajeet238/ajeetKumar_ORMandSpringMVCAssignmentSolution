 package com.gl.customerData.service;

import java.util.List;

import com.gl.customerData.entity.Customer;

public interface CustomerService
{
    List<Customer> findAllCustomer();
    
    Customer findById(final Integer p0);
    
    void save(final Customer p0);
    
    void remove(final Customer p0);
    
    List<Customer> findByParam(final String p0, final String p1, final String p2);
}