package dev.kartheek.EcomProductService.client;

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
    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductsURL= fakeStoreAPIBaseUrl.concat(getFakeStoreAPIProductPath);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=
                restTemplate.getForEntity(fakeStoreGetAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }
}
