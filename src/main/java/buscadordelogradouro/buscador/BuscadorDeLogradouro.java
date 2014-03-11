package buscadordelogradouro.buscador;

import buscadordelogradouro.logradouro.Logradouro;

public abstract class BuscadorDeLogradouro {

   public final Logradouro busquePeloCep(String cep) {
      cep = cep.replace("-", "");

      final Logradouro logradouro = getLogradouro(cep);

      corrigirInformacoes(logradouro);

      return logradouro;
   }

   protected abstract Logradouro getLogradouro(String cep);

   private void corrigirInformacoes(Logradouro logradouro) {
      logradouro.setCep(logradouro.getCep().replace("-", "").trim());

      String endereco = logradouro.getLogradouro();

      if (endereco.contains("-")) {
         endereco = endereco.substring(0, endereco.indexOf(" - "));
      }

      logradouro.setLogradouro(endereco.trim());

      logradouro.setBairro(logradouro.getBairro().trim());

      if (logradouro.getLocalidade() != null) {
         logradouro.setLocalidade(logradouro.getLocalidade().trim());
      }

      if (logradouro.getUf() != null) {
         logradouro.setUf(logradouro.getUf().trim());
      }
   }

}
