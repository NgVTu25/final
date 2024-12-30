package com.example.demo.repository;

import com.example.demo.model.ProductFormula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductFormulaRepository extends MongoRepository<ProductFormula, String> {
}