package jorzel.springprojectapi.service.customer;

import jorzel.springprojectapi.model.Customer;

public interface CustomerInterface {
    Iterable<Customer> list();

    Customer get(Long id);

    void store(Customer customer);

    void update(Long id, Customer customer);

    void delete(Long id);
}
