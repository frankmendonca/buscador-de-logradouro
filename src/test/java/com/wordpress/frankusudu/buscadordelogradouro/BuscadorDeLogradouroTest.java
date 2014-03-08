package com.wordpress.frankusudu.buscadordelogradouro;

import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;

import org.junit.Test;

import com.wordpress.frankusudu.buscadordelogradouro.BuscadorDeLogradouro;
import com.wordpress.frankusudu.buscadordelogradouro.Logradouro;

public class BuscadorDeLogradouroTest {

   @Test
   public void testSemHifen() throws Exception {
      final BuscadorDeLogradouro buscadorDeLogradouro = new BuscadorDeLogradouro();
      final Logradouro logradouro = buscadorDeLogradouro.busquePeloCep("01431001");

      mostrarLogradouro(logradouro);

      assertEqualsCampo(logradouro, "Logradouro", "Avenida Brasil - de 1121 ao fim - lado ímpar");
      assertEqualsCampo(logradouro, "Bairro", "Jardim América");
      assertEqualsCampo(logradouro, "Localidade/UF", "São Paulo /SP");
      assertEqualsCampo(logradouro, "CEP", "01431001");
   }

   @Test
   public void testComHifen() throws Exception {
      final BuscadorDeLogradouro buscadorDeLogradouro = new BuscadorDeLogradouro();
      final Logradouro logradouro = buscadorDeLogradouro.busquePeloCep("70150-903");

      mostrarLogradouro(logradouro);

      assertEqualsCampo(logradouro, "Endereço", "SPP");
      assertEqualsCampo(logradouro, "Bairro", "Zona Cívico-Administrativa");
      assertEqualsCampo(logradouro, "Localidade/UF", "Brasília /DF");
      assertEqualsCampo(logradouro, "CEP", "70150903");
      assertEqualsCampo(logradouro, "Cliente", "Palácio da Alvorada (Residência Oficial do Presidente da República)");
   }

   private void mostrarLogradouro(final Logradouro logradouro) {
      for (Entry<String, String> informacao : logradouro.entrySet()) {
         System.out.println(informacao.getKey() + ": " + informacao.getValue());
      }
      System.out.println();
   }

   private void assertEqualsCampo(Logradouro logradouro, String tipo, String esperado) {
      assertEquals(tipo, esperado, logradouro.get(tipo));
   }

}
