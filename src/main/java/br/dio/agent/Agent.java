package br.dio.agent;

public class Agent implements Runnable {


    private final Sensor sensor;
    private final DecisionModule decisionModule;
    private final Actuator actuator;
    private volatile boolean running = true;

    public Agent(Sensor sensor, DecisionModule decisionModule, Actuator actuator) {
        this.sensor = sensor;
        this.decisionModule = decisionModule;
        this.actuator = actuator;
    }

    public void stop() {
        running = false;
    }


    @Override
    public void run() {
        while (running) {
            EnvironmentData data = sensor.read();
            System.out.printf("Temperatura Atual: %.2f °C %n", data.value());
            Action action = decisionModule.decide(data);
            actuator.execute(action);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                stop();
            }
        }
    }
}
