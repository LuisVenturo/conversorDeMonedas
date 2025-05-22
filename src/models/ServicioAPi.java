package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioAPi {
    private static final String API_KEY = "f882974f4d51878484166d82";
    private static final HttpClient client = HttpClient.newHttpClient();


    //Metodo empleado para deserealizar el resultado de conversión de moneda
    public String obtenerJsonConversion(String base, String destino, double cantidad) throws Exception{
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f", API_KEY, base, destino, cantidad);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    //Metodo empleado para deserealizar las tasas de conversión que existe de los diferentes países
    public String obtenerJsonUltimasTasas(String base) throws Exception {
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, base);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
