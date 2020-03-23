package com.emreuzun.service.product;

import com.emreuzun.model.product.SubProduct;
import com.emreuzun.repository.product.SubProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubProductServiceImpl implements SubProductService {

    @Autowired
    private SubProductRepository subProductRepository;

    public SubProduct getById(long id) {
        return subProductRepository.findOne(id);
    }

}
