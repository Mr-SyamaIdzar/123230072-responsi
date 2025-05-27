package koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class connector {
    static Connection conn;
    
    public static Connection connection() {
        if (conn == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("responsi_pbo");
            data.setUser("root");
            data.setPassword("");
            try {
                conn = data.getConnection();
                System.out.println("Berhasil");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Gagal");
            }
        }
        return conn;
    }
}
