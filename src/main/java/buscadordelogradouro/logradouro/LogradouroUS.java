package buscadordelogradouro.logradouro;

public class LogradouroUS extends Logradouro {

   private String code;
   private String address;
   private String district;
   private String city;
   private String state;

   @Override
   public String getCep() {
      return code;
   }

   @Override
   public void setCep(String cep) {
      this.code = cep;
   }

   @Override
   public String getLogradouro() {
      return address;
   }

   @Override
   public void setLogradouro(String logradouro) {
      this.address = logradouro;
   }

   @Override
   public String getBairro() {
      return district;
   }

   @Override
   public void setBairro(String bairro) {
      this.district = bairro;
   }

   @Override
   public String getLocalidade() {
      return city;
   }

   @Override
   public void setLocalidade(String cidade) {
      this.city = cidade;
   }

   @Override
   public String getUf() {
      return state;
   }

   @Override
   public void setUf(String uf) {
      this.state = uf;
   }

}
