package buscadordelogradouro.logradouro;

public abstract class Logradouro {

   public abstract String getCep();

   public abstract void setCep(String cep);

   public abstract String getLogradouro();

   public abstract void setLogradouro(String logradouro);

   public abstract String getBairro();

   public abstract void setBairro(String bairro);

   public abstract String getLocalidade();

   public abstract void setLocalidade(String cidade);

   public abstract String getUf();

   public abstract void setUf(String uf);

   @Override
   public final int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((getCep() == null) ? 0 : getCep().hashCode());
      return result;
   }

   @Override
   public final boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Logradouro other = (Logradouro) obj;
      if (getCep() == null) {
         if (other.getCep() != null)
            return false;
      }
      else if (!getCep().equals(other.getCep()))
         return false;
      return true;
   }

   @Override
   public final String toString() {
      return "Logradouro [cep=" + getCep() + ", logradouro=" + getLogradouro() + ", bairro=" + getBairro()
            + ", localidade=" + getLocalidade() + ", uf=" + getUf() + "]";
   }

}
