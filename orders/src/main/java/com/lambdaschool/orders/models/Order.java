package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ord_amount;
    private double advance_amount;

    @ManyToOne
    @JoinColumn(name = "custcode",  // links many orders to one customer
            nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    private String ord_description;

    public Order()
    {
    }

    public Order(double ord_amount, double advance_amount, Customer customer, String ord_description)
    {
        this.ord_amount = ord_amount;
        this.advance_amount = advance_amount;
        this.customer = customer;
        this.ord_description = ord_description;
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrd_amount()
    {
        return ord_amount;
    }

    public void setOrd_amount(double ord_amount)
    {
        this.ord_amount = ord_amount;
    }

    public double getAdvance_amount()
    {
        return advance_amount;
    }

    public void setAdvance_amount(double advance_amount)
    {
        this.advance_amount = advance_amount;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public String getOrd_description()
    {
        return ord_description;
    }

    public void setOrd_description(String ord_description)
    {
        this.ord_description = ord_description;
    }

}
