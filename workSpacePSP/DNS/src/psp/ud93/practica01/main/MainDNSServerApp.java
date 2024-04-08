package psp.ud93.practica01.main;

import java.net.*;
import java.io.*;
import java.util.*;

public class MainDNSServerApp {

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(2222);
            System.out.println("Servidor DNS iniciado en el puerto 2222...");

            boolean continuar = true;

            while (continuar) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                String consulta = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Consulta recibida: " + consulta);

                if (consulta.isEmpty()) {
                    System.out.println("Saliendo del bucle.");
                    DatagramPacket respuestaPacket = new DatagramPacket(new byte[0], 0, packet.getAddress(), packet.getPort());
                    socket.send(respuestaPacket);
                    continuar = false;
                } else {
                    String respuesta = buscarIP(consulta);
                    InetAddress clienteAddress = packet.getAddress();
                    int clientePort = packet.getPort();
                    buffer = respuesta.getBytes();

                    DatagramPacket respuestaPacket = new DatagramPacket(buffer, buffer.length, clienteAddress, clientePort);
                    socket.send(respuestaPacket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close(); // Asegura que se cierre el socket incluso en caso de excepción.
            }
        }
    }

    private static String buscarIP(String nombre) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("dns.properties")) {
            properties.load(input);
            String ip = properties.getProperty(nombre);
            if (ip != null) {
                return "IP encontrada: " + ip;
            } else {
                return "El nombre no se encuentra";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error en la búsqueda";
        }
    }
}
