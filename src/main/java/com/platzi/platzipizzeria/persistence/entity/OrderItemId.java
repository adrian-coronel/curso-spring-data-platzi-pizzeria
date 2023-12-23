package com.platzi.platzipizzeria.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * En una tabla con una clave primaria compuesta, la combinación única de valores en todas las
 * columnas que conforman la clave primaria garantiza que cada registro sea único en la tabla.
 *
 * EN ESTE CASO, HCEMOS QUE LAS CLAVES SEAN PRIMARIAS PARA QUE NO EXISTAN 2 REGISTROS CON LA MISMA ORDEN E ITEM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

   private Integer idOrder;
   private Integer idItem;

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      // Si el objeto pasado no es una instancia de OrderItemId se retorna false
      if(!(obj instanceof OrderItemId that)) return false; // that asegura un casting
      // "that" en este caso hace refrerencia del objeto pasado
      return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
   }

   /**
    * Genera un código hash basado en los valores de idOrder e idItem. Esto es importante para garantizar un
    * correcto funcionamiento de las estructuras de datos basadas en hash, como las colecciones en Java.
    * @return
    */
   @Override
   public int hashCode() {
      return Objects.hash(idOrder, idItem);
   }
}
