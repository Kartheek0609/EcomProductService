package dev.kartheek.EcomProductService.service;

import dev.kartheek.EcomProductService.client.FakeStoreClient;
import dev.kartheek.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.kartheek.EcomProductService.entity.Product;
import dev.kartheek.EcomProductService.exceptions.InvalidInputException;
import dev.kartheek.EcomProductService.exceptions.NoProductPresentException;
import dev.kartheek.EcomProductService.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts==null){
            throw new NoProductPresentException("No Products are found");
        }
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        if(productId <1){
            throw new InvalidInputException("Invalid input");
        }
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO= fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO==null){
            throw  new ProductNotFoundException("Product not Found with id "+ productId);
        }
        return fakeStoreProductResponseDTO;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
