package model;

public class Alerta {

    public enum Tipo {
        ALERTAREVISIONAPROBADA, ALERTAREVISIONREPROBADA
    }

    private Tipo tipo;

    public Alerta(Tipo tipo) {
        this.tipo = tipo;
    }

    // Getter y setter
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
