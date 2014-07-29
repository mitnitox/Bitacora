package negocio;
import datos.*;
import java.util.*;
import java.io.*;

public class Turno{

	Coneccion c;
	ArrayList<String> listId=new ArrayList<String>();
	ArrayList<String> listCorreo=new ArrayList<String>();
	ArrayList<String> listPuerto=new ArrayList<String>();
	ArrayList<String> listEstado=new ArrayList<String>();
        ArrayList<String> listNombres=new ArrayList<String>();
        ArrayList<String> listApellidos=new ArrayList<String>();
        ArrayList<String> listFechaInicio=new ArrayList<String>();
        ArrayList<String> listHoraInicio=new ArrayList<String>();
        ArrayList<String> listFechaFinal=new ArrayList<String>();
        ArrayList<String> listHoraFinal=new ArrayList<String>();
        
        
        
        public void ConsultaTurno(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_turno, usuario.nombres, usuario.apellidos, puerto.nombre, "
                        + "fecha_inicio, hora_inicio, fecha_final, hora_final "
                        + "from usuario, turno, puerto where "
                        + "usuario.id_usuario=turno.id_usuario and puerto.id_puerto=turno.id_puerto");
		while(c.getRs().next()){
                    listId.add(c.getRs().getString("id_turno"));
                    listNombres.add(c.getRs().getString("usuario.nombres"));
                    listApellidos.add(c.getRs().getString("usuario.apellidos"));
                    listPuerto.add(c.getRs().getString("puerto.nombre"));
                    listFechaInicio.add(c.getRs().getString("fecha_inicio"));
                    listHoraInicio.add(c.getRs().getString("hora_inicio"));
                    listFechaFinal.add(c.getRs().getString("fecha_final"));
                    listHoraFinal.add(c.getRs().getString("hora_final"));
		}
            }
            catch(Exception e){
            }
	}
        
        
        
        
        
        public void abrir_Turno(String id_usuario, String id_puerto, String fecha_inicio, String hora_inicio, String estado ){
            try{
			c = new Coneccion();
			c.setEjecutar("insert into turno(id_usuario,id_puerto,fecha_inicio,hora_inicio,estado) values('"+id_usuario+"','"+id_puerto+"','"+fecha_inicio+"','"+hora_inicio+"','"+estado+"')");
		}
		catch(Exception e){

		}
        }
        public void cerrar_turno(String fecha_final, String hora_final, String estado, String id_turno ){
            try{
			c = new Coneccion();
			c.setEjecutar("update turno set fecha_final='"+fecha_final+"',hora_final='"+hora_final+"',estado=0 where id_turno='"+id_turno+"'" +
"");
		}
		catch(Exception e){

		}
        }
        //último turno registrado
        public void getIdTurno(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_turno from turno ORDER BY id_turno DESC LIMIT 0,1");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_turno"));
                }
            }
            catch(Exception e){
                
            }
        }
        
        public void getIdTurnoUsuario(){
            try{
                c = new Coneccion();
                c.setConsulta("select id_turno, usuario.nombres, usuario.apellidos from turno, usuario where turno.id_usuario=usuario.id_usuario ORDER BY id_turno DESC LIMIT 0,1");
                while(c.getRs().next()){
                    
                    listId.add(c.getRs().getString("id_turno"));
                    listNombres.add(c.getRs().getString("usuario.nombres"));
                    listApellidos.add(c.getRs().getString("usuario.apellidos"));
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

	public String getCorreo(int num){
		return listCorreo.get(num);
	}
        
        public String getNombres(int num){
		return listNombres.get(num);
	}
        
        public String getApellidos(int num){
		return listApellidos.get(num);
	}

	public String getPuerto(int num){
		return listPuerto.get(num);
	}
        public String getFechaInicio(int num){
		return listFechaInicio.get(num);
	}
        public String getHoraInicio(int num){
		return listHoraInicio.get(num);
	}
        public String getFechaFinal(int num){
		return listFechaFinal.get(num);
	}
        public String getHoraFinal(int num){
		return listHoraFinal.get(num);
	}

	public String getEstado(int num){
		return listEstado.get(num);
	}
	
	
}
    

    
