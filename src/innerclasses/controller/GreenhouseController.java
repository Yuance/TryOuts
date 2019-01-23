package innerclasses.controller;

public class GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400)
		};
		gc.addEvent(gc.new Restart(2000, eventList));
		gc.addEvent(new GreenhouseControls.Terminate(100));
		gc.run();
	}
}