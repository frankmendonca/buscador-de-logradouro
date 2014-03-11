package buscadordelogradouro.buscador;

public final class BuscadorDeLogradouroHtmlTest extends BuscadorDeLogradouroTest {

   @Override
   protected BuscadorDeLogradouro getBuscadorDeLogradouro() {
      return new BuscadorDeLogradouroHtml();
   }

}
