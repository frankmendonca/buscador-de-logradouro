package com.wordpress.frankusudu.buscadordelogradouro;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BuscadorDeLogradouro {

   private static final String URL_CORREIOS = "http://m.correios.com.br/movel/buscaCepConfirma.do";

   public Logradouro busquePeloCep(String cep) throws MalformedURLException, IOException, ProtocolException {
      cep = cep.replace("-", "");

      final Document doc = getDocument(cep);

      final Logradouro logradouro = getLogradouro(doc);

      return logradouro;
   }

   private Document getDocument(final String cep) throws IOException {
      final Connection connection;

      connection = Jsoup.connect(URL_CORREIOS);
      connection.data("cepEntrada", cep);
      connection.data("metodo", "buscarCep");

      return connection.post();
   }

   private Logradouro getLogradouro(final Document doc) throws IOException {
      final Logradouro logradouro = new Logradouro();

      final Element caixacampobranco = doc.getElementsByClass("caixacampobranco").get(0);

      String chave = null;
      String valor = null;

      for (Element campo : caixacampobranco.children()) {
         if (campo.hasClass("resposta")) {
            chave = campo.text();
         }
         else if (campo.hasClass("respostadestaque")) {
            valor = campo.text();
         }

         if (chave != null && valor != null) {
            logradouro.add(chave, valor);
            chave = null;
            valor = null;
         }
      }

      return logradouro;
   }

}
