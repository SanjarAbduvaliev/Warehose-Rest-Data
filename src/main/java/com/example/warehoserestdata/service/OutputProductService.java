package com.example.warehoserestdata.service;

import com.example.warehoserestdata.entity.Product;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.InputProduct;
import com.example.warehoserestdata.payload.OutputProductDto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.OutputProductRepository;
import com.example.warehoserestdata.repository.ProductRepository;
import com.example.warehoserestdata.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService{
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SaleRepository outpuRepository;
    public Result add(OutputProductDto outputProductDto){

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getOutputId());
        Optional<Input> optionalSale = outpuRepository.findById(outputProductDto.getOutputId());
        InputProduct inputProduct =new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalSale.get());
        inputProduct.setAmount(25.0);
        outputProductRepository.save(inputProduct);
        return new Result("Chiqim saqlandi",true);
    }
    public List<InputProduct> getAll(){
        return outputProductRepository.findAll();
    }
    public InputProduct getId(Integer id){
        Optional<InputProduct> saleProductOptional = outputProductRepository.findById(id);
        return saleProductOptional.get();
    }
    public Result edit(OutputProductDto outputProductDto,Integer id){
        Product product = outputProductRepository.findByProduct_Id(outputProductDto.getProductId());
        Input input = outputProductRepository.findByInputId(outputProductDto.getOutputId());
        Optional<InputProduct> optionalSaleProduct = outputProductRepository.findById(id);
        InputProduct inputProduct = optionalSaleProduct.get();
        inputProduct.setProduct(product);
        inputProduct.setInput(input);
        inputProduct.setAmount(23.0);
        outputProductRepository.save(inputProduct);
        return  new Result("Sotilgan mahsulot tahrirlandi",true);
    }
    public Result delete(Integer id){
        outputProductRepository.deleteById(id);
        return new Result("Chiqimlar tarixidan ochirildi",true);
    }
}
