package com.example.warehoserestdata.service;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.InputProduct;
import com.example.warehoserestdata.entity.Product;
import com.example.warehoserestdata.payload.InputProductDto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.InputProductRepository;
import com.example.warehoserestdata.repository.InputRepository;
import com.example.warehoserestdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    public Result add(InputProductDto inputProductDto){
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());

        InputProduct inputProduct =new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setAmount(12.2);
        inputProduct.setExpireDate(new Date());

        inputProductRepository.save(inputProduct);
        return new Result("Saqlandi",true);
    }
    public List<InputProduct> getAll(){
        return inputProductRepository.findAll();
    }
    public InputProduct getId(Integer id){
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        return byId.get();
    }
    public Result edit(InputProductDto inputProductDto, Integer id){
        Product product = inputProductRepository.findByProduct_Id(inputProductDto.getProductId());
        Input input = inputProductRepository.findByInputId(inputProductDto.getInputId());

        Optional<InputProduct> optionalReceiptProduct = inputProductRepository.findById(id);
        InputProduct inputProduct = optionalReceiptProduct.get();
        inputProduct.setProduct(product);
        inputProduct.setInput(input);
        inputProduct.setAmount(123.3);
        inputProduct.setExpireDate(new Date());
        return new Result("Kirim o'zgartirildi",true);
    }
    public Result delete(Integer id){
        inputProductRepository.deleteById(id);
        return  new Result("Kirim o'chirildi",true);
    }
}
