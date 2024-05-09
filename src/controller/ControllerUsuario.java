package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        if (usuario != null && buscarUsuarioPorCedula(usuario.getCedula()) == null) {
            usuarios.add(usuario);
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("Error: Usuario ya existe o es nulo.");
        }
    }

    public static Usuario buscarUsuarioPorCedula(String cedula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    public static void actualizarUsuario(Usuario usuarioActualizado) {
        Usuario usuario = buscarUsuarioPorCedula(usuarioActualizado.getCedula());
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("Error: Usuario no encontrado.");
        }
    }

    public static void eliminarUsuario(String cedula) {
        Usuario usuario = buscarUsuarioPorCedula(cedula);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Error: Usuario no encontrado.");
        }
    }

    public static List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}

