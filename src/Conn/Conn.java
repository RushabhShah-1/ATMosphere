package Conn;
import java.sql.*;
public class Conn {
    public Connection c;
    public Statement s;
    public Conn(){
        try{
        c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Rushabh@112");
        s=c.createStatement();
        } catch(Exception e){
            System.out.println(e);
        }
       
    }
}
