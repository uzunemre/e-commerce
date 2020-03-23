package com.emreuzun.repository.category;

import com.emreuzun.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c left join fetch c.subProductSet where c.id = ?1")
    Category findWithProducts(long categoryId);

    Category findFirstByOrderByOrderAsc();

    Category findBySeoPath(String seoPath);

    List<Category> findByOrderByOrderAsc();

}
