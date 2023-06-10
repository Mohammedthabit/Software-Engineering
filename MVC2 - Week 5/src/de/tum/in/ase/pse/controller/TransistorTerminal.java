package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.GateType;
import de.tum.in.ase.pse.model.TransistorMachine;
import de.tum.in.ase.pse.model.TransistorType;
import de.tum.in.ase.pse.utils.FactoryException;

public class TransistorTerminal {

	private final TransistorMachine machine;

	private final int lowerBoundSize = 7;
	private final int upperBoundSize = 22;

	public TransistorTerminal(TransistorMachine transistorMachine) {
		this.machine = transistorMachine;
	}

	public void setTargetTemperature(int targetTemperature) {
		if (targetTemperature <= machine.getMaxTemperature() && targetTemperature >= machine.getMinTemperature()) {
			machine.setTargetTemperature(targetTemperature);
		} else {
			throw new FactoryException("Error");
		}
	}

	public void setTargetVoltage(int targetVoltage) {
		if (targetVoltage <= machine.getMaxVoltage() && targetVoltage >= machine.getMinVoltage()) {
			machine.setTargetVoltage(targetVoltage);
		} else {
			throw new FactoryException("Error");
		}
	}

	public void setTransistorSize(int transistorSize) {
		if (transistorSize >= lowerBoundSize && transistorSize <= upperBoundSize) {
			machine.setTransistorSize(transistorSize);
		} else {
			throw new FactoryException("Error");
		}
	}

	public void setTransistorType(TransistorType transistorType) {
		machine.setTransistorType(transistorType);
	}

	public void setGateType(GateType gateType) {
		machine.setGateType(gateType);
	}
}
