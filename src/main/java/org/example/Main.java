package org.example;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        String apiUrl = "http://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";
        String apiKey = "4a2ddb7e39389538a721617c99b189d1a5360884";


        String inn = "7707329152";


        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Token " + apiKey);


        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("query", inn);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);


        ResponseEntity<DadataResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                DadataResponse.class
        );


        if (response.getStatusCode() == HttpStatus.OK) {
            DadataResponse dadataResponse = response.getBody();
            if (dadataResponse != null && !dadataResponse.getSuggestions().isEmpty()) {
                Organization org = dadataResponse.getSuggestions().get(0);
                Organization.Data orgData = org.getData();
                String jsonOutput = String.format(
                        "{\n  \"inn\": \"%s\",\n  \"kpp\": \"%s\",\n  \"ogrn\": \"%s\",\n  \"name\": \"%s\"\n}",
                        orgData.getInn(),
                        orgData.getKpp(),
                        orgData.getOgrn(),
                        orgData.getName().getFullName()
                );
                System.out.println(jsonOutput);
            } else {
                System.out.println("Организация не найдена.");
            }
        } else {
            System.out.println("Ошибка: " + response.getStatusCode());
        }
    }
}
