package com.jdm.agenda.service;

import com.jdm.agenda.model.Contacto;

import java.util.*;

public class Agenda implements GestionAgenda {
    private ArrayList<Contacto> contactos;
    private int capacidadMaxima;

    // Constructor con capacidad por defecto de 10
    public Agenda() {
        this.capacidadMaxima = 10;
        contactos = new ArrayList<>();
    }

    // Constructor con capacidad definida
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        contactos = new ArrayList<>();
    }

    // Añadir contacto a la agenda
    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("❌ La agenda está llena.");
            return;
        }
        if (existeContacto(c)) {
            System.out.println("❌ El contacto ya existe.");
            return;
        }
        if (c.getNombre() == null || c.getApellido() == null || c.getContacto() == null) {
            System.out.println("❌ No se puede añadir un contacto con datos incompletos.");
            return;
        }
        contactos.add(c);
        System.out.println("✅ Contacto añadido.");

    }

    // Verificar si un contacto existe
    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.sonIguales(c)) {
                return true;
            }
        }
        return false;
    }

    // Eliminar contacto
    public void eliminarContacto(Contacto c) {
        boolean eliminado = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).sonIguales(c)) {
                contactos.remove(i);
                eliminado = true;
                System.out.println("✅ Contacto eliminado.");
                break;
            }
        }
        if (!eliminado) {
            System.out.println("❌ Contacto no encontrado.");
        }
    }

    // Mostrar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Mostrar cuántos espacios quedan
    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }


    //Listar Contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("📖 Agenda vacía.");
            return;
        } System.out.println("📒 Lista de contactos:");
        contactos.sort(Comparator
                .comparing((Contacto c) -> c.getNombre().toLowerCase().trim())
                .thenComparing(c -> c.getApellido().toLowerCase().trim()));

        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    //BuscarContactos
    public void buscarContacto(String nombre, String apellido) {
        Contacto buscado = new Contacto(nombre, apellido, "0000000000");

        for (Contacto c : contactos) {
            if (c != null && c.sonIguales(buscado)) {
                System.out.println("Teléfono: " + c.getContacto());
                return;
            }
        }
        System.out.println("❌Contacto no encontrado.");
    }

    //ModificarTelefono
    public void modificarTelefono(String nombre, String apellido){
        Contacto buscado = new Contacto(nombre, apellido, "0000000000");
        for (Contacto contacto : contactos) {
            if (contacto.sonIguales(buscado)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Escriba el nuevo telefono: ");
                String nuevoTelefono = sc.nextLine();
                contacto.setContacto(nuevoTelefono);
                System.out.println("✅ Teléfono actualizado.");
                return;
            }
        }
        System.out.println("❌Contacto no encontrado.");
    }
}