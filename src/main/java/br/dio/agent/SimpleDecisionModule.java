package br.dio.agent;

public class SimpleDecisionModule implements DecisionModule {

    private boolean ventiladorLigado = false;

    @Override
    public Action decide(EnvironmentData input) {
        double temperature = input.value();
        if (temperature > 30 && !ventiladorLigado) {
            ventiladorLigado = true;
            return Action.TURN_ON;
        }

        if (temperature <= 25 && ventiladorLigado) {
            ventiladorLigado = false;
            return Action.TURN_OFF;
        }

        return Action.NONE;
    }
}
