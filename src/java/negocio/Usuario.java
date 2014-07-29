package negocio;
import datos.*;
import java.util.*;
import java.io.*;


public class Usuario{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listNombres=new ArrayList<String>();
	ArrayList<String> listApellidos=new ArrayList<String>();
	ArrayList<String> listCorreo=new ArrayList<String>();
	ArrayList<String> listPass=new ArrayList<String>();
	ArrayList<String> listCargo=new ArrayList<String>();
	ArrayList<String> listPuerto=new ArrayList<String>();
	ArrayList<String> listPerfil=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        
        String correo;
        String pass;
        boolean valido;
        
        public void setCorreo(String correo){
            this.correo = correo;
        }
        public String getCorreo(){
            return this.correo;
        }
        public void setPass(String pass){
            this.pass = pass;
        }
        public String getPass(){
            return this.pass;
        }
        
        public boolean UsuarioExiste(String user, String pass){
            try{
                c = new Coneccion();
                c.setConsulta("select * from usuario where correo='"+this.getCorreo()+"' and pass='"+this.getPass()+"'");
                while(c.getRs().next()){
                    if(c.getRs().getString("correo").equals(this.correo) && c.getRs().getString("pass").equals(this.pass)){
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
        
        public void getIdUsuario(String correo){
            try{
                c = new Coneccion();
                c.setConsulta("select id_usuario from usuario where correo='"+correo+"'");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_usuario"));
                    
                }
            }
            catch(Exception e){
                
            }
        }
        public void getIdPuerto(String correo){
            try{
                c = new Coneccion();
                c.setConsulta("select id_puerto from usuario where correo='"+correo+"'");
                while(c.getRs().next()){
                    
                    listPuerto.add(c.getRs().getString("id_puerto"));
                    
                }
            }
            catch(Exception e){
                
            }
        }
	public void mostrar(){
            try{
                c = new Coneccion();
                c.setConsulta("select usuario.id_usuario, usuario.nombres, usuario.apellidos, usuario.correo, "
                                + "usuario.pass, cargo.nombre, puerto.nombre, perfil.nombre, usuario.estado "
                                + "from usuario, cargo, puerto, perfil where usuario.id_cargo=cargo.id_cargo "
                                + "and usuario.id_puerto=puerto.id_puerto and usuario.id_perfil=perfil.id_perfil "
                                + "order by id_usuario");
                        //c.setConsulta("SELECT * FROM `vista_usuario`"); 
		while(c.getRs().next()){
                    listId.add(c.getRs().getString("id_usuario"));
                    listNombres.add(c.getRs().getString("nombres"));
                    listApellidos.add(c.getRs().getString("apellidos"));
                    listCorreo.add(c.getRs().getString("correo"));
                    listPass.add(c.getRs().getString("pass"));
                    listCargo.add(c.getRs().getString("cargo.nombre"));
                    listPuerto.add(c.getRs().getString("puerto.nombre"));
                    listPerfil.add(c.getRs().getString("perfil.nombre"));
                    listEstado.add(c.getRs().getString("estado"));
		}
            }
            catch(Exception e){
            }
	}
	public void insertar(String rut, String nombres, String apellidos, String correo, String pass, String id_cargo, String id_puerto, String id_nivel, String estado){
		try{
			c = new Coneccion();
			c.setEjecutar("insert into usuario(rut,nombres,apellidos,correo,pass,id_cargo,id_puerto,id_nivel,estado) values('"+rut+"','"+nombres+"','"+apellidos+"','"+correo+"','"+pass+"','"+id_cargo+"','"+id_puerto+"','"+id_nivel+"','"+estado+"')");
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

	public String getNombres(int num){
		return listNombres.get(num);
	}
	public String getApellidos(int num){
		return listApellidos.get(num);
	}
	public String getCorreo(int num){
		return listCorreo.get(num);
	}
	public String getPass(int num){
		return listPass.get(num);
	}
	public String getCargo(int num){
		return listCargo.get(num);
	}
	public String getPuerto(int num){
		return listPuerto.get(num);
	}
	public String getPerfil(int num){
		return listPerfil.get(num);
	}
	public String getEstado(int num){
		return listEstado.get(num);
	}
	
	
}
    

    
