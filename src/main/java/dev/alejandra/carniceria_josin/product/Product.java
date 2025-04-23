package dev.alejandra.carniceria_josin.product;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    @Column(nullable = false)
    private double priceKg;

    @Column(nullable = false)
    private int stockKg;

    public Product(String name, ProductCategory category, double priceKg, int stockKg) {
        this.name = name;
        this.category = category;
        this.priceKg = priceKg;
        this.stockKg = stockKg;
    }

  
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPriceKg() {
        return priceKg;
    }

    public void setPriceKg(double priceKg) {
        this.priceKg = priceKg;
    }

    public int getStockKg() {
        return stockKg;
    }

    public void setStockKg(int stockKg) {
        this.stockKg = stockKg;
    }
}

