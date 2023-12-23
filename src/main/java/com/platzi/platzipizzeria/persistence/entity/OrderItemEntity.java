package com.platzi.platzipizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class) //Indica que la entidad utiliza una clase (OrderItemId) como clave primaria compuesta.
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

   // LLAVES PRIMARIAS COMPUESTAS
   @Id
   @Column(name = "id_item", nullable = false)
   private Integer idItem;
   @Id
   @Column(name = "id_order", nullable = false)
   private Integer idOrder;


   @Column(name = "id_pizza", nullable = false)
   private Integer idPizza;

   @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
   private Double quantity;

   @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
   private Double price;

   // Aqui establecemos la relación
   @OneToOne
   @JoinColumn(
       name = "id_pizza", referencedColumnName = "id_pizza",
       // Garantizamos el princio de responsabilidad Unica, por ello inhabilitamos las inserciones y actualizaciones
       // solo se insertará y actualizará desde la entidad PizzaEntity, no desde esta relación
       insertable = false, updatable = false)
   private PizzaEntity pizza;

   @ManyToOne
   @JoinColumn(name = "id_order", referencedColumnName = "id_order",insertable = false,updatable = false)
   private OrderEntity order;
}
