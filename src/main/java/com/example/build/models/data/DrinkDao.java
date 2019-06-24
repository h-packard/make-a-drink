package com.example.build.models.data;

import com.example.build.models.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface DrinkDao extends CrudRepository<Drink, Integer> {
}
