package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class Puerto{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listNombre=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        
        public void getIdPuerto(String nombre){
            try{
                c = new Coneccion();
                c.setConsulta("select id_puerto from puerto where nombre='"+nombre+"'");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_usuario"));
                }
            }
            catch(Exception e){
                
            }
        }
        
	public void mostrar(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_puerto, nombre, estado from puerto");
                        
		while(c.getRs().next()){
                    listId.add(c.getRs().getString("id_puerto"));
                    listNombre.add(c.getRs().getString("nombre"));
                    listEstado.add(c.getRs().getString("estado"));
                    
		}
            }
            catch(Exception e){
            }
	}
	public void insertar(String rut, String nombres, String apellidos){
		try{
			c = new Coneccion();
			c.setEjecutar("insert into usuario(rut,nombres) values('"+rut+"','"+nombres+"','"+apellidos+"')");
		}
		catch(Exception e){

		}
	}
	public void eliminar(String id){
		try{
			c = new Coneccion();
			c.setEjecutar("delete from usuario where id_usuario='"+id+"'");
		}
		catch(Exception e){

		}
	}

	public void modificar(String id, String rut, String nombres, String apellidos, String correo, String pass, String id_cargo, String id_puerto, String id_nivel, String estado){
		try{
			c = new Coneccion();
			c.setEjecutar("update usuario set rut='"+rut+"',nombres='"+nombres+"',apellidos='"+apellidos+"',correo='"+correo+"',pass='"+pass+"',id_cargo='"+id_cargo+"',id_puerto='"+id_puerto+"',id_nivel='"+id_nivel+"',estado='"+estado+"' where id_usuario='"+id+"'");
		}
		catch(Exception e){

		}
	}

	public int getCantidad(){
		return listId.size();
	}
	public String getId(int num){
		return listId.get(num);
	}

	public String getNombre(int num){
		return listNombre.get(num);
	}
	public String getEstado(int num){
		return listEstado.get(num);
	}
	
	
	
}
    

    
