package My_Classes;


import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class DB {

    private static String servername = "localhost";
    private static String username = "root";
    private static String password = "";
    private static String dbname = "java_library_system";
    private static Integer portNumber = 3306;

    public static Connection getConnection() {
        Connection connection = null;

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setServerName(servername);
        dataSource.setUser(username);
        dataSource.setDatabaseName(dbname);
        dataSource.setPortNumber(portNumber);
        dataSource.setPassword(password);

        try {
            connection = (Connection) dataSource.getConnection();
        } catch (SQLException sQLException) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, sQLException);
        }

        return connection;
    }

}
