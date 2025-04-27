package dev.alejandra.carniceria_josin.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void testProductCreation() {

        String name = "Lomo de Cerdo";
        ProductCategory category = ProductCategory.CARNE;
        double priceKg = 12.5;
        int stockKg = 25;

        Product product = new Product(name, category, priceKg, stockKg);

        assertNotNull(product);
        assertEquals(name, product.getName());
        assertEquals(category, product.getCategory());
        assertEquals(priceKg, product.getPriceKg());
        assertEquals(stockKg, product.getStockKg());
        assertNull(product.getId()); 
    }

    @Test
    void testSetters() {

        Product product = new Product("Bistec de Ternera", ProductCategory.CARNE, 18.0, 15);

        product.setName("Entrecot de Ternera");
        product.setCategory(ProductCategory.CARNE);
        product.setPriceKg(22.5);
        product.setStockKg(10);

        assertEquals("Entrecot de Ternera", product.getName());
        assertEquals(ProductCategory.CARNE, product.getCategory());
        assertEquals(22.5, product.getPriceKg());
        assertEquals(10, product.getStockKg());
    }

    @Test
    void testChangingCategory() {

        Product product = new Product("Pollo Entero", ProductCategory.AVES, 5.5, 50);

        product.setCategory(ProductCategory.OTROS);

        assertEquals(ProductCategory.OTROS, product.getCategory());
    }

    @Test
    void testStockReduction() {

        Product product = new Product("Chorizo", ProductCategory.EMBUTIDO, 9.0, 30);
        int quantityToSell = 5;

        int initialStock = product.getStockKg();
        product.setStockKg(initialStock - quantityToSell);

        assertEquals(25, product.getStockKg());
    }

    @Test
    void testPriceCalculation() {

        Product product = new Product("Jamón Serrano", ProductCategory.EMBUTIDO, 24.5, 15);
        double quantity = 0.5; 

        double totalPrice = product.getPriceKg() * quantity;

        assertEquals(12.25, totalPrice, 0.001);
    }

    @Test
    void testProductOutOfStock() {

        Product product = new Product("Salchichas", ProductCategory.EMBUTIDO, 7.5, 0);

        assertEquals(0, product.getStockKg());
        assertTrue(product.getStockKg() == 0);
    }

    @Test
    void testAllCategoriesRepresentation() {
        assertNotNull(ProductCategory.CARNE);
        assertNotNull(ProductCategory.EMBUTIDO);
        assertNotNull(ProductCategory.AVES);
        assertNotNull(ProductCategory.OTROS);
    }

}
