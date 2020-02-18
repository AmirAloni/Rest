package OpenLegacy.RestService.db;

import OpenLegacy.RestService.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {}
