package principal;

import models.ConversorMoneda;
import models.ServicioAPi;
import models.VisorTasasDeCambios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServicioAPi servicioAPi = new ServicioAPi();
        ConversorMoneda conversorMoneda = new ConversorMoneda(servicioAPi);
        VisorTasasDeCambios visorTasasDeCambios = new VisorTasasDeCambios(servicioAPi);

        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver tasas de cambio");
            System.out.println("3. Exportar tasas a archivo .txt");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Moneda base (ej. USD): ");
                    String moneda = sc.next();
                    System.out.print("Moneda destino (ej. PEN): ");
                    String destino = sc.next();
                    System.out.print("Cantidad de moneda a convertir: ");
                    double cantidad = sc.nextDouble();
                    conversorMoneda.convertir(moneda, destino, cantidad);
                }
                case 2 -> {
                    System.out.print("Moneda base para ver tasas (ej. USD): ");
                    String base = sc.next();
                    visorTasasDeCambios.mostrarTasas(base);
                }
                case 3 -> {
                    System.out.print("Moneda base (ej. USD): ");
                    String base = sc.next();
                    System.out.print("Nombre del archivo (ej. tasas.txt): ");
                    String archivo = sc.next();
                    visorTasasDeCambios.exportarTasasATexto(base, archivo);
                }
                case 0 -> System.out.println("Gracias por usar mi aplicacion");
                default -> System.out.println("Opcion no valida");
            }
        }while (opcion != 0);

    }
}
