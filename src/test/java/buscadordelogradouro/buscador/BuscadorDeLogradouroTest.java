package buscadordelogradouro.buscador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import buscadordelogradouro.logradouro.Logradouro;

public abstract class BuscadorDeLogradouroTest {

   @Test
   public void testSemHifen() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("01431001");

      assertEquals("01431001", logradouro.getCep());
      assertEquals("Avenida Brasil", logradouro.getLogradouro());
      assertEquals("Jardim América", logradouro.getBairro());
      assertEquals("São Paulo", logradouro.getLocalidade());
      assertEquals("SP", logradouro.getUf());
   }

   @Test
   public void testSemHifen2() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("88030640");

      assertEquals("88030640", logradouro.getCep());
      assertEquals("Rua Desembargador Alves Pedrosa", logradouro.getLogradouro());
      assertEquals("João Paulo", logradouro.getBairro());
      assertEquals("Florianópolis", logradouro.getLocalidade());
      assertEquals("SC", logradouro.getUf());
   }

   @Test
   public void testSemHifen3() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("32113342");

      assertEquals("32113342", logradouro.getCep());
      assertEquals("Beco Walker", logradouro.getLogradouro());
      assertEquals("Ressaca", logradouro.getBairro());
      assertEquals("Contagem", logradouro.getLocalidade());
      assertEquals("MG", logradouro.getUf());
   }

   @Test
   public void testComHifen() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("70150-903");

      assertEquals("70150903", logradouro.getCep());
      assertEquals("SPP", logradouro.getLogradouro());
      assertEquals("Zona Cívico-Administrativa", logradouro.getBairro());
      assertEquals("Brasília", logradouro.getLocalidade());
      assertEquals("DF", logradouro.getUf());
   }

   @Test
   public void testComHifen2() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("61600-130");

      assertEquals("61600130", logradouro.getCep());
      assertEquals("Rua Doutor João Hipólito", logradouro.getLogradouro());
      assertEquals("Centro", logradouro.getBairro());
      assertEquals("Caucaia", logradouro.getLocalidade());
      assertEquals("CE", logradouro.getUf());
   }

   @Test
   public void testComHifen3() throws Exception {
      final Logradouro logradouro = getBuscadorDeLogradouro().busquePeloCep("13020-431");

      assertEquals("13020431", logradouro.getCep());
      assertEquals("Avenida Barão de Itapura", logradouro.getLogradouro());
      assertEquals("Botafogo", logradouro.getBairro());
      assertEquals("Campinas", logradouro.getLocalidade());
      assertEquals("SP", logradouro.getUf());
   }

   protected abstract BuscadorDeLogradouro getBuscadorDeLogradouro();

}
