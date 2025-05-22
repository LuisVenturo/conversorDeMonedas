package models;

import com.google.gson.Gson;

public class ConversorMoneda {
    private ServicioAPi servicioAPi;
    private final Gson gson = new Gson();

    public ConversorMoneda(ServicioAPi servicioAPi) {
        this.servicioAPi = servicioAPi;
    }

    public void convertir(String monedaBase, String monedaDestino, double cantidad) {
        try {
            String json = servicioAPi.obtenerJsonConversion(monedaBase, monedaDestino, cantidad);
            RespuestaConversion respuesta = gson.fromJson(json, RespuestaConversion.class);

            if (!"success".equals(respuesta.result())) {
                System.out.println("No se pudo realizar la conversión.");
                return;
            }
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaBase, respuesta.conversion_result(), monedaDestino);

        } catch (Exception e) {
            System.out.println("Error al convertir moneda: " + e.getMessage());
        }

    }


}
