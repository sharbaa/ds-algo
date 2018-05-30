package com.ds.algo.design;

public abstract class Vehicle {
	
	protected VehicleSize size;
	protected int licenseNumber;
	
	private ParkingLot lot;
	
	public Vehicle(VehicleSize size){
		
		this.size = size;
		this.licenseNumber = this.hashCode();
		lot = 	ParkingLot.getInstance();
	}
	
	private Slot findSlot(){
		Slot slot;
		switch (size) {
		case SMALL:
			slot = lot.getSmallSlots().remove(0);
			break;
		case MEDIUM:
			slot = lot.getCompactSlots().remove(0);
			break;
		case LARGE:
			slot = lot.getLargeSlots().remove(0);
			break;
			

		default:
			slot = null;
		}
		return null;
	}
	
	public void park() {
        Slot slot = findSlot();
        if (slot != null) {
            lot.occupiedSlots.put(this.licenseNumber, slot);
            slot.occupy(this);
        }
    }
	
	
	public void leave() {
        Slot slot = lot.occupiedSlots.remove(this.licenseNumber);
        slot.release();
        switch (this.size) {
        case SMALL:
            lot.getSmallSlots().add(slot);
        case MEDIUM:
            lot.getCompactSlots().add(slot);
        case LARGE:
            lot.getLargeSlots().add(slot);
        }
    }
	

}
