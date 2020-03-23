package com.emreuzun.model.category;

import com.emreuzun.model.product.SubProduct;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ORDER_NO", nullable = false)
    private Integer order;

    @Column(name = "SEO_PATH")
    private String seoPath;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_CATEGORY",
            joinColumns = {@JoinColumn(name = "CATEGORY_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "SUB_PRODUCT_ID", nullable = false)}
    )
    private Set<SubProduct> subProductSet;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getSeoPath() {
        return seoPath;
    }

    public void setSeoPath(String seoPath) {
        this.seoPath = seoPath;
    }

    public Set<SubProduct> getSubProductSet() {
        return subProductSet;
    }

    public void setSubProductSet(Set<SubProduct> subProductSet) {
        this.subProductSet = subProductSet;
    }
}
