package com.example.warehoserestdata.service;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.Supplier;
import com.example.warehoserestdata.entity.Warehouse;
import com.example.warehoserestdata.payload.InputDto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.SuplierRepository;
import com.example.warehoserestdata.repository.CurrencyRepository;
import com.example.warehoserestdata.repository.InputRepository;
import com.example.warehoserestdata.repository.WarehoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InputService {
    private static final AtomicLong sequence=new AtomicLong();
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SuplierRepository suplierRepository;
    @Autowired
    WarehoseRepository warehoseRepository;
    @Autowired
    InputRepository inputRepository;
    

    public Result add(InputDto inputDto){
        Input input=new Input();
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        Optional<Supplier> optionalSupplier = suplierRepository.findById(inputDto.getSupplierId());
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(inputDto.getWarehoseid());
        input.setCurrency(optionalCurrency.get());
        input.setSupplier(optionalSupplier.get());
        input.setWarehouse(optionalWarehouse.get());
        input.setCode("1");
        input.setFactureNumber("1");
        inputRepository.save(input);
        return  new Result("Saqlandi",true);
    }
    public List<Input> getAll(){
        return inputRepository.findAll();
    }
    public Input getID(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        return optionalInput.get();
    }
    public Result edit(InputDto inputDto, Integer id){
        Warehouse warehouseId = inputRepository.findByWarehouse_Id(inputDto.getCurrencyId());
        Currency currencyId = inputRepository.findByCurrency_Id(inputDto.getCurrencyId());
        Supplier supplierId = inputRepository.findBySupplier_Id(inputDto.getSupplierId());

        Optional<Input> optionalInput = inputRepository.findById(id);
        Input input = optionalInput.get();
        input.setSaleDate(inputDto.getTimestamp());
        input.setCode(sequence().toString());
        input.setFactureNumber(sequence().toString());
        input.setWarehouse(warehouseId);
        input.setCurrency(currencyId);
        input.setSupplier(supplierId);
        return new Result("Kirim o'zgartirildi",true);

    }
    public Result delete(Integer id){
        inputRepository.deleteById(id);
        return new Result("Kirim olib tashlandi",true);
    }

    public Long sequence(){
        return  sequence.incrementAndGet();
    }
}
