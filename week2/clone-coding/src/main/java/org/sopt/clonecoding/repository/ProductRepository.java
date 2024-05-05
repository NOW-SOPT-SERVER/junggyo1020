package org.sopt.clonecoding.repository;

import org.sopt.clonecoding.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{}
