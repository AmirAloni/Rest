package OpenLegacy.RestService.model;

import net.minidev.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Number;
    private String Name;
    private Integer Amount;
    private Integer InventoryCode;

    protected Item() {}

    public Item(String name, Integer amount, Integer inventoryCode) {
        Name = name;
        Amount = amount;
        InventoryCode = inventoryCode;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getInventoryCode() {
        return InventoryCode;
    }

    public void setInventoryCode(Integer inventoryCode) {
        InventoryCode = inventoryCode;
    }

    public JSONObject GetJsonObject(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("number", Number);
        jsonObject.put("name", Name);
        jsonObject.put("amount", Amount);
        jsonObject.put("inventory-code", InventoryCode);

        return jsonObject;
    }
}
