package patterns.dao;

/**
 * Customer Schema SQL Class
 */
public final class CustomerSchemaSql {

    private CustomerSchemaSql() {}

    public static final String CREATE_SCHEMA_SQL = "CREATE TABLE　IF NOT EXISTS CUSTOMERS " +
            "(ID NUMBER, FNAME VARCHAR(100), "
            + "LNAME VARCHAR(100))";

    public static final String DELETE_SCHEMA_SQL = "DROP TABLE CUSTOMERS";

}
