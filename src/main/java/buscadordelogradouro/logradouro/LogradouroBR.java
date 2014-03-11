package buscadordelogradouro.logradouro;

public class LogradouroBR extends Logradouro {

   private String cep;
   private String logradouro;
   private String bairro;
   private String localidade;
   private String uf;

   @Override
   public String getCep() {
      return cep;
   }

   @Override
   public void setCep(String cep) {
      this.cep = cep;
   }

   @Override
   public String getLogradouro() {
      return logradouro;
   }

   @Override
   public void setLogradouro(String logradouro) {
      this.logradouro = logradouro;
   }

   @Override
   public String getBairro() {
      return bairro;
   }

   @Override
   public void setBairro(String bairro) {
      this.bairro = bairro;
   }

   @Override
   public String getLocalidade() {
      return localidade;
   }

   @Override
   public void setLocalidade(String cidade) {
      this.localidade = cidade;
   }

   @Override
   public String getUf() {
      return uf;
   }

   @Override
   public void setUf(String uf) {
      this.uf = uf;
   }

}
