package jorzel.springprojectapi.controller;

import jorzel.springprojectapi.model.Item;
import jorzel.springprojectapi.service.item.ItemInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemInterface itemService;

    @GetMapping
    public ResponseEntity<Iterable<Item>> list() {
        return ResponseEntity.ok(itemService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.get(id));
    }

    @PostMapping
    public ResponseEntity<Item> store(@RequestBody Item item) {
        itemService.store(item);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        itemService.update(id, item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
