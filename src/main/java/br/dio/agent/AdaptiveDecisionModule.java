package br.dio.agent;

import java.util.LinkedList;
import java.util.Queue;

public class AdaptiveDecisionModule implements DecisionModule {

    private boolean ventiladorLigado = false;
    private final Queue<Double> historico = new LinkedList<>();
    private final int MAX_HISTORICO = 30;

    @Override
    public Action decide(EnvironmentData input) {
        double temperature = input.value();
        historico.add(temperature);
        if (historico.size() > MAX_HISTORICO) historico.poll();
        double media = historico.stream().mapToDouble(Double::doubleValue).average().orElse(temperature);
        double limiar = media + 1.5;

        if (temperature > limiar && !ventiladorLigado) {
            ventiladorLigado = true;
            return Action.TURN_ON;
        }

        if (temperature < limiar && ventiladorLigado) {
            ventiladorLigado = false;
            return Action.TURN_OFF;
        }

        return Action.NONE;

    }
}
