package buscadordelogradouro.buscador;

import buscadordelogradouro.logradouro.Logradouro;
import buscadordelogradouro.logradouro.LogradouroBR2;

public class BuscadorDeLogradouroJsonImpl2 extends BuscadorDeLogradouroJson {

   @Override
   protected Class<? extends Logradouro> getClasse() {
      return LogradouroBR2.class;
   }

   @Override
   protected String getURL() {
      return "http://correiosapi.apphb.com/cep/%s";
   }

}
