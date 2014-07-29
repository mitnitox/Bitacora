package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class Novedad{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listCorreo=new ArrayList<String>();
	ArrayList<String> listPuerto=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        
        public void insertar(String id_tipo_novedad, String id_nave, String id_turno, String fecha, String hora, String obs, String prioridad, String estado){
		try{
			c = new Coneccion();
			c.setEjecutar("insert into novedad(id_tipo_novedad,id_nave,id_turno,fecha,hora,obs,prioridad,estado)"
                                + "values('"+id_tipo_novedad+"','"+id_nave+"','"+id_turno+"','"+fecha+"','"+hora+"','"+obs+"','"+prioridad+"','"+estado+"')");
		}
		catch(Exception e){

		}
	}
        
   
        
       public void getIdNovedad(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_novedad from novedad");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_novedad"));
                }
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

	public String getCorreo(int num){
		return listCorreo.get(num);
	}

	public String getPuerto(int num){
		return listPuerto.get(num);
	}

	public String getEstado(int num){
		return listEstado.get(num);
	}
	
	
}
    

    
