package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * conexao
 */
public class conexao {

    private static final String url="jdbc:mysql://localhost:3306/agencia_bd";
    private static String user="root";
    private static final String password="";

    private static Connection conn;

public static Connection getConexao(){
    try {
    if (conn==null) {
        conn=DriverManager.getConnection(url, user, password);
        return conn;
    }else{
        return conn;
    }
}catch (SQLException e){
            e.printStackTrace();
            return null;
        } 
    } 
}

