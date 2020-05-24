package modelo.conexion;
/*Login: root 
Pass: vacío   */
import java.sql.*;


public class Conexion {
    static String bd = "bbdd";   //es el nombre de la base que creamos
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    
    Connection conn = null;
    //constructor de DbConection
    public  Conexion(){
        try{  //obtenemos el driver para mySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);
            if(conn!=null){
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
        }catch(SQLException e) {
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println("Ocurrió algo inesperado");
        }
    }
    /** Permite retornar la conexión*/
    public Connection getConnection(){
        return conn;
    }
    /** Debemos desconectarnos */
    public void desconectar(){
        conn = null;
    }    
}