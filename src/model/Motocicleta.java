package model;

import java.time.LocalDate;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, LocalDate fecha, boolean resultadoTecno, boolean soat, int cilindraje) {
        super(placa, fecha, resultadoTecno, soat);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
