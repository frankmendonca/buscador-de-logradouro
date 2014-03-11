package buscadordelogradouro.buscador;

import buscadordelogradouro.logradouro.Logradouro;
import buscadordelogradouro.logradouro.LogradouroUS;

public class BuscadorDeLogradouroJsonImpl3 extends BuscadorDeLogradouroJson {

   @Override
   protected Class<? extends Logradouro> getClasse() {
      return LogradouroUS.class;
   }

   @Override
   protected String getURL() {
      return "http://apps.widenet.com.br/busca-cep/api/cep/%s.json";
   }

}
