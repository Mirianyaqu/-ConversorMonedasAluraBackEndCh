
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final List<ConversorM> historialConversiones = new ArrayList<>();
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversor consulta = new ConsultaConversor();
        GeneradorArchivo generador = new GeneradorArchivo();

        try {
            int opcion = 0;

            while (opcion != 10) {
                String Menu = """
                        ****************************************************************                
                             Bienvenido(a) al Conversor de Monedas!
                        ----------------------------------------------------------------
                                            MENU OPCIONES  
                        ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                        1. Dollar a Lempira hondureño
                        2. Lempira hondureño a Dollar
                        3. Dollar a Peso Argentino
                        4. Peso Argentino a Dollar
                        5. Dollar a Real Brasileño
                        6. Real Brasileño a Dollar
                        7. Dollar a Peso Colombiano
                        8. Peso Colombiano a Dollar
                        9. Convertir otra moneda
                        10. Salir 
                        ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                        Elija una opcion valida
                        ****************************************************************
                        """;
                System.out.println(Menu);
                opcion = lectura.nextInt();
                lectura.nextLine();
                ConversorM conversor = null;//I

                switch (opcion) {
                    case 1:
                        CalculosConversor.calcularConversor("USD", "HNL", consulta, lectura);
                        break;
                    case 2:
                        CalculosConversor.calcularConversor("HNL", "USD", consulta, lectura);
                        break;
                    case 3:
                        CalculosConversor.calcularConversor("USD", "ARS", consulta, lectura);
                        break;
                    case 4:
                        CalculosConversor.calcularConversor("ARS", "USD", consulta, lectura);
                        break;
                    case 5:
                        CalculosConversor.calcularConversor("USD", "BRL", consulta, lectura);
                        break;
                    case 6:
                        CalculosConversor.calcularConversor("BRL", "USD", consulta, lectura);
                        break;
                    case 7:
                        CalculosConversor.calcularConversor("USD", "COP", consulta, lectura);
                        break;
                    case 8:
                        CalculosConversor.calcularConversor("COP", "USD", consulta, lectura);
                        break;
                    case 9:
                        CalculosConversor.otroCalculoConversor(consulta, lectura);
                        break;
                    case 10:
                        System.out.println("Saliendo.......");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA \n");
                        break;
                }
                if (conversor != null) {
                    historialConversiones.add(conversor);
                    try {
                        generador.guardarJson(conversor);
                        System.out.println("Conversión guardada exitosamente.");
                    }
                    catch (IOException e) {
                        System.out.println("Error al guardar la conversión: " + e.getMessage());
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa solo el número correspondiente al menú. Inténtalo de nuevo.");
            lectura.nextLine();
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            lectura.close();
        }
    }
}