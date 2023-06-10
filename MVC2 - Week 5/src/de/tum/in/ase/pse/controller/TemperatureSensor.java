package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TemperatureSensor {

	private Machine machine;
	private static final int MULTIPLIER = 3;
	private static int timestamp = 0;

	public TemperatureSensor(Machine machine) {
		this.machine = machine;
		//for simulating regular sensor input/update
		Timeline beat = new Timeline(
				new KeyFrame(Duration.ZERO, event -> sendValue()),
				new KeyFrame(Duration.seconds(1), event -> {
				})
		);
		beat.setAutoReverse(true);
		beat.setCycleCount(Animation.INDEFINITE);
		beat.play();
	}

	protected void sendValue() {
		timestamp++;
		int value = (int) Math.max(Math.sin(timestamp) * MULTIPLIER + machine.getTargetTemperature(), 0);
		machine.setCurrentTemperature(value);
	}
}
