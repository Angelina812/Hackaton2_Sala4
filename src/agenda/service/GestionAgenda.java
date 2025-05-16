package com.jdm.agenda.service;

import com.jdm.agenda.model.Contacto;

public interface GestionAgenda {
        void añadirContacto(Contacto c);
        boolean existeContacto(Contacto c);
        void listarContactos();
        void buscarContacto(String nombre, String apellido);
        void eliminarContacto(Contacto c);
        void modificarTelefono(String nombre, String apellido);
        boolean agendaLlena();
        int espaciosLibres();
    }
