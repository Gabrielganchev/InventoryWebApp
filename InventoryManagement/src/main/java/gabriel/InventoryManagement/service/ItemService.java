package gabriel.InventoryManagement.service;

import gabriel.InventoryManagement.model.Item;
import gabriel.InventoryManagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    //update missing
    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItems(){
        return itemRepository.findAll();

    }

    public void saveItem(Item item){
        itemRepository.save(item);

    }


    public Item getItemById(Long id){
        Optional<Item> optional = itemRepository.findById(id);
        return optional.orElse(null);
    }


    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }


}
