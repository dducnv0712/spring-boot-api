package com.example.demospring.api;

import com.example.demospring.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class HelloController {
    private static List<Product> products = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public List<Product> getAll() {
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
    public Product findById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/products")
    public Product Save(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/products/{id}")
    public Product Update(@RequestBody Product product, @PathVariable int id) {
        int foundIndex = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            products.set(foundIndex, product);
        }
        return product;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/products/{id}")
    public Product Delete(@PathVariable int id) {
        int foundIndex = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            products.remove(foundIndex);
        }
        return null;
    }

}
