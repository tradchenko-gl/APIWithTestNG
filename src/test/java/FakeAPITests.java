
import config.FakeAPIConfig;
import config.FakeAPIEndPoints;
import objects.FakeAPIProduct;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FakeAPITests extends FakeAPIConfig {

    String productBodyJSON = "{\n" +
            "  \"title\": \"New one\",\n" +
            "  \"price\": 109.95,\n" +
            "  \"description\": \"Added on 23-02-2023\",\n" +
            "  \"category\": \"test\",\n" +
            "  \"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\"\n" +
            "}";

    @Test
    public void getAllProducts() {
        given()
                .when()
                .get(FakeAPIEndPoints.ALL_PRODUCTS)
                .then();
    }

    @Test
    public void addNewProductByJSON() {

        given()
                .body(productBodyJSON)
                .when()
                .post(FakeAPIEndPoints.ALL_PRODUCTS)
                .then();
    }

    @Test
    public void updateProduct() {
        given()
                .body(productBodyJSON)
                .when()
                .put("products/9")
                .then();
    }

    @Test
    public void deleteProduct() {
        given()
                .pathParam("product_id", 9)
                .when()
                .delete(FakeAPIEndPoints.SINGLE_PRODUCT)
                .then();

    }

    @Test
    public void getProductsInCategory() {
        given()
                .pathParam("category", "jewelery")
                .when()
                .get(FakeAPIEndPoints.PRODUCTS_IN_CATEGORY)
                .then();
    }

    @Test(dataProvider = "idCategoryName", dataProviderClass = TestData.class)
    public void checkProductCategory(String id, String category, String title) {
        given()
                .pathParam("product_id", id)
                .when()
                .get(FakeAPIEndPoints.SINGLE_PRODUCT)
                .then()
                .body("category", equalTo(category))
                .body("title", equalTo(title));

    }

    @Test(dataProvider = "idCategoryNameExcel", dataProviderClass = TestData.class)
    public void checkProductCategoryFromExcel(String id, String category, String title) {
        given()
                .pathParam("product_id", id)
                .when()
                .get(FakeAPIEndPoints.SINGLE_PRODUCT)
                .then()
                .body("category", equalTo(category))
                .body("title", equalTo(title));

    }

    @Test(dataProvider = "newProduceExcel", dataProviderClass = TestData.class)
    public void testProductSerializationByJSON(String title, String price, String description, String image, String category) {
        FakeAPIProduct fakeAPIProduct = new FakeAPIProduct(title, price, description, image, category);

        given()
                .body(fakeAPIProduct)
        .when()
                .post(FakeAPIEndPoints.ALL_PRODUCTS)
                .then();
    }

}
