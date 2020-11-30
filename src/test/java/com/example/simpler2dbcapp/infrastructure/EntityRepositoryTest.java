package com.example.simpler2dbcapp.infrastructure;

import com.example.simpler2dbcapp.TestPostgresqlContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class EntityRepositoryTest {

  @Autowired
  private EntityRepository entityRepository;

  static {
    TestPostgresqlContainer.getInstance().start();
  }

  @Test
  void findByEntityIdIn() {
    entityRepository.findByEntityIdIn(Collections.emptyList()).block();
  }

}