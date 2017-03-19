/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LucianoRex
 */
//@teste
public class Conexao {

    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    // JDBC driver name and database URL
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String DB_URL = "jdbc:mysql://localhost/sakila"; //nome do  banco de dados(loginjsp)

    //  Database credentials
      String USER = "root";//usuario do mysql
      String PASS = "Tec2016!";//senha do mysql

    public void abreConexao() throws ClassNotFoundException {        
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
          
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = con.createStatement();
//
//      String sql = "select ACTOR.ACTOR_ID,ACTOR.FIRST_NAME,ACTOR.LAST_NAME,ACTOR.LAST_UPDATE\n" +
//"FROM ACTOR";

        } catch (SQLException se) {
        }       
    }//end main

   

}
