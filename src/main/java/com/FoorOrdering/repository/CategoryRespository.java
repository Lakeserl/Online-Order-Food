package com.FoorOrdering.repository;

import com.FoorOrdering.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRespository extends JpaRepository<Category, Long> {

    public List<Category> findByRestaurantId(Long Id);
}
