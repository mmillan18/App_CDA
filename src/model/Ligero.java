package model;

import java.time.LocalDate;

public class Ligero extends Vehiculo {
    private int numAirbag;

    public Ligero(String placa, LocalDate fecha, boolean resultadoTecno, boolean soat, int numAirbag) {
        super(placa, fecha,resultadoTecno, soat);
        this.numAirbag = numAirbag;
    }

    public int getNumAirbag() {
        return numAirbag;
    }

    public void setNumAirbag(int numAirbag) {
        this.numAirbag = numAirbag;
    }
}
