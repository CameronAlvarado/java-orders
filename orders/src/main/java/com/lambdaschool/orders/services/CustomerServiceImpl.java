package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired  // field injection
    private CustomerRepo custrepos;

    @Override
    public List<Customer> findOrders()
    {
        List<Customer> rtnList = new ArrayList<>();
        custrepos.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Customer save(Customer customer)
    {
        return null;
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }
}
