import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private Connection connection;

    private DatabaseSingleton() {
        // Configuração da conexão com o banco de dados
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "username";
            String password = "password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

public class DatabaseSingletonExample {
    public static void main(String[] args) {
        // Obtendo a instância do Singleton
        DatabaseSingleton database = DatabaseSingleton.getInstance();

        // Usando a conexão com o banco de dados
        Connection connection = database.getConnection();
        System.out.println("Connected to database: " + connection);
    }
}