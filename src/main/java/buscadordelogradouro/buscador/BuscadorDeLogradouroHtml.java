package buscadordelogradouro.buscador;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import buscadordelogradouro.logradouro.Logradouro;
import buscadordelogradouro.logradouro.LogradouroBR;

public class BuscadorDeLogradouroHtml extends BuscadorDeLogradouro {

   private static final String URL_CORREIOS = "http://m.correios.com.br/movel/buscaCepConfirma.do";

   @Override
   protected Logradouro getLogradouro(String cep) {
      final Document doc = getDocument(cep);

      final Logradouro logradouro = getLogradouro(doc);

      return logradouro;
   }

   private Document getDocument(final String cep) {
      final Connection connection;

      connection = Jsoup.connect(URL_CORREIOS);
      connection.data("cepEntrada", cep);
      connection.data("metodo", "buscarCep");

      try {
         return connection.post();
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   private Logradouro getLogradouro(final Document doc) {
      final Logradouro logradouro = new LogradouroBR();

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
            add(logradouro, chave, valor);
            chave = null;
            valor = null;
         }
      }

      return logradouro;
   }

   private void add(Logradouro logradouro, String chave, String valor) {
      chave = chave.trim().toUpperCase();

      if (chave.contains("CEP")) {
         logradouro.setCep(valor);
      }
      else if (chave.contains("LOGRADOURO") || chave.contains("ENDEREÇO")) {
         logradouro.setLogradouro(valor);
      }
      else if (chave.contains("BAIRRO")) {
         logradouro.setBairro(valor);
      }
      else if (chave.contains("LOCALIDADE") || chave.contains("UF")) {
         final String localidade = valor.substring(0, valor.indexOf("/"));
         final String uf = valor.substring(valor.indexOf("/") + 1).trim();

         logradouro.setLocalidade(localidade);
         logradouro.setUf(uf);
      }
   }

}
