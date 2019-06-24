package com.example.build.models.data;

import com.example.build.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {
}
