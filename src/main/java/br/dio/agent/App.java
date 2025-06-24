package br.dio.agent;

public class App {
    public static void main(String[] args) {
        Sensor sensor = new SimulatedTemperatureSensor();
        DecisionModule brain = new SimpleDecisionModule();
        Actuator actuator = new SimulatedVentilador();

        Agent agent = new Agent(sensor, brain, actuator);
        Thread agentThread = new Thread(agent);
        agentThread.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        agent.stop();
        System.out.println("Agente desligado");
    }
}
