package com.jdm.agenda.app;

import com.jdm.agenda.model.Contacto;
import com.jdm.agenda.service.Agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Agenda {
    public void elMenu(){
    ArrayList<Contacto> contactos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Agenda agenda = new Agenda();

    int opcion;

        do {
        System.out.println("\n📱 Menú de Agenda 📱");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Ver espacios libres");
        System.out.println("4. Ver si la agenda está llena");
        System.out.println("5. Verificar si contacto existe");
        System.out.println("6. Listar todos los contactos");
        System.out.println("7. Buscar telefono por nombre");
        System.out.println("8. Modificar Telefono");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Número de contacto (10 dígitos): ");
                String numero = sc.nextLine();
                if (nombre.isEmpty() || apellido.isEmpty() || numero.isEmpty()) {
                    System.out.println("❌ Error: Todos los campos son obligatorios.");
                } else if (!numero.matches("\\d{10}")) {
                    System.out.println("❌ El número debe tener exactamente 10 dígitos.");
                } else {
                    agenda.añadirContacto(new Contacto(nombre, apellido, numero));
                    break;
                }
                break;

            case 2:
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido: ");
                apellido = sc.nextLine();
                agenda.eliminarContacto(new Contacto(nombre, apellido, "0000000000"));
                break;

            case 3:
                System.out.println("📖 Espacios libres: " + agenda.espaciosLibres());
                break;

            case 4:
                if (agenda.agendaLlena()) {
                    System.out.println("✅ La agenda está llena.");
                } else {
                    System.out.println("📖 Hay espacio disponible.");
                }
                break;

            case 5:
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido: ");
                apellido = sc.nextLine();
                boolean existe = agenda.existeContacto(new Contacto(nombre, apellido, "0000000000"));
                System.out.println(existe ? "✅ El contacto existe." : "❌ Contacto no encontrado.");
                break;

            case 6:
                agenda.listarContactos();
                break;
            case 7:
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido: ");
                apellido = sc.nextLine();
                agenda.buscarContacto(nombre, apellido);
                break;
            case 8:
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido: ");
                apellido = sc.nextLine();
                agenda.modificarTelefono(nombre, apellido);
                break;
            case 9:
                System.out.println("👋 ¡Hasta luego!");
                break;

            default:
                System.out.println("❌ Opción inválida.");
        }

    } while (opcion != 9);

        sc.close();

    }
}

