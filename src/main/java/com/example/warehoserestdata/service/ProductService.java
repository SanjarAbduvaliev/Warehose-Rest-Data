package com.example.warehoserestdata.service;

import com.example.warehoserestdata.entity.Attachment;
import com.example.warehoserestdata.entity.Category;
import com.example.warehoserestdata.entity.Measurement;
import com.example.warehoserestdata.entity.Product;
import com.example.warehoserestdata.payload.Productdto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.AttachmentRepository;
import com.example.warehoserestdata.repository.CategoryRepository;
import com.example.warehoserestdata.repository.MeasurementRepository;
import com.example.warehoserestdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Result addProduct(Productdto productdto){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productdto.getMeasurementd());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productdto.getAttachmentId());
        Optional<Category> optionalCategory = categoryRepository.findById(productdto.getCategoryId());

        if (productRepository.existsByNameAndCategory_Id(productdto.getName(), productdto.getCategoryId()))
            return new Result("Bunday mahsulot avvaldan mavjud",false);

        if (!optionalMeasurement.isPresent())
            return new Result("Bunday o'chov birligi mavjud emas",false);

        if (!optionalAttachment.isPresent())
            return new Result("Bunday rasm mavjud emas",false);

        if (!optionalCategory.isPresent())
            return new Result("Bunday kategoriya mavjud emas",false);

        Product product=new Product();
        product.setName(productdto.getName());
        product.setMeasurement(optionalMeasurement.get());
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        productRepository.save(product);
        return new Result("Mahsulot saqlandi",true);
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getId(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return null;
        }
        return optionalProduct.get();
    }
    public Result edit(Productdto productdto, Integer id){
        Category category = productRepository.findByCategory_Id(productdto.getCategoryId());
        Attachment attachment = productRepository.findByAttachmentId(productdto.getAttachmentId());
        Measurement measurement = productRepository.findByMeasurementId(productdto.getMeasurementd());
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new Result("Bunday maxsulot mavjud emas",false);
        }
        Product product = optionalProduct.get();
        product.setCategory(category);
        product.setAttachment(attachment);
        product.setMeasurement(measurement);
        product.setName(productdto.getName());
        product.setCode("1");
        productRepository.save(product);
        return new Result("Mahsulot muvofaqqiyatli saqlandi",true);
    }
    public Result delete(Integer id){
        productRepository.deleteById(id);
        return new Result("Mahsulot o'chilildi",true);
    }
}
