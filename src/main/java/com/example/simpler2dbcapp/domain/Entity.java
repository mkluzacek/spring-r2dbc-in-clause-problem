package com.example.simpler2dbcapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("entity")
public class Entity implements Persistable<Long> {

  @Id
  @Column("entity_id")
  private Long entityId;

  public Entity(Long entityId) {
    this.entityId = entityId;
  }

  public Long getEntityId() {
    return entityId;
  }

  public void setEntityId(Long entityId) {
    this.entityId = entityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(entityId, entity.entityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityId);
  }

  public Entity withId(Long entityId) {
    return new Entity(entityId);
  }

  @Override
  public Long getId() {
    return entityId;
  }

  @Override
  public boolean isNew() {
    return true;
  }

}
