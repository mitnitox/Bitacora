package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class Maniobra{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
        ArrayList<String> listSitio=new ArrayList<String>();
        ArrayList<String> listBita1=new ArrayList<String>();
        ArrayList<String> listBita2=new ArrayList<String>();
	ArrayList<String> listCorreo=new ArrayList<String>();
	ArrayList<String> listPuerto=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        String sitio;
        String estado;
        boolean valido;
        
        public void seSitio(String sitio){
            this.sitio=sitio;
        }
        public String getSitio(){
            return this.sitio;
        }
        public void setEstado(String estado){
            this.estado=estado;
        }
        public String getEstado(){
            return this.estado;
        }
        
        public void insertar(String id_turno, String id_tipo_maniobra, String fecha, String hora, String id_nave, String bita1, String bita2, String sitio, String c_proa, String c_popa,String obs_maniobra, String estado){
		try{
			c = new Coneccion();
			c.setEjecutar("insert into maniobra(id_turno,id_tipo_maniobra,fecha,hora,id_nave,bita1,bita2,sitio,c_proa,c_popa,obs_maniobra,estado)"
                                + "values('"+id_turno+"','"+id_tipo_maniobra+"','"+fecha+"','"+hora+"','"+id_nave+"','"+bita1+"','"+bita2+"','"+sitio+"','"+c_proa+"','"+c_popa+"','"+obs_maniobra+"','"+estado+"')");
		}
		catch(Exception e){

		}
	}
        
       public void getIdManiobra(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_maniobra from maniobra ORDER BY id_maniobra DESC LIMIT 0,1");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_maniobra"));
                }
            }
            catch(Exception e){
                
            }
        }
       // Obtengo el sitio y las bitas de la maniobra 
       public void getSitioYbitas(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_maniobra, sitio, bita1, bita2 from maniobra where id_tipo_maniobra=1");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_maniobra"));
                    listSitio.add(c.getRs().getString("sitio"));
                    listBita1.add(c.getRs().getString("bita1"));
                    listBita2.add(c.getRs().getString("bita2"));
                }
            }
            catch(Exception e){
                
            }
        }
       
       public boolean SitioOcupado(String sitio){
            try{
                c = new Coneccion();
                c.setConsulta("select * from maniobra where sitio='"+this.sitio+"'");
                while(c.getRs().next()){
                    if(c.getRs().getString("sitio").equals(this.sitio)){
                        setValido(true);
                    }
                    else{
                        setValido(false);
                    }
                }
            }
            catch(Exception e){
                
            }
            return false;
        }
       
       public boolean AtraqueValido(){
            try{
                c = new Coneccion();
                c.setConsulta("select estado from maniobra");
                while(c.getRs().next()){
                    if(c.getRs().getString("estado").equals("0")){
                        setValido(true);
                    }
                    else{
                        setValido(false);
                    }
                }
            }
            catch(Exception e){
                
            }
            return false;
        }
       
        
        public void setValido(boolean v){
           this.valido = v; 
        }
        public boolean getValido(){
            return this.valido;
        }
       
	public int getCantidad(){
		return listId.size();
	}
	public String getId(int num){
		return listId.get(num);
	}
        public String getSitio(int num){
		return listSitio.get(num);
	}
        public String getBita1(int num){
		return listBita1.get(num);
	}
        public String getBita2(int num){
		return listBita2.get(num);
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
    

    
