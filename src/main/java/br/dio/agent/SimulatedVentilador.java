package br.dio.agent;

public class SimulatedVentilador implements Actuator{
    @Override
    public void execute(Action action) {
        switch (action) {
            case TURN_ON -> System.out.println("Ventilador LIGADO.");
            case TURN_OFF -> System.out.println("Ventilador DESLIGADO.");
            case NONE -> System.out.println("Nenhuma ação necessária.");
        }
    }
}
