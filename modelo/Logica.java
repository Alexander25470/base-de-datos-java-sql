package modelo;
import javax.swing.JOptionPane;   //para la interfaz gráfica
import modelo.dao.PersonaDao;
import modelo.vo.PersonaVo;
import controlador.Coordinador;

public class Logica {
    private Coordinador miCoordinador;  //objeto instanciado
    public static boolean consultaPersona = false;
    public static boolean modificaPersona = false;
    
    public void setCoordinador(Coordinador miCoordinador){
        this.miCoordinador = miCoordinador;
    }
    
    public void  validarRegistro(PersonaVo miPersona){
        PersonaDao miPersonaDao;
        if(miPersona.getIdPersona()>99){  //necesito 3 dígitos para el ID
            miPersonaDao = new PersonaDao();
            miPersonaDao.registrarPersona(miPersona);  // método no existe aún, está en otra clase          
        }else{
            JOptionPane.showMessageDialog(null, "El id de la persona debe tener más de 3 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public PersonaVo validarConsulta(String codigoPersona){
        PersonaDao miPersonaDao;
        try{
            int codigo = Integer.parseInt(codigoPersona);
            if(codigo > 99){
                miPersonaDao = new PersonaDao();
                consultaPersona = true;
                return miPersonaDao.buscarPersona(codigo); // método no existe aún
            }else{
                JOptionPane.showMessageDialog(null, "El id de la persona debe tener más de 3 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);               
                consultaPersona = false;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe Ingresar un dato numérico", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            consultaPersona = false;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Se ha presentamdo un error", "Error",
                   JOptionPane.ERROR_MESSAGE); 
            consultaPersona = false;
        }
        return null;
    }
    
    public void validarModificacion(PersonaVo miPersona){
        PersonaDao miPersonaDao;
        if(miPersona.getNombrePersona().length()>5){
            miPersonaDao = new PersonaDao();
            miPersonaDao.modificarPersona(miPersona);  // método no existe aún           
        }else{
            JOptionPane.showMessageDialog(null, "el nombre de la persona debe ser mayor que 5",
                   "Advertencia", JOptionPane.WARNING_MESSAGE);
            modificaPersona=false;
        }
    }
    
    public void validarEliminacion(String codigo){
        PersonaDao miPersonaDao = new PersonaDao();
        miPersonaDao.eliminarPersona(codigo);  // método no existe aún 
    }
    
}