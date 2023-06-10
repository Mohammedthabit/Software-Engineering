package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class VoltSensor {
	private Machine machine;
	private static int timestamp = 0;

	public VoltSensor(Machine machine) {
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
		int value = (int) Math.max(Math.sin(timestamp) * 2 + machine.getTargetVoltage(), 0);
		machine.setCurrentVoltage(value);
	}
}
