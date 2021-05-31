package com.trunk.productservice.service;

import com.trunk.productservice.model.ProductModel;
import com.trunk.productservice.model.SearchProductModel;
import com.trunk.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Slice<SearchProductModel> getProductByName(String productName, int page){
        Pageable pagination = PageRequest.of(page, 10);
        return productRepository.getSearchProduct(productName, pagination);
    }

    public List<ProductModel> getAllProduct(){
        return productRepository.findAll();
    }

}
