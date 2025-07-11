package springboot.Testing.pos.service.impl;

import com.sun.jdi.request.DuplicateRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Testing.pos.dto.ItemDTO;
import springboot.Testing.pos.entity.Customer;
import springboot.Testing.pos.entity.Item;
import springboot.Testing.pos.entity.enums.MesasuringUniteType;
import springboot.Testing.pos.repo.ItemRepo;
import springboot.Testing.pos.service.ItemService;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {
//        Item item = new Item(
//            1,
//            itemDTO.getItemName(),
//            itemDTO.getMesasuringUniteType(),
//            itemDTO.getBalanceQty(),
//            itemDTO.getSupplierPrice(),
//            itemDTO.getSellingPrice(),
//            true
//        );
//        Item savedItem = itemRepo.save(item);
//        return itemDTO.getItemName();

        Item item = modelMapper.map(itemDTO, Item.class);
        if (itemRepo.existsById(item.getItemId())){
            throw new RuntimeException("Item already exists with ID: " + item.getItemId());
        } else {
            Item savedItem = itemRepo.save(item);
            return savedItem.getItemName() + " saved successfully";
        }
    }
}
