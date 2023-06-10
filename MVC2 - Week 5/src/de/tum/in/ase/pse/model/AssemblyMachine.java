package de.tum.in.ase.pse.model;

public class AssemblyMachine extends Machine {
	//"fin pitch"
	private int spaceBetweenTrans;
	private ChipType chipType;
	public AssemblyMachine(String name, int minVoltage, int maxVoltage, int targetVoltage, int minTemperature,
	                       int maxTemperature, int targetTemperature,
	                       int spaceBetweenTrans, ChipType chipType) {
		super(name, minVoltage, maxVoltage, targetVoltage, minTemperature, maxTemperature, targetTemperature);
		this.spaceBetweenTrans = spaceBetweenTrans;
		this.chipType = chipType;
	}

	public void setSpaceBetweenTrans(int spaceBetweenTrans) {
		this.spaceBetweenTrans = spaceBetweenTrans;
		notifyObservers();
	}

	public void setChipType(ChipType chipType) {
		this.chipType = chipType;
		notifyObservers();
	}

	public int getSpaceBetweenTrans() {
		return spaceBetweenTrans;
	}

	public ChipType getChipType() {
		return chipType;
	}
}
