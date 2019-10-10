package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
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

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setRecieveamt(customer.getRecieveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
//        newCustomer.setAgent(customer.getAgent());

        for (Order o : customer.getOrders()) // getOrder?
        {
            newCustomer.getOrders().add(new Order(o.getOrd_amount(),
                                                o.getAdvance_amount(),
                                                newCustomer,
                                                o.getOrd_description()));
        }
        return custrepos.save(newCustomer);
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
