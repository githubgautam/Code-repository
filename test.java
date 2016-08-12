package com.translations.globallink;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {
  public static void main(String[] argv) throws Exception {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    Connection con = DriverManager.getConnection("jdbc:sqlserver://GOVINDA;databaseName=TDC",
        "gautam", "password");


    CallableStatement proc_stmt = con.prepareCall("{ call vendor.uspTranslationRequestGet(?) }");

    proc_stmt.setString(1, "2");
    ResultSet rs = proc_stmt.executeQuery();

    if (rs.next()) {
      int id = rs.getInt(1);
      System.out.println("uspTranslationRequestGet Id: " + id);
    } else {
      System.out.println("Stored procedure failed to execute");
    }

   
  }
