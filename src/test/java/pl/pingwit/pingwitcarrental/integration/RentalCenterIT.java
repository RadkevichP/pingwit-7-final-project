package pl.pingwit.pingwitcarrental.integration;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.pingwit.pingwitcarrental.PingwitcarrentalApplication;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
@SpringBootTest(classes = PingwitcarrentalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RentalCenterIT {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:12");
    @LocalServerPort
    private Integer port;

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getPassword);
        registry.add("spring.datasource.password", postgres::getUsername);
        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);
    }

    @Test
    void verifyProductLifecycle() {
        CreateRentalCenterInputDto inputDto = new CreateRentalCenterInputDto();
        inputDto.setName("Test Name");
        inputDto.setAddress("Test Address");

        // prepare request
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateRentalCenterInputDto> request = new HttpEntity<>(inputDto, headers);

        String rentalCenterUrl = "http://localhost:" + port + "/rental-center";

        // rental center creation
        ResponseEntity<Integer> createdResponse = restTemplate.postForEntity(rentalCenterUrl, request, Integer.class);

        assertThat(createdResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Integer createdProductId = createdResponse.getBody();

        // retrieve created rental center
        ResponseEntity<RentalCenterDto> response = restTemplate.exchange(rentalCenterUrl + "/" + createdProductId, HttpMethod.GET, request, RentalCenterDto.class);
        RentalCenterDto rentalCenterDto = response.getBody();

        assertThat(rentalCenterDto.getAddress()).isEqualTo("Test Address");
        assertThat(rentalCenterDto.getName()).isEqualTo("Test Name");

        // retrieve a list of rental centers
        ResponseEntity<List<RentalCenterShortDto>> exchange = restTemplate.exchange(rentalCenterUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCenterShortDto>>() {});

        assertThat(exchange.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(exchange.getBody().size()).isEqualTo(1);
    }

}
