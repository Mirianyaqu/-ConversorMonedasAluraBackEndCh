import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversor {
   public  ConversorM buscaConversor(String monedaBase, String monedaObjetivo) {
       URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b3eaa693bef77d3d8e5e5498/pair/" +
               monedaBase + "/" + monedaObjetivo);

       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder()
               .uri(direccion)
               .build();

       try {
           HttpResponse<String> response = client
                   .send(request, HttpResponse.BodyHandlers.ofString());
           return new Gson().fromJson(response.body(), ConversorM.class);
       } catch (Exception e) {
           throw new RuntimeException("Moneda no Encontrada: " + e.getMessage());
       }
   }
}

