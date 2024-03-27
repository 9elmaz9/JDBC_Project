//package jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//public class ConnectionDB {

 // public Connection getConnection(){
 //     Connection connection=null;
 //     try{
 //         connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/blogdb",
 //                 "blogger" ,
 //                 "P@ssw0rd");
 //         System.out.println("Connection to database is made ");
 //     }catch (SQLException ex){
 //         System.err.println("SQL EXCEPTION:"+ex.getMessage());
 //     }
 //     return connection;
 // }
 // public Statement createStatement(){
 //     Statement statement=null;
 //     try {
 //         statement= getConnection().createStatement();

 //     }catch (SQLException exception){
 //         System.out.println("SQL EXCEPTION:"+exception);
 //     }
 //     return statement;
 // }
//}
