package com.wordpress.frankusudu.buscadordelogradouro;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Logradouro {

   private final Map<String, String> dados = new LinkedHashMap<>();

   public void add(String tipo, String valor) {
      tipo = tipo.substring(0, tipo.length() - 1);
      tipo = tipo.replace(" / ", "/");

      dados.put(tipo, valor);
   }

   public String get(String tipo) {
      return dados.get(tipo);
   }

   public Set<Entry<String, String>> entrySet() {
      return dados.entrySet();
   }

}
