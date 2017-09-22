package employees;

public class Config {

    public static final String DATABASE_NAME = "employees";
    public static final String DATABASE_SERVER = "localhost";
    public static final String DATABASE_USER_ID = "root";
    public static final String DATABASE_PASSWORD = "melody";

    public static final String connection_url = "jdbc:mysql://" + DATABASE_SERVER + "/" + DATABASE_NAME;
}
