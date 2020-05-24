package controlador;
import modelo.*;
import modelo.vo.PersonaVo;
import vista.*;

public class Coordinador {
    
    private Logica miLogica;
    private VentanaPrincipal miVentanaPrincipal;
    private VentanaRegistro miVentanaRegistro;
    private VentanaBuscar miVentanaBuscar;
    
/*Creamos los getters & setters de los 4 objetos creados*/
    
    public Logica getMiLogica() {
        return miLogica;
    }

    public void setMiLogica(Logica miLogica) {
        this.miLogica = miLogica;
    }

    public VentanaPrincipal getMiVentanaPrincipal() {
        return miVentanaPrincipal;
    }

    public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    public VentanaRegistro getMiVentanaRegistro() {
        return miVentanaRegistro;
    }

    public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
        this.miVentanaRegistro = miVentanaRegistro;
    }

    public VentanaBuscar getMiVentanaBuscar() {
        return miVentanaBuscar;
    }

    public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
        this.miVentanaBuscar = miVentanaBuscar;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void mostrarVentanaRegistro(){
        miVentanaRegistro.setVisible(true);
    }
    
    public void mostrarVentanaConsulta(){
        miVentanaBuscar.setVisible(true);
    }
    
    public void registrarPersona(PersonaVo mPersona){
        miLogica.validarRegistro(mPersona);
    }
    
    public PersonaVo buscarPersona(String codigoPersona){
        return miLogica.validarConsulta(codigoPersona);
    }
    
    public void modificarPersona(PersonaVo miPersona){
        miLogica.validarModificacion(miPersona);
    }
    
    public void eliminarPersona(String codigo){
        miLogica.validarEliminacion(codigo);
    }
    
    
    
    
   
   
    
}