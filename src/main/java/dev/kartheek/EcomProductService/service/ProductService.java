package dev.kartheek.EcomProductService.service;

import dev.kartheek.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.kartheek.EcomProductService.entity.Product;
import dev.kartheek.EcomProductService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
