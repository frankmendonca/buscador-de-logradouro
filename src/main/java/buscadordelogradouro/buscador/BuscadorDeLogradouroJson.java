package buscadordelogradouro.buscador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import buscadordelogradouro.logradouro.Logradouro;

import com.google.gson.Gson;

public abstract class BuscadorDeLogradouroJson extends BuscadorDeLogradouro {

   @Override
   protected Logradouro getLogradouro(String cep) {
      final String json = getJson(cep);
      final Gson gson = new Gson();

      return gson.fromJson(json.toString(), getClasse());
   }

   protected abstract Class<? extends Logradouro> getClasse();

   private String getJson(String cep) {
      final StringBuilder json = new StringBuilder();

      final InputStream inputStream = getInputStream(String.format(getURL(), cep));

      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

         String linha;

         while ((linha = reader.readLine()) != null) {
            json.append(linha);
         }
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }

      return json.toString();
   }

   protected abstract String getURL();

   private InputStream getInputStream(final String url) {
      final InputStream stream;

      try {
         final HttpURLConnection connection;

         connection = (HttpURLConnection) new URL(url).openConnection();
         connection.setRequestMethod("GET");
         connection.setRequestProperty("Accept", "application/json");

         if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
         }

         stream = connection.getInputStream();
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }

      return stream;
   }

}
