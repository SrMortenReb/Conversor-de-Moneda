package com.srmortenreb.conversor.conversordemonedas;

import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        String[] monedasValidas = {"ARS", "BRL", "COP"};

        System.out.println("¡Bienvenido al Conversor de Moneda!");

        while (continuar) {
            System.out.print("Ingrese la cantidad en USD: ");
            double cantidad = sc.nextDouble();

            System.out.print("Moneda destino (ARS, BRL, COP): ");
            String moneda = sc.next();

            if (!Arrays.asList(monedasValidas).contains(moneda.toUpperCase())) {
                System.out.println("Moneda no válida. Intente de nuevo.");
                continue;
            }

            double tasa = ApiService.obtenerTasa(moneda.toUpperCase());
            double resultado = cantidad * tasa;

            System.out.printf("Tasa de cambio actual: 1 USD = %.2f %s%n", tasa, moneda);
            System.out.printf("%.2f USD = %.2f %s%n", cantidad, resultado, moneda);

            System.out.print("¿Desea hacer otra conversión? (s/n): ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
                System.out.println("¡Gracias por usar el Conversor de Moneda!");
            }
        }
    }
}
