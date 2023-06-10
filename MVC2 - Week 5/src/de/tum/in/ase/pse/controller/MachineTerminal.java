package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import de.tum.in.ase.pse.utils.FactoryException;
public class MachineTerminal {

	private final Machine machine;

	public MachineTerminal(Machine machine) {
		this.machine = machine;
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
}
