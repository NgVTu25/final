package com.example.demo.service;

import com.example.demo.model.ProductFormula;
import com.example.demo.repository.ProductFormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductFormulaService {

    @Autowired
    private ProductFormulaRepository productFormulaRepository;

    public List<ProductFormula> getAllProductFormulas() {
        return productFormulaRepository.findAll();
    }

    public Optional<ProductFormula> getProductFormulaById(String id) {
        return productFormulaRepository.findById(id);
    }

    public ProductFormula saveProductFormula(ProductFormula productFormula) {
        return productFormulaRepository.save(productFormula);
    }

    public boolean deleteProductFormula(String id) {
        if (productFormulaRepository.existsById(id)) {
            productFormulaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}