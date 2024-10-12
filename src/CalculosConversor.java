import java.util.Scanner;

public class CalculosConversor {


    public static void calcularConversor(String monedaBase, String monedaObjetivo, ConsultaConversor consulta, Scanner lectura) {
        double cantidad;
        double resultado;

        ConversorM conversor = consulta.buscaConversor(monedaBase, monedaObjetivo);
        System.out.println("------------------------------------------------------------------");
        System.out.println("   ________ PROCESO DE CONVERSION DE ["+ conversor.base_code()+
                "]  A  ["+ conversor.target_code()+"] ________");
        System.out.println("Tasa de conversion del dia: 1" + monedaBase + " = " +
                conversor.conversion_rate()  + monedaObjetivo+"\n");
        System.out.println("Ingrese la cantidad de " + monedaBase);
        cantidad = Double.parseDouble(lectura.nextLine());
        System.out.println(".................................................................");
        resultado = cantidad * conversor.conversion_rate();
        System.out.println(String.format("Cantidad Ingresada: %,.2f %s ", cantidad, monedaBase));
        System.out.println(String.format("Cantidad Convertida: %,.2f %s ", resultado, monedaObjetivo));
        System.out.println("..................................................");
        System.out.println(String.format("%,.2f %s = %,.2f %s", cantidad, monedaBase, resultado, conversor.target_code()));
        System.out.println("Tipo de cambio del mercado a :" +conversor.time_last_update_utc());
        System.out.println("----------------------------------------------------------------\n");
    }

    public  static void otroCalculoConversor(ConsultaConversor consulta, Scanner lectura) {
        System.out.println("Ingresese el codigo de la Moneda Base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el codigo de la Moneda Objetivo: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        calcularConversor(monedaBase,monedaObjetivo,consulta,lectura);
    }

    }






