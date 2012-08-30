package clases;
//prueba repositorio hola flaco
import com.sun.lwuit.*;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;

public class Inicio extends MIDlet {

    //variables de objeto
    String info;
    Form f;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    CheckBox c4;
    CheckBox c5;
    CheckBox c6;
    CheckBox c7;
    CheckBox c8;
    TextField url;
    Label estado;
    Button enviar;
    Dialog msg;
    Red Red;
    String dato;


    //Metodo para enviar los datos de los pines
    private void EnviarPines() {
        if (c1.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c2.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c3.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c4.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c5.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c6.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c7.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        if (c8.isSelected() == true) {
            info += 1;
        } else {
            info += 0;
        }
        try{
            dato = "pi" + info;
            System.out.println(">> decimal " + dato);
            Red.enviar(dato, url.getText());
            estado.setText("Envio: D. " + dato + ". a : URL//" + url);
            f.setTitle(" " + Red.Msg());
            info = "";
            dato = "";
        } catch (Exception e) {
            info = "";
            dato = "";
            System.out.print("Error 1: " + e.getMessage());
            estado.setText("Error 1:   " + e.getMessage());
            msg.setTitle("Error");
            msg.showDialog();
    }
    }
    
    
    public void startApp() {

        // Inicializamos la librería LWUIT
        Display.getInstance().setShowVirtualKeyboard(false);
        Display.init(this);
        try {
            //Carga el archivo res del tema
            Resources r = Resources.open("/res/tema.res");
            //Selecciona el tema en el archivo
            UIManager.getInstance().setThemeProps(r.getTheme("Tema"));
        } catch (IOException ioe) {
            System.out.println("Error al cargar el tema : " + ioe);
        }
     //Creo el objeto para controlar la red
        Red = new Red();
    //Creo el formulario
    f = new Form("DOMOTICA 0.0.1");


    //f.setLayout(new BorderLayout());
    //Creo los checkbox para las salidas       
    c1 = new CheckBox("Salida A");
    c2 = new CheckBox("Salida B");
    c3 = new CheckBox("Salida C");
    c4 = new CheckBox("Salida D");
    c5 = new CheckBox("Salida E");
    c6 = new CheckBox("Salida F");
    c7 = new CheckBox("Salida G");
    c8 = new CheckBox("Salida H");
    //Creo textfield para la url o ip
    url = new TextField("10.71.190.146");
    msg = new Dialog();
    //Creo label para mostrar lo enviado
    estado = new Label("                ");
    //Creo el boton para el envio de los comandos
    enviar = new Button("Enviar");
    //Captura del evento de botom
        enviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                EnviarPines();
            }
        });


//Agrego los elementos al formulario    
        f.addComponent(url);
        f.addComponent(estado);
        f.addComponent(c1);
        f.addComponent(c2);
        f.addComponent(c3);
        f.addComponent(c4);
        f.addComponent(c5);
        f.addComponent(c6);
        f.addComponent(c7);
        f.addComponent(c8);
        f.addComponent(enviar);
        f.addComponent(msg);
//Muestro el formulario        
        f.show();
        msg.setVisible(false);
                
                }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
