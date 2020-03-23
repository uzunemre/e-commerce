package com.emreuzun.model.product;

import com.emreuzun.enumaration.ColorEnum;
import com.emreuzun.enumaration.SizeEnum;
import com.emreuzun.model.category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "SUB_PRODUCT")
public class SubProduct {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @NotNull
    private Product product;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IMAGE", nullable = false)
    private String image;

    @Column(name = "PRICE", precision = 10, scale = 2, nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "COLOR")
    private ColorEnum colorEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "SIZE")
    private SizeEnum sizeEnum;

    @Column(name = "SEO_PATH", nullable = false)
    private String seoPath;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_CATEGORY",
            joinColumns = {@JoinColumn(name = "SUB_PRODUCT_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", nullable = false)}
    )
    private Set<Category> categorySet;

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    public SizeEnum getSizeEnum() {
        return sizeEnum;
    }

    public void setSizeEnum(SizeEnum sizeEnum) {
        this.sizeEnum = sizeEnum;
    }

    public String getSeoPath() {
        return seoPath;
    }

    public void setSeoPath(String seoPath) {
        this.seoPath = seoPath;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }
}
