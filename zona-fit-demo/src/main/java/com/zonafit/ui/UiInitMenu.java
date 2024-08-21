package com.zonafit.ui;

import java.util.List;
import java.util.Scanner;

import com.zonafit.data.ClientDAO;
import com.zonafit.domain.Client;

public class UiInitMenu {
    private static ClientDAO clientDAO = new ClientDAO();
    public static void showInitMenu(){
        System.out.println("Seleccione la opción deseada: ");

        int respone = 0;
        do {
            System.out.println( "1. Obtener la lista de clientes ");
            System.out.println("2. Buscar un cliente por su ID ");
            System.out.println("3. Agregar un nuevo cliente.");
            System.out.println("0. Salir");

            try (Scanner sc = new Scanner(System.in)) {
                respone = Integer.valueOf(sc.nextLine());

                switch (respone) {
                    case 1:
                        respone = 0;
                        showClientsList();
                        break;
                    case 2:
                        respone = 0;
                        getClientById();
                        break;
                    case 3:
                        respone = 0;
                        addClient();
                    case 0:
                        System.out.println("Gracias por su visita ");
                        System.exit(0);
                    default:
                        System.out.println("Seleccione una opción valida ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (respone != 0);
    }

    private static void addClient() {
        String name;
        String lastName;
        int membership;
        Client client;
        boolean added;
        System.out.println("Nombre : ");
        try (Scanner sc = new Scanner(System.in)){
            name = sc.nextLine();
            System.out.println("Apellido : ");
            lastName = sc.nextLine();
            System.out.println("Membresia: ");
            membership = Integer.valueOf(sc.nextLine());
            client = new Client(name, lastName, membership);
            added = clientDAO.addClient(client);
            if (added) {
                System.out.println("Cliente agregado exitosamente!.");
            } else {
                System.out.println("No fue posible agregar al cliente.");
            }
        } catch (Exception e) {
            System.out.println("Error al capturar los datos: " + e.getMessage());
        }
        showInitMenu();
    }

    private static void showClientsList(){
      List<Client> clients;
      System.out.println("Obteniendo lista de clientes ...");
      clients = clientDAO.getClientsList();
      for (Client client : clients) {
         System.out.println(client.toString());
      }
      showInitMenu();
    }

    private static void getClientById(){
        int id;
        boolean found;
        System.out.println("Ingresa el ID del cliente a buscar: ");
        try (Scanner sc = new Scanner(System.in)) {
            id = Integer.valueOf(sc.nextLine());
            Client client = new Client(id);
            System.out.println("Cliente antes de la busqueda : " + client);
            found = clientDAO.searchClientByID(client);
            if (found) {
                System.out.println("Cliente encontrado: " + client.getName() + " " + client.getLastName() );
            } else {
                System.out.println("No se encontró registro con el ID: " +  client.getId_cliente());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        showInitMenu();
    }
    
}
