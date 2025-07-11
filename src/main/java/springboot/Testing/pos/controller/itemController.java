package springboot.Testing.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.Testing.pos.dto.ItemDTO;
import springboot.Testing.pos.service.ItemService;
import springboot.Testing.pos.util.StandardResponse;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin()
public class itemController {
    @Autowired
    public ItemService itemService;

//    @PostMapping(path = "/save")
//    public String Itemsave(@RequestBody ItemDTO itemDTO){
//        itemService.saveItem(itemDTO);
//        return "saved";
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> Itemsave(@RequestBody ItemDTO itemDTO){
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Item saved successfully",
                        itemService.saveItem(itemDTO)

                ),
                HttpStatus.CREATED
        );
        return response;
    }
}
