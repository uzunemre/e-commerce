package com.emreuzun.service.category;

import com.emreuzun.enumaration.ColorEnum;
import com.emreuzun.enumaration.SizeEnum;
import com.emreuzun.model.category.Category;
import com.emreuzun.model.product.Product;
import com.emreuzun.model.product.SubProduct;
import com.emreuzun.repository.category.CategoryRepository;
import com.emreuzun.util.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PropertyService propertyService;

    @PostConstruct
    public void initialize() {
        initDataForDevelopment();
    }

    @Transactional
    void initDataForDevelopment() {
        if (propertyService.isDevelopmentMode()) {
            Category category1 = new Category();
            category1.setName("Clothing & Accessories");
            category1.setOrder(1);
            category1.setSeoPath("clothing-accessories");

            Product product1 = new Product();
            product1.setName("Baby Boy Dino Printed");

            SubProduct subProduct1 = new SubProduct();
            subProduct1.setProduct(product1);
            subProduct1.setName("Baby Boy Dino Printed Water Repellent Astronaut");
            subProduct1.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/51/sm19KMDMEKZM009-0051_1.jpg");
            subProduct1.setPrice(new BigDecimal(10.20));
            subProduct1.setSeoPath("baby-boy-dino-printed-water-repellent-astronaut");

            product1.setSubProductSet(new HashSet<>(Collections.singletonList(subProduct1)));

            Product product2 = new Product();
            product2.setName("Baby Athlete Sleeveless Bodysuit");

            SubProduct subProduct2 = new SubProduct();
            subProduct2.setProduct(product2);
            subProduct2.setName("Baby Athlete Sleeveless Bodysuit-White,Small");
            subProduct2.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/EY/smGENHELUBDY5000BEY_1.jpg");
            subProduct2.setPrice(new BigDecimal(15.70));
            subProduct2.setSeoPath("baby-athlete-sleeveless-bodysuit-white-small");
            subProduct2.setColorEnum(ColorEnum.WHITE);
            subProduct2.setSizeEnum(SizeEnum.SMALL);

            product2.setSubProductSet(new HashSet<>(Collections.singletonList(subProduct2)));

            Product product3 = new Product();
            product3.setName("Summer Basic Baby Letters Jumpsuit");

            SubProduct subProduct3 = new SubProduct();
            subProduct3.setProduct(product3);
            subProduct3.setName("Summer Basic Baby Letters Jumpsuit Green");
            subProduct3.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/17/sm20YHBLEBTZ111-0017_1.jpg");
            subProduct3.setPrice(new BigDecimal(25));
            subProduct3.setSeoPath("summer-basic-baby-letters-jumpsuit-green");
            subProduct3.setColorEnum(ColorEnum.GREEN);
            subProduct3.setSizeEnum(SizeEnum.MEDIUM);

            product3.setSubProductSet(new HashSet<>(Collections.singletonList(subProduct3)));


            Product product4 = new Product();
            product4.setName("Funny Rattle Baby Socks");

            SubProduct subProduct4 = new SubProduct();
            subProduct4.setProduct(product4);
            subProduct4.setName("Funny Rattle Baby Socks");
            subProduct4.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/21/smGENFNPUOYN001-0021_1.jpg");
            subProduct4.setPrice(new BigDecimal(32.70));
            subProduct4.setSeoPath("funny-rattle-baby-socks");

            product4.setSubProductSet(new HashSet<>(Collections.singletonList(subProduct4)));

            Product product5 = new Product();
            product5.setName("Baby Boy Colored Socks");

            SubProduct subProduct5 = new SubProduct();
            subProduct5.setProduct(product5);
            subProduct5.setName("Baby Boy Colored Socks");
            subProduct5.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/32/smGENHBLECRP003-0032_1.jpg");
            subProduct5.setPrice(new BigDecimal(35.30));
            subProduct5.setSeoPath("baby-boy-colored-socks");

            product5.setSubProductSet(new HashSet<>(Collections.singletonList(subProduct5)));

            Product product6 = new Product();
            product6.setName("Baby Socks 3 Pack");

            SubProduct subProduct6 = new SubProduct();
            subProduct6.setProduct(product6);
            subProduct6.setName("Baby Socks 3 Pack - Blue");
            subProduct6.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/AV/smGENHELECRP6208MAV_1.jpg");
            subProduct6.setPrice(new BigDecimal(40.20));
            subProduct6.setSeoPath("baby-socks-3-pack-blue");
            subProduct6.setSizeEnum(SizeEnum.SMALL);
            subProduct6.setColorEnum(ColorEnum.MEDIUM);

            Set<SubProduct> subProductSet = new HashSet<>();
            subProductSet.add(subProduct1);
            subProductSet.add(subProduct2);
            subProductSet.add(subProduct3);
            subProductSet.add(subProduct4);
            subProductSet.add(subProduct5);
            subProductSet.add(subProduct6);


            category1.setSubProductSet(subProductSet);

            save(category1);


            Category category2 = new Category();
            category2.setName("Bath & Skin Care");
            category2.setOrder(2);
            category2.setSeoPath("bath-skin-care");

            Product product7 = new Product();
            product7.setName("Baby Replacement Aspirator Filter 10 pcs");

            SubProduct subProduct7 = new SubProduct();
            subProduct7.setProduct(product7);
            subProduct7.setName("Baby Replacement Aspirator Filter 10 pcs");
            subProduct7.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/33/smMLK-33_1.jpg");
            subProduct7.setPrice(new BigDecimal(50.30));
            subProduct7.setSeoPath("baby-replacement-aspirator-filter-10-pcs");

            Product product8 = new Product();
            product8.setName("Baby Cologne");

            SubProduct subProduct8 = new SubProduct();
            subProduct8.setProduct(product8);
            subProduct8.setName("Baby Cologne 150 ml");
            subProduct8.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/66/smDAL-4366_1.jpg");
            subProduct8.setPrice(new BigDecimal(60.20));
            subProduct8.setSeoPath("baby-cologne-150-ml");

            Product product9 = new Product();
            product9.setName("Baby Nasal Aspirator Replacement Filter");

            SubProduct subProduct9 = new SubProduct();
            subProduct9.setProduct(product9);
            subProduct9.setName("Baby Nasal Aspirator Replacement Filter 12 pcs");
            subProduct9.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/98/smBYP-199098_1.jpg");
            subProduct9.setPrice(new BigDecimal(70.30));
            subProduct9.setSeoPath("baby-nasal-aspirator-replacement-filter-12-pcs");

            subProductSet = new HashSet<>();
            subProductSet.add(subProduct7);
            subProductSet.add(subProduct8);
            subProductSet.add(subProduct9);

            category2.setSubProductSet(subProductSet);

            save(category2);

            Category category3 = new Category();
            category3.setName("Toys & Books");
            category3.setOrder(3);
            category3.setSeoPath("toys-books");

            Product product10 = new Product();
            product10.setName("My Walking Friend");

            SubProduct subProduct10 = new SubProduct();
            subProduct10.setProduct(product10);
            subProduct10.setName("My Walking Friend");
            subProduct10.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/NC/smKNZ-30600-NC_1.jpg");
            subProduct10.setPrice(new BigDecimal(75.80));
            subProduct10.setSeoPath("my-walking-friend");

            Product product11 = new Product();
            product11.setName("Caterpillar Flexi Ball");

            SubProduct subProduct11 = new SubProduct();
            subProduct11.setProduct(product11);
            subProduct11.setName("Caterpillar Flexi Ball");
            subProduct11.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/48/smKNZ-30148_1.jpg");
            subProduct11.setPrice(new BigDecimal(80.50));
            subProduct11.setSeoPath("caterpillar-flexi-ball");

            Product product12 = new Product();
            product12.setName("Piano Mushroom Playing Game Rug Carpet");

            SubProduct subProduct12 = new SubProduct();
            subProduct12.setProduct(product12);
            subProduct12.setName("Piano Mushroom Playing Game Rug Carpet");
            subProduct12.setImage("https://cdn.e-bebek.com/www.ebebek/i/p/200/39/smBRL-HE0639_1.jpg");
            subProduct12.setPrice(new BigDecimal(87.30));
            subProduct12.setSeoPath("piano-mushroom-playing-game-rug-carpet");

            subProductSet = new HashSet<>();
            subProductSet.add(subProduct10);
            subProductSet.add(subProduct11);
            subProductSet.add(subProduct12);

            category3.setSubProductSet(subProductSet);

            save(category3);
        }
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllByOrder() {
        return categoryRepository.findByOrderByOrderAsc();
    }

    public Category getWithProducts(Long categoryId) {
        return categoryRepository.findWithProducts(categoryId);
    }

    public Category getBySeoPath(String seoPath) {
        Category category;
        if (StringUtils.isEmpty(seoPath)) {
            category = categoryRepository.findFirstByOrderByOrderAsc();
        } else {
            category = categoryRepository.findBySeoPath(seoPath);
        }
        return category;
    }

}
