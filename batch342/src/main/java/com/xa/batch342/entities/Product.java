package com.xa.batch342.entities;

import com.xa.batch342.utils.SlugUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // FIXME: DTO biar ga berat
    @JoinColumn(name = "category_id", nullable = false, insertable=false, updatable=false)
    private Category category;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "slug", length = 50, unique = true)
    private String slug;

    @Lob
    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "price")
    private Long price;

    public Product() {
    }

    public Product( Category category, String name, String description, Long price) {
        this.category = category;
        this.name = name;
        this.slug = SlugUtils.toSlug(name);
        this.description = description;
        this.price = price;
    }
}
