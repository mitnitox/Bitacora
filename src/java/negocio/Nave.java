package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class Nave{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listNombre=new ArrayList<String>();
	ArrayList<String> listIdTipoNave=new ArrayList<String>();
        ArrayList<String> listEslora=new ArrayList<String>();
        ArrayList<String> listManga=new ArrayList<String>();
        ArrayList<String> listTrg=new ArrayList<String>();
        ArrayList<String> listCalado_proa=new ArrayList<String>();
        ArrayList<String> listCalado_popa=new ArrayList<String>();
        ArrayList<String> listCapacidad=new ArrayList<String>();
        ArrayList<String> listNacionalidad=new ArrayList<String>();
        ArrayList<String> listEstado=new ArrayList<String>();
        
        public void getIdNaveN(String nombre){
            try{
                c = new Coneccion();
                c.setConsulta("select id_nave from nave where nombre='"+nombre+"'");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_nave"));
                }
            }
            catch(Exception e){
                
            }
        }
        
	public void mostrar(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_nave,nombre,id_tipo_nav,eslora,manga,trg,calado_proa,calado_popa,capacidad,nacionalidad,estado from nave");
                        
		while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_nave"));
                    listNombre.add(c.getRs().getString("nombre"));
                    listIdTipoNave.add(c.getRs().getString("id_tipo_nav"));
                    listEslora.add(c.getRs().getString("eslora"));
                    listManga.add(c.getRs().getString("manga"));
                    listTrg.add(c.getRs().getString("trg"));
                    listCalado_proa.add(c.getRs().getString("calado_proa"));
                    listCalado_popa.add(c.getRs().getString("calado_popa"));
                    listCapacidad.add(c.getRs().getString("capacidad"));
                    listNacionalidad.add(c.getRs().getString("nacionalidad"));
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
        public String getIdTipoNave(int num){
		return listIdTipoNave.get(num);
	}
         public String getEslora(int num){
		return listEslora.get(num);
	}
        public String getManga(int num){
		return listManga.get(num);
	}
        public String getTrg(int num){
		return listTrg.get(num);
	}
        public String getCaladoProa(int num){
		return listCalado_proa.get(num);
	}
        public String getCaladoPopa(int num){
		return listCalado_popa.get(num);
	}
        public String getCapacidad(int num){
		return listCapacidad.get(num);
	}
        public String getNacionalidad(int num){
		return listNacionalidad.get(num);
	}
	public String getEstado(int num){
		return listEstado.get(num);
	}
	
	
	
}
    

    
