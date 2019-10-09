package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(unique = true,
    nullable = false)
    private String cust_name;

    private String cust_city;
    private String working_area;
    private String cust_country;
    private String grade;
    private double open_in_gamt;
    private double recieve_amt;
    private double payment_amt;
    private double outstanding_amt;
    private String phone;

    @Column(unique = true,
            nullable = false)
    private long agent_code;

    @ManyToOne
    @JoinColumn(name = "agentcode",  // links many menus to one restaurant
            nullable = false)
    @JsonIgnoreProperties("customers")
    private Agent agent;

    public Customer()
    {
    }

    public Customer(String cust_name, String cust_city, String working_area, String cust_country, String grade, double open_in_gamt, double recieve_amt, double payment_amt, double outstanding_amt, String phone, long agent_code, Agent agent)
    {
        this.cust_name = cust_name;
        this.cust_city = cust_city;
        this.working_area = working_area;
        this.cust_country = cust_country;
        this.grade = grade;
        this.open_in_gamt = open_in_gamt;
        this.recieve_amt = recieve_amt;
        this.payment_amt = payment_amt;
        this.outstanding_amt = outstanding_amt;
        this.phone = phone;
        this.agent_code = agent_code;
        this.agent = agent;
    }

    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
    {
        this.custcode = custcode;
    }

    public String getCust_name()
    {
        return cust_name;
    }

    public void setCust_name(String cust_name)
    {
        this.cust_name = cust_name;
    }

    public String getCust_city()
    {
        return cust_city;
    }

    public void setCust_city(String cust_city)
    {
        this.cust_city = cust_city;
    }

    public String getWorking_area()
    {
        return working_area;
    }

    public void setWorking_area(String working_area)
    {
        this.working_area = working_area;
    }

    public String getCust_country()
    {
        return cust_country;
    }

    public void setCust_country(String cust_country)
    {
        this.cust_country = cust_country;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpen_in_gamt()
    {
        return open_in_gamt;
    }

    public void setOpen_in_gamt(double open_in_gamt)
    {
        this.open_in_gamt = open_in_gamt;
    }

    public double getRecieve_amt()
    {
        return recieve_amt;
    }

    public void setRecieve_amt(double recieve_amt)
    {
        this.recieve_amt = recieve_amt;
    }

    public double getPayment_amt()
    {
        return payment_amt;
    }

    public void setPayment_amt(double payment_amt)
    {
        this.payment_amt = payment_amt;
    }

    public double getOutstanding_amt()
    {
        return outstanding_amt;
    }

    public void setOutstanding_amt(double outstanding_amt)
    {
        this.outstanding_amt = outstanding_amt;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public long getAgent_code()
    {
        return agent_code;
    }

    public void setAgent_code(long agent_code)
    {
        this.agent_code = agent_code;
    }

    public Agent getAgent()
    {
        return agent;
    }

    public void setAgent(Agent agent)
    {
        this.agent = agent;
    }
}
