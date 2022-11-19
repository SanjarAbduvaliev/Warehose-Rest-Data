package com.example.warehoserestdata.service;

import com.example.warehoserestdata.entity.Warehouse;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.WarehoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehoseRepository warehoseRepository;
    public Result add(Warehouse warehouseDto){
        Warehouse warehouse=new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehoseRepository.save(warehouse);
        return new Result("Ombor muvofaqqiyatlik saqlandi",true);

    }
    public List<Warehouse> geAll(){
        return warehoseRepository.findAll();
    }
    public Warehouse getId(Integer id){
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(id);
        return optionalWarehouse.get();
    }
    public Result editWarehose(Warehouse warehouseDto,Integer id){
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(id);
        if (!optionalWarehouse.isPresent()){
            return new Result("Ombor mavjud emas",false);
        }
        Warehouse warehouse = optionalWarehouse.get();
        warehouse.setName(warehouseDto.getName());
        warehoseRepository.save(warehouse);
        return new Result("Ombor o'zgartirildi",true);
    }
    public Result deleteWarehose(Integer id){
        warehoseRepository.deleteById(id);
        return new Result("Ombor o'chilidi",true);
    }
}
