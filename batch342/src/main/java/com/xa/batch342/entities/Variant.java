package com.xa.batch342.entities;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;

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
@Table(name = "variants")
@SQLDelete(sql = "UPDATE variants SET is_deleted = true, deleted_at = NOW() WHERE id = ?")
public class Variant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // FIXME: DTO biar ga berat
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "slug", length = 50, nullable = false, unique = true)
    private String slug;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Lob
    @Column(name = "description", columnDefinition="TEXT", nullable = true)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private BigDecimal stock;

    public Variant() {
    }

    public Variant(Long productId, String name, String description, BigDecimal price, BigDecimal stock, String createdBy) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.slug = SlugUtils.toSlug(name);
        this.setCreatedBy(createdBy);
    }

    // public Product(String name, String description, Long price, Long categoryId)
    // {
    // this.name = name;
    // this.slug = SlugUtils.toSlug(name);
    // this.description = description;
    // this.price = price;
    // this.categoryId = categoryId;
    // }
}
