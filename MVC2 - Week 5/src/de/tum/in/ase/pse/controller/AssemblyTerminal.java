package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.AssemblyMachine;
import de.tum.in.ase.pse.model.ChipType;
import de.tum.in.ase.pse.utils.FactoryException;

public class AssemblyTerminal {

	private final AssemblyMachine machine;
	private final int lowerBoundSpace = 27;
	private final int upperBoundSpace = 60;


	public AssemblyTerminal(AssemblyMachine assemblyMachine) {
		this.machine = assemblyMachine;
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

	public void setSpaceBetweenTrans(int space) {
		if (space >= lowerBoundSpace && space <= upperBoundSpace) {
			machine.setSpaceBetweenTrans(space);
		} else {
			throw new FactoryException("Error");
		}
	}

	public void setChipType(ChipType chipType) {
		machine.setChipType(chipType);
	}
}
