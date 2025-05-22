package models;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class VisorTasasDeCambios {
    private final ServicioAPi servicioAPi;
    private final Gson gson = new Gson();

    public VisorTasasDeCambios(ServicioAPi servicioAPi) {
        this.servicioAPi = servicioAPi;
    }

    public void mostrarTasas(String monedaBase) {

        try {
            String json = servicioAPi.obtenerJsonUltimasTasas(monedaBase);
            RespuestaTasas respuesta = gson.fromJson(json, RespuestaTasas.class);
            if (!"success".equals(respuesta.result())) {
                System.out.println("Error al obtener tasas.");
                return;
            }

            System.out.println("Tasas de cambio para " + respuesta.base_code() + ":");
            respuesta.conversion_rates().forEach((moneda, valor) ->
                    System.out.printf("1 %s = %.4f %s%n", respuesta.base_code(), valor, moneda)
            );


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public void exportarTasasATexto(String monedaBase, String nombreArchivo){


        try {
             String json = servicioAPi.obtenerJsonUltimasTasas(monedaBase);
            RespuestaTasas respuesta = gson.fromJson(json, RespuestaTasas.class);

            if (!"success".equals(respuesta.result())) {
                System.out.println("Error al obtener tasas.");
                return;
            }

            FileWriter escribir =  new FileWriter(nombreArchivo);
            escribir.write("Tasas de cambio para " + respuesta.base_code() + ":\n\n");

            respuesta.conversion_rates().forEach((moneda, valor) -> {
                try {
                    escribir.write(String.format("1 %s = %.4f %s%n", respuesta.base_code(), valor, moneda));
                } catch (IOException e) {
                    System.out.println("Error al escribir línea en archivo.");
                }
            });

            escribir.close();
            System.out.println("Archivo guardado como " + nombreArchivo + ".");

        } catch (Exception e) {
            System.out.println("Error al exportar tasas: " + e.getMessage());
        }

    }

}
