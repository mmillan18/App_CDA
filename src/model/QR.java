package model;

public class QR {
    private String quejasRecomendaciones;

    public QR(String quejasRecomendaciones) {
        this.quejasRecomendaciones = quejasRecomendaciones;
    }

    // Método para generar reporte
    public String generarReporte() {
        return "Reporte QR: " + quejasRecomendaciones;
    }
}
