package com.example.warehoserestdata.service;

import com.example.warehoserestdata.entity.Client;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.Warehouse;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.payload.SaleDto;
import com.example.warehoserestdata.repository.ClientRepository;
import com.example.warehoserestdata.repository.CurrencyRepository;
import com.example.warehoserestdata.repository.SaleRepository;
import com.example.warehoserestdata.repository.WarehoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    WarehoseRepository warehoseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addSale(SaleDto saleDto){
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(saleDto.getWarehoseId());
        Optional<Client> optionalClient = clientRepository.findById(saleDto.getClientId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(saleDto.getCurrencyId());

        if (!optionalWarehouse.isPresent())
            return new Result("Bunaqa ombor mavjud emas",false);
        if (!optionalClient.isPresent())
            return new Result("Bunday haridor mavjud emas",true);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta noto'g' kiritildi",false);
        Input input =new Input();
        input.setSaleDate(saleDto.getTimesDate());
        input.setWarehouse(optionalWarehouse.get());
        input.setClient(optionalClient.get());
        input.setCurrency(optionalCurrency.get());
        saleRepository.save(input);
        return new Result("Chiqim saqlandi",true);
    }
    public List<Input> getAll(){
        return saleRepository.findAll();
    }
    public Input getId(Integer id){
        Optional<Input> optionalSale = saleRepository.findById(id);
        if (!optionalSale.isPresent())
            return null;
        return optionalSale.get();
    }
    public Result edit(SaleDto saleDto, Integer id){
        Optional<Input> optionalSale = saleRepository.findById(id);
        Input input = optionalSale.get();

        Client byClient_id = saleRepository.findByClient_Id(saleDto.getClientId());
        Currency byCurrency_id = saleRepository.findByCurrency_Id(saleDto.getCurrencyId());
        Warehouse byWarehouse_id = saleRepository.findByWarehouse_Id(saleDto.getWarehoseId());



        input.setWarehouse(byWarehouse_id);
        input.setClient(byClient_id);
        input.setCurrency(byCurrency_id);
        input.setSaleDate(saleDto.getTimesDate());
        input.setCode("1");
        input.setFactureNumber("1");
        saleRepository.save(input);
        return new Result("Chiqim o'zgaritildi",true);

    }
    public Result delete(Integer id){
        saleRepository.deleteById(id);
        return  new Result("Chiqimlar tarixidan 'chirildi",true);
    }
}
