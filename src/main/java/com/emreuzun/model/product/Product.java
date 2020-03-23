package com.emreuzun.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
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

    public Set<SubProduct> getSubProductSet() {
        return subProductSet;
    }

    public void setSubProductSet(Set<SubProduct> subProductSet) {
        this.subProductSet = subProductSet;
    }
}
