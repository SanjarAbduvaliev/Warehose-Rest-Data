package com.example.warehoserestdata.service;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public Result addCurrency(Currency currencyDto){

        Currency currency=new Currency();
        currency.setName(currencyDto.getName());
        currencyRepository.save(currency);
        return new Result("Valyuta saqlandi",true);
    }
    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }
    public Currency getId(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()){
            return new Currency();
        }
        return optionalCurrency.get();
    }
    public Result edit(Currency currencyDto,Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()){
            return new Result("Valyutani topolmadik",false);
        }
        Currency currency = optionalCurrency.get();
        Currency firstCurrency=currency;
        currency.setName(currencyDto.getName());
        currencyRepository.save(currency);
        return  new Result(firstCurrency.getName()+"Valyuta "+currency+"ga almashtirildi",true);
    }
    public Result delete(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        Currency currency = optionalCurrency.get();
        currencyRepository.deleteById(id);
        return new Result(currency.getName()+" valyuta o'chirildi",true);
    }

}
