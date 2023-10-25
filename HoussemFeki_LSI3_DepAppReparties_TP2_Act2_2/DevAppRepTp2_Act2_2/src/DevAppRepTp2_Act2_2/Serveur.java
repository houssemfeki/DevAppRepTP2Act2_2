package DevAppRepTp2_Act2_2;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Réservation du port et attente de la connexion du client
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            System.out.println("Client connecté");

            // Flux de réception des données du client
            InputStream is = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(is);

            // Récupération de l'objet Operation sérialisé
            Operation operationObject = (Operation) objectInputStream.readObject();

            // Récupération des données de l'objet
            int op1 = operationObject.getOp1();
            int op2 = operationObject.getOp2();
            String operation = operationObject.getOperation();

            // Traitement des données (opération mathématique)
            int resultat = 0;
            switch (operation) {
                case "+":
                    resultat = op1 + op2;
                    break;
                case "-":
                    resultat = op1 - op2;
                    break;
                case "*":
                    resultat = op1 * op2;
                    break;
                case "/":
                    if (op2 != 0) {
                        resultat = op1 / op2;
                    } else {
                        System.out.println("Division par zéro détectée.");
                    }
                    break;
                default:
                    System.out.println("Opération non valide.");
            }

            // Flux d'envoi du résultat au client
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(resultat);

            // Fermeture des ressources
            serverSocket.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

