package modelos;

import datos.Dataset;

/**
 * Modelo de regresión. Hiperparámetro: grado del polinomio.
 */
public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int maxEpocas = getLossPorEpoca().length;
        int currentLoss = Math.max(grado * 10, maxEpocas + 1);

        for (int i = 0; i < maxEpocas; i++) {
            registrarEpoca(currentLoss);
            if (currentLoss > 1) {
                currentLoss--;
            }
        }
        return mejorLoss();
    }

    public int getGrado() { return grado; }
}