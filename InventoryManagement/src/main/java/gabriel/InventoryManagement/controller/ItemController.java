package gabriel.InventoryManagement.controller;

import gabriel.InventoryManagement.model.Item;
import gabriel.InventoryManagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listItems",itemService.getAllItems());

        return "index";
    }

    @GetMapping("/showNewItemForm")
    public String  showNewItemForm(Model model){
        Item item = new Item();
        model.addAttribute("item",item);
        return "new_item";
    }
    // save
    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") Item item){
        itemService.saveItem(item);
        return "redirect:/";
    }
    // update
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id ,Model model){

        Item item = itemService.getItemById(id);
        model.addAttribute("item",item);
        return "update_item";



    }

    //delete
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") Long id){
        this.itemService.deleteById(id);
        return "redirect:/";
    }




}
