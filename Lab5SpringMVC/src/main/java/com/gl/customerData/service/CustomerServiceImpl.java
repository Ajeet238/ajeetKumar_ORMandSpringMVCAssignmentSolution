 package com.gl.customerData.service;

import org.hibernate.Transaction;
import java.io.Serializable;
import javax.transaction.Transactional;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gl.customerData.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService
{
    private SessionFactory sessionfactory;
    private Session session;
    
    public CustomerServiceImpl(final SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
        try {
            this.session = this.sessionfactory.getCurrentSession();
        }
        catch (HibernateException e) {
            this.session = this.sessionfactory.openSession();
        }
    }
    
    @Transactional
    @Override
    public List<Customer> findAllCustomer() {
        final List<Customer> CustomerList = (List<Customer>)this.session.createQuery("from Customer").list();
        return CustomerList;
    }
    
    @Transactional
    @Override
    public Customer findById(final Integer id) {
        final Customer Customer = (Customer)this.session.get((Class)Customer.class, (Serializable)id);
        return Customer;
    }
    
    @Transactional
    @Override
    public void save(final Customer Customer) {
        final Transaction tr = this.session.beginTransaction();
        this.session.saveOrUpdate((Object)Customer);
        tr.commit();
    }
    
    @Transactional
    @Override
    public void remove(final Customer s) {
        final Transaction tr = this.session.beginTransaction();
        this.session.delete((Object)s);
        tr.commit();
    }
    
    @Transactional
    @Override
    public List<Customer> findByParam(final String firstName, final String lastName, final String email) {
        List<Customer> ls = null;
        String query = "";
        if (firstName != null && lastName != null && email != null) {
            query = "from Customer where firstName like '%" + firstName + "%' and lastName like '%" + lastName + "%' and email like '%" + email + "%'";
        }
        else if (firstName != null && lastName == null && email == null) {
            query = "from Customer where firstName like '%" + firstName + "%'";
        }
        else if (firstName == null && lastName != null && email == null) {
            query = "from Customer where lastName like '%" + lastName + "%'";
        }
        else if (firstName == null && lastName == null && email != null) {
            query = "from Customer where email like '%" + email + "%'";
        }
        else {
            query = "from Customer";
        }
        if (query.length() != 0) {
            ls = (List<Customer>)this.session.createQuery(query).list();
        }
        return ls;
    

}
}
