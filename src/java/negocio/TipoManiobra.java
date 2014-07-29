package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class TipoManiobra{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listCorreo=new ArrayList<String>();
        ArrayList<String> listNombre=new ArrayList<String>();
	ArrayList<String> listPuerto=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        
        
        //último turno registrado
        public void getIdTipoManiobra(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_tipo_maniobra from tipo_maniobra ORDER BY id_tipo_maniobra DESC LIMIT 0,1");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_turno"));
                }
            }
            catch(Exception e){
                
            }
        }
        public void getIdTipoManiobraN(String nombre){
            try{
                c = new Coneccion();
                c.setConsulta("select id_tipo_maniobra from tipo_maniobra where nombre='"+nombre+"'");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_tipo_maniobra"));
                }
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
    

    
