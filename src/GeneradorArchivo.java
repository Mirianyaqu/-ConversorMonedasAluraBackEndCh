import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class GeneradorArchivo {
    public void guardarJson(ConversorM conversor) throws IOException {// add excepcion to method signature
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        DecimalFormat df = new DecimalFormat("#.##");
        String conversionRateFormatted = df.format(conversor.conversion_rate());
        String historialConversiones = conversor.base_code() + ".json";
        try (FileWriter escritura = new FileWriter(historialConversiones)) {
            escritura.write(gson.toJson(conversor));
            System.out.println("Archivo guardado exitosamente: " + historialConversiones);
        }
        }
    }






