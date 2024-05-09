package controller;

import model.Alerta;
import model.Usuario;
import model.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerVehiculo {
    private static List<Vehiculo> vehiculos = new ArrayList<>();


    public static void agregarVehiculo(String cedulaUsuario, Vehiculo vehiculo) {
        Usuario usuario = ControllerUsuario.buscarUsuarioPorCedula(cedulaUsuario);
        if (usuario != null && vehiculo != null) {
            // Verifica que el vehículo no esté ya registrado y que el SOAT sea válido
            if (buscarVehiculoPorPlaca(vehiculo.getPlaca()) == null && vehiculo.isSoat()) {
                vehiculos.add(vehiculo);
                usuario.agregarVehiculo(vehiculo);
                System.out.println("Vehículo agregado correctamente al usuario con cédula: " + cedulaUsuario);
            } else {
                if (!vehiculo.isSoat()) {
                    System.out.println("Error: El SOAT del vehículo no es válido. No se puede registrar el vehículo.");
                } else {
                    System.out.println("Error: Ya existe un vehículo con esa placa.");
                }
            }
        } else {
            if (usuario == null) {
                System.out.println("Error: No existe un usuario con esa cédula.");
            } else {
                System.out.println("Error: Vehículo nulo.");
            }
        }
    }

    public static Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public static List<Vehiculo> obtenerVehiculosUsuario(String cedulaUsuario) {
        Usuario usuario = ControllerUsuario.buscarUsuarioPorCedula(cedulaUsuario);
        if (usuario != null) {
            return usuario.getVehiculos();
        }
        return new ArrayList<>();
    }

    public static void actualizarVehiculo(String cedulaUsuario, String placa, LocalDate fecha, boolean resultadoTecno, boolean soat) {
        Usuario usuario = ControllerUsuario.buscarUsuarioPorCedula(cedulaUsuario);
        if (usuario != null) {
            Vehiculo vehiculo = usuario.getVehiculos().stream()
                    .filter(v -> v.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);
            if (vehiculo != null) {
                vehiculo.setFecha(fecha);
                vehiculo.setResultadoTecno(resultadoTecno);
                vehiculo.setSoat(soat);
                Alerta.Tipo tipoAlerta = resultadoTecno ? Alerta.Tipo.ALERTAREVISIONAPROBADA : Alerta.Tipo.ALERTAREVISIONREPROBADA;
                Alerta alerta = new Alerta(tipoAlerta);
                // Aquí se podría enviar la alerta, mostrarla en la interfaz de usuario o registrarla
                System.out.println("Generada alerta: " + alerta.getTipo());
            }
        }
    }

    public static void eliminarVehiculo(String cedulaUsuario, String placa) {
        Usuario usuario = ControllerUsuario.buscarUsuarioPorCedula(cedulaUsuario);
        if (usuario != null) {
            Vehiculo vehiculo = usuario.getVehiculos().stream()
                    .filter(v -> v.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);
            if (vehiculo != null) {
                usuario.eliminarVehiculo(vehiculo);
                vehiculos.remove(vehiculo);
            }
        }
    }
}