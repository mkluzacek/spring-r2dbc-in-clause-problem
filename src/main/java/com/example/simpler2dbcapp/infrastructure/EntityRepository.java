package com.example.simpler2dbcapp.infrastructure;

import com.example.simpler2dbcapp.domain.Entity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EntityRepository extends ReactiveCrudRepository<Entity, Long> {

  public Mono<Entity> findByEntityIdIn(List<Long> entityIds);

}
