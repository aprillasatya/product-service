package com.trunk.productservice.controller;

import com.trunk.productservice.model.SearchProductModel;
import com.trunk.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.stream.Stream;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("message")
    public String test() {
        return "test product";
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchProducts(HttpServletRequest request, HttpServletResponse response,
                                         @RequestParam(value="product-name") String searchProductName,
                                         @RequestParam(value = "page") int page){
        try{
            Slice<SearchProductModel> products = productService.getProductByName(searchProductName, page);
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}