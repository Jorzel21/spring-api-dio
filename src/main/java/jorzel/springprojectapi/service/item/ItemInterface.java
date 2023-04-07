package jorzel.springprojectapi.service.item;

import jorzel.springprojectapi.model.Item;

public interface ItemInterface {
    Iterable<Item> list();

    Item get(Long id);

    void store(Item item);

    void update(Long id, Item item);

    void delete(Long id);
}
