package dev.kartheek.EcomProductService.client;

import dev.kartheek.EcomProductService.dto.FakeStoreCartResponseDTO;
import dev.kartheek.EcomProductService.dto.FakeStoreProductRatingDTO;
import dev.kartheek.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String getFakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;
    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductsURL= fakeStoreAPIBaseUrl.concat(getFakeStoreAPIProductPath);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=
                restTemplate.getForEntity(fakeStoreGetAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }
    public FakeStoreProductResponseDTO getProductById(int id){
        String fakeStoreGetProductByIdUrl=fakeStoreAPIBaseUrl.concat(getFakeStoreAPIProductPath).concat("/"+id);
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> product=
                restTemplate.getForEntity(fakeStoreGetProductByIdUrl, FakeStoreProductResponseDTO.class);
        return product.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId){
        if(userId <1) return null;
        String fakeStoreGetCartForUser= fakeStoreAPIBaseUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
}
