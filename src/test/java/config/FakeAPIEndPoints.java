package config;

public interface FakeAPIEndPoints {
    String ALL_PRODUCTS = "/products";
    String SINGLE_PRODUCT = "/products/{product_id}";
    String PRODUCTS_IN_CATEGORY = "products/category/{category}";
}
