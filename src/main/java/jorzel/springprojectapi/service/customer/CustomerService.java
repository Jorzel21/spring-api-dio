package jorzel.springprojectapi.service.customer;

import jorzel.springprojectapi.model.Address;
import jorzel.springprojectapi.model.AddressRepository;
import jorzel.springprojectapi.model.Customer;
import jorzel.springprojectapi.model.CustomerRepository;
import jorzel.springprojectapi.service.viaCep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerInterface {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    @Override
    public void store(Customer customer) {
        saveCustomerWithZipCode(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerBD = customerRepository.findById(id);
        if(customerBD.isPresent()) {
            saveCustomerWithZipCode(customer);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private void saveCustomerWithZipCode(Customer customer) {
        String cep = customer.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.searchZipCode(cep);
            addressRepository.save(newAddress);

            return newAddress;
        });
        customer.setAddress(address);
        customerRepository.save(customer);
    }
}