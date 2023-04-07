package jorzel.springprojectapi.service.item;

import jorzel.springprojectapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements ItemInterface {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Item> list() {
        return itemRepository.findAll();
    }

    @Override
    public Item get(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public void store(Item item) {
        saveItem(item);
    }

    @Override
    public void update(Long id, Item item) {
        Optional<Item> itemBD = itemRepository.findById(id);
        if (itemBD.isPresent())
            saveItem(item);
        else
            throw new RuntimeException("Não existe esse item");
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    private void saveItem(Item item) {
        try {
            Optional<Customer> customer = customerRepository.findById(item.getCustomer().getId());
            if (customer.isPresent())
                itemRepository.save(item);
            else
                throw new RuntimeException("Não existe esse usuário");
        } catch (RuntimeException e) {
            return;
        }
    }
}
