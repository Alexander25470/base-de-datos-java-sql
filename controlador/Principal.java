package controlador;
import modelo.Logica;
import vista.VentanaBuscar;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Principal {
    private Logica miLogica;
    private VentanaPrincipal miVentanaPrincipal;
    private VentanaRegistro miVentanaRegistro;
    private VentanaBuscar miVentanaBuscar;
    Coordinador miCoordinador;
    

     public static void main(String[] args) {
        Principal miPrincipal = new Principal();
        miPrincipal.iniciar();
    }
    /*Instanciar todas las clases del proyecto*/
     private void iniciar(){
         /*Instanciamos todas las clases*/
         miVentanaPrincipal = new VentanaPrincipal();
         miVentanaRegistro = new VentanaRegistro();
         miVentanaBuscar = new VentanaBuscar();
         miLogica = new Logica();
         miCoordinador = new Coordinador();
         
    /*Se establecen las relaciones entre las clases */
    miVentanaPrincipal.setCoordinador(miCoordinador);
    miVentanaRegistro.setCoordinador(miCoordinador);
    miVentanaBuscar.setCoordinador(miCoordinador);
    miLogica.setCoordinador(miCoordinador);
    
    /*Establecemos las relaciones con la clase Coordinador*/
    miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
    miCoordinador.setMiVentanaRegistro(miVentanaRegistro);
    miCoordinador.setMiVentanaBuscar(miVentanaBuscar);
    miCoordinador.setMiLogica(miLogica);
    
    miVentanaPrincipal.setVisible(true);
     }
}