package gabriel.InventoryManagement.repository;

import gabriel.InventoryManagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
