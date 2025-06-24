package br.dio.agent;

import java.util.Random;

public class SimulatedTemperatureSensor implements Sensor{

    private final Random randomTemperature = new Random();

    @Override
    public EnvironmentData read() {
        double temperature = 20 + (15 * randomTemperature.nextDouble());
        return new EnvironmentData(temperature);
    }
}
