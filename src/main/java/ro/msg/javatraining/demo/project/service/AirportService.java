package ro.msg.javatraining.demo.project.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirportService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public AirportService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }


    public String getAirports() {
        String url = "https://airportgap.com/api/airports";
        String jsonResponse = restTemplate.getForObject(url, String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error formatting JSON";
        }
    }
    public String getAirportById(String id) {
        String url = "https://airportgap.com/api/airports/"+id;
        String jsonResponse = restTemplate.getForObject(url, String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error formatting JSON";
        }
    }
}
