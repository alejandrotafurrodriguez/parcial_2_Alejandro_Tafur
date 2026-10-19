package modelos;

import datos.Dataset;

/**
 * Modelo CNN. Hiperparámetro: número de filtros.
 */
public class ModeloCNN extends Modelo {

    private int numFiltros;

    public ModeloCNN(String nombre, int maxEpocas, int numFiltros) {
        super(nombre, maxEpocas);
        this.numFiltros = numFiltros;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int maxEpocas = getLossPorEpoca().length;
        int currentLoss = Math.max(numFiltros * 2, maxEpocas + 1);

        for (int i = 0; i < maxEpocas; i++) {
            registrarEpoca(currentLoss);
            if (currentLoss > 1) {
                currentLoss--;
            }
        }
        return mejorLoss();
    }

    public int getNumFiltros() { return numFiltros; }
}