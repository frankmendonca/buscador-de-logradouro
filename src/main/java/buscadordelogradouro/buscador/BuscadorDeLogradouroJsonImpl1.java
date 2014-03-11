package buscadordelogradouro.buscador;

import buscadordelogradouro.logradouro.Logradouro;
import buscadordelogradouro.logradouro.LogradouroBR;

public class BuscadorDeLogradouroJsonImpl1 extends BuscadorDeLogradouroJson {

   @Override
   protected Class<? extends Logradouro> getClasse() {
      return LogradouroBR.class;
   }

   @Override
   protected String getURL() {
      return "http://cep.correiocontrol.com.br/%s.json";
   }

}
