package buscadordelogradouro.logradouro;

public class LogradouroBR2 extends Logradouro {

   private String cep;
   private String tipoDeLogradouro;
   private String logradouro;
   private String bairro;
   private String cidade;
   private String estado;

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
      this.logradouro = tipoDeLogradouro + " " + logradouro;
      this.logradouro = this.logradouro.trim();
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
      return cidade;
   }

   @Override
   public void setLocalidade(String cidade) {
      this.cidade = cidade;
   }

   @Override
   public String getUf() {
      return estado;
   }

   @Override
   public void setUf(String estado) {
      this.estado = estado;
   }

}
