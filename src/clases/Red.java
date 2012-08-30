/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

/**
 *
 * @author ALBERT
 */
public class Red {

    String Error = null;

    String enviar(String msg, String Host) {
        byte[] data = msg.getBytes();
        OutputStream os;
        SocketConnection sc;
        String url = "socket://" + Host + ":636";
        try {
            sc = (SocketConnection) Connector.open(url);
            Error = "Conexion establecida con el servidor : " + Host + "msg: " + msg;
            os = sc.openOutputStream();
            os.write(data);
            System.out.println("Se envio datos...");
            os.close();
        } catch (Exception e) {
            Error = e.getMessage();
            System.out.println("Error Red 1: "+Error);
        }
        return Error;
    }

    String recivir(String port) {
        SocketConnection socket;

        String host;

        int ch;

        host = System.getProperty("microedition.hostname");
        StringBuffer b = new StringBuffer();
        try {
            socket = (SocketConnection) Connector.open("socket://" + host + ":" + port);
            InputStream is = socket.openInputStream();

            // Lee hasta que se cierra la conexión
            while ((ch = is.read()) != -1) {
                b.append((char) ch);
            }
            // Se contruye un TextBox con el contenido de la URL
            System.out.print("Mensaje recibido:" + b.toString());
            is.close();
        } catch (Exception e) {
            Error = e.getMessage();
            System.out.print(Error);
            return Error;
        }
        System.out.print(host);
        return b.toString();
    }
        String Msg() {
        return Error;
    }
}
