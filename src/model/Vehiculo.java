package model;

import java.time.LocalDate;

public abstract class Vehiculo {
    private String placa;
    private LocalDate fecha;
    private boolean resultadoTecno;
    private boolean soat;

    public Vehiculo(String placa, LocalDate fecha, boolean resultadoTecno, boolean soat) {
        this.placa = placa;
        this.fecha = fecha;
        this.resultadoTecno = resultadoTecno;
        this.soat = soat;
    }

    // Getters y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isResultadoTecno() {
        return resultadoTecno;
    }

    public void setResultadoTecno(boolean resultadoTecno) {
        this.resultadoTecno = resultadoTecno;
    }

    public boolean isSoat() {
        return soat;
    }

    public void setSoat(boolean soat) {
        this.soat = soat;
    }
}
