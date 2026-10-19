package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int maxEpocas = getLossPorEpoca().length;
        int currentLoss = Math.max(numCapas * 5, maxEpocas + 1);

        for (int i = 0; i < maxEpocas; i++) {
            registrarEpoca(currentLoss);
            if (currentLoss > 1) {
                currentLoss--;
            }
        }
        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}