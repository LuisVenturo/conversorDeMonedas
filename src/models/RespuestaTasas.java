package models;

import java.util.Map;

public record RespuestaTasas(
        String base_code,
        Map<String, Double> conversion_rates,
        String result
) {
}
