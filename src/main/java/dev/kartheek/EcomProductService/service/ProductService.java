package dev.kartheek.EcomProductService.service;

import dev.kartheek.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.kartheek.EcomProductService.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
