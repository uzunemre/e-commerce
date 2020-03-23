package com.emreuzun.repository.product;

import com.emreuzun.model.product.SubProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProductRepository extends JpaRepository<SubProduct, Long> {

}
