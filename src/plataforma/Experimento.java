package plataforma;

import datos.Dataset;
import modelos.*;

/**
 * Experimento que COMPONE un modelo.
 * El modelo se crea dentro del constructor (composición real).
 */
public class Experimento {

    private String id;
    private Modelo modelo;

    /**
     * Crea el modelo según el tipo indicado.
     * Tipo: "CNN", "RNN", "REGRESION".
     * Si el tipo es inválido, el modelo queda null.
     */
    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;
        if (tipoModelo == null) {
            this.modelo = null;
            return;
        }

        switch (tipoModelo.toUpperCase()) {
            case "CNN":
                this.modelo = new ModeloCNN("CNN-" + id, maxEpocas, 16);
                break;
            case "RNN":
                this.modelo = new ModeloRNN("RNN-" + id, maxEpocas, 4);
                break;
            case "REGRESION":
                this.modelo = new ModeloRegresion("Regresion-" + id, maxEpocas, 2);
                break;
            default:
                this.modelo = null;
                break;
        }
    }

    /** Ejecuta el entrenamiento del modelo sobre el dataset. */
    public double ejecutar(Dataset dataset) {
        if (this.modelo == null || dataset == null) {
            return 0.0;
        }
        return this.modelo.entrenar(dataset);
    }

    public String getId() { return id; }
    public Modelo getModelo() { return modelo; }
}