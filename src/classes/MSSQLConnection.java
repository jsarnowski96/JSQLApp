/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsarnowski
 */
public class MSSQLConnection {
    public Connection connection;
    
    public MSSQLConnection() {
        
    }

    public void DatabaseUserAuthentication(String username, String password, String server, int port) {
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                "jdbc:sqlserver://" + server + ":" + port + ";",
                username, password
            );         
            System.out.println(connection);
        }
        catch(Exception e) {
            System.out.println(e);
            System.out.println(username);
            System.out.println(password);
            System.out.println(server);            
        }
    }
    
    public void CloseDatabaseConnection() {
        try {
            if(connection.isClosed() == false) {
                connection.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MSSQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int CheckConnectionStatus() {
        try {
            if(connection.isClosed() != true) {
                return 1;
            }
            else {
                return 0;
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        return 2;
    }
}
