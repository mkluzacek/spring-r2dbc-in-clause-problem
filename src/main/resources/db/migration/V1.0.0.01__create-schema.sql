create table entity (
    entity_id bigint not null
        constraint entity_pkey
            primary key
);

INSERT INTO entity VALUES (10);