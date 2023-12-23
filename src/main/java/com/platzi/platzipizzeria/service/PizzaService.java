package com.platzi.platzipizzeria.service;

import com.platzi.platzipizzeria.persistence.entity.PizzaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

   private final JdbcTemplate jdbcTemplate;

   public List<PizzaEntity> getAll() {
      return jdbcTemplate.query("SELECT * FROM pizza", new BeanPropertyRowMapper<>(PizzaEntity.class));
   }

}
