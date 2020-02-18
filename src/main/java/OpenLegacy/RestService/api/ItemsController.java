package OpenLegacy.RestService.api;

import OpenLegacy.RestService.db.ItemRepository;
import OpenLegacy.RestService.model.Item;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/items")
@RestController
public class ItemsController {

    private final ItemRepository itemService;

    public ItemsController(ItemRepository itemService) {

        this.itemService = itemService;

        itemService.save(new Item("Boxxxxx", 20,300));
        itemService.save(new Item("Shirt", 10,310));
        itemService.save(new Item("Box2", 20,320));
        itemService.save(new Item("Box3", 20,330));
    }


    @GetMapping
    public JSONArray GetAllItems(){

         Iterable<Item> itemList = itemService.findAll();

         JSONArray jsonArray = new JSONArray();
         for (Item item : itemList){
             jsonArray.add(item.GetJsonObject());
         }
         return jsonArray;
    }

    @GetMapping(path = "{item-number}")
    public JSONObject GetItemDetails(@PathVariable("item-number")Long itemNum){
        Item item = itemService.findById(itemNum).get();
        return item.GetJsonObject();
    }

    @PutMapping(path = "withdrawal/{item-number}/{amount}")
    public void WithdrawalItems(@PathVariable("item-number")Long itemNum, @PathVariable("amount")Integer amount){
        Item item = itemService.findById(itemNum).get();
        if(item!=null){
            Integer itemAmount = item.getAmount();
            if(itemAmount>=amount){
                item.setAmount(itemAmount-amount);
                itemService.save(item);
        }
    }
    }

    @PutMapping(path = "deposit/{item-number}/{amount}")
    public void DepositItems(@PathVariable("item-number")Long itemNum, @PathVariable("amount")Integer amount){
        Item item = itemService.findById(itemNum).get();
        if(item!=null){
            item.setAmount(item.getAmount()+amount);
            itemService.save(item);
        }
    }

    @PostMapping(path = "add/{name}/{amount}/{inventory-code}")
    public void AddItems(@PathVariable("name")String name, @PathVariable("amount")Integer amount, @PathVariable("inventory-code")Integer inventoryCode ){
        Item item = new Item(name, amount, inventoryCode);
        itemService.save(item);
    }

    @DeleteMapping(path = "{item-number}")
    public void DeleteItems(@PathVariable("item-number")Long itemNum){
        itemService.deleteById(itemNum);
    }

}
