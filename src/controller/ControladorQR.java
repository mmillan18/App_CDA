package controller;

import model.QR;

public class ControladorQR {

    public static void registrarFeedback(String quejasRecomendaciones) {
        QR qr = new QR(quejasRecomendaciones);
        String reporte = qr.generarReporte();
        System.out.println(reporte);
    }
}
