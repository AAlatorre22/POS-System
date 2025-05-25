package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final List<Product> productList = new ArrayList<>();

    @GetMapping("/product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/product")
    public String handleForm(@ModelAttribute Product product, Model model) {
        productList.add(product);
        model.addAttribute("product", product);
        return "product-result";
    }

    @GetMapping("/products")
    public String showAll(Model model) {
        model.addAttribute("products", productList);
        return "product-list";
    }
}
