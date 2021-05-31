package com.trunk.productservice.repository;

import com.trunk.productservice.model.ProductModel;
import com.trunk.productservice.model.SearchProductModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    @Query(value = "select p.id, p.product_name as productName, p.product_price as productPrice, p.product_description as productDescription " +
            "from products p " +
            "where product_name like %?1% " +
            "order by created_at",
    nativeQuery = true)
    Slice<SearchProductModel> getSearchProduct(String productName, Pageable pageable);
}
