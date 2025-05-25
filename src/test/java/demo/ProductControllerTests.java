package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class ProductControllerTests {

    @Test
    public void testHandleFormAddsProduct() {
        ProductController controller = new ProductController();
        Product product = new Product("Test Product", 5.99, 10);
        Model model = new ConcurrentModel();

        String viewName = controller.handleForm(product, model);

        Product modelProduct = (Product) model.getAttribute("product");
        assertNotNull(modelProduct);
        assertEquals("Test Product", modelProduct.getName());
        assertEquals(5.99, modelProduct.getPrice());
        assertEquals(10, modelProduct.getQuantity());
        assertEquals("product-result", viewName);
    }

    @Test
    public void testShowAllReturnsProductListView() {
        ProductController controller = new ProductController();
        Model model = new ConcurrentModel();

        String viewName = controller.showAll(model);

        assertEquals("product-list", viewName);
        assertTrue(model.containsAttribute("products"));
    }
}
