package com.example.simpler2dbcapp;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestPostgresqlContainer extends PostgreSQLContainer<TestPostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:11";

    private static final TestPostgresqlContainer INSTANCE = new TestPostgresqlContainer()
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    private TestPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static TestPostgresqlContainer getInstance() {
        return INSTANCE;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_HOST", INSTANCE.getContainerIpAddress());
        System.setProperty(
                "DB_PORT", INSTANCE.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT).toString());
        System.setProperty("DB_NAME", INSTANCE.getDatabaseName());
        System.setProperty("DB_USER", INSTANCE.getUsername());
        System.setProperty("DB_PASSWORD", INSTANCE.getPassword());
    }
}
