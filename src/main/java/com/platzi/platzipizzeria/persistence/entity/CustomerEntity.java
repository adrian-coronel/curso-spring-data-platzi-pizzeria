package com.platzi.platzipizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_customer", nullable = false, length = 15)
   private String idCustomer;
   @Column(length = 60, nullable = false)
   private String name;
   @Column(length = 100, nullable = false)
   private String address;
   @Column(length = 50, nullable = false, unique = true)
   private String email;
   @Column(name = "phone_number",length = 20)
   private String phoneNumber;

}
