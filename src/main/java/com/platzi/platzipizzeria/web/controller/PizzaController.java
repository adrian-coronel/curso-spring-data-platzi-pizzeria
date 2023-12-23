package com.platzi.platzipizzeria.web.controller;

import com.platzi.platzipizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzipizzeria.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
@RequiredArgsConstructor
public class PizzaController {

   private final PizzaService pizzaService;

   @GetMapping
   public ResponseEntity<List<PizzaEntity>> getAll(){
      return ResponseEntity.ok(this.pizzaService.getAll());
   }

}
