package datos;
import java.sql.DriverManager.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccion{

    private String bd="bitacora";
    private String user="root";
    private String pass="toor";
    private Connection con;
    private Statement st;
    private ResultSet rs;
	
    public Coneccion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/"+bd,user,pass);
	}
	catch(Exception e){
	}
    }
    public void setEjecutar(String sql){	
        try{
            st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
        }
	catch(Exception e){
	}
    }
    public void setConsulta(String sql){
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
	}
	catch(Exception e){
	}
    }
    public ResultSet getRs(){
        return rs;
    }
}