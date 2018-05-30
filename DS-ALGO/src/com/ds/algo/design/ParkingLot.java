package com.ds.algo.design;
/**
 * 
 *
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 */
public class ParkingLot {

	private static final int NUMBER_OF_SMALL_SLOTS = 10;
	private static final int NUMBER_OF_COMPACT_SLOTS = 10;
	private static final int NUMBER_OF_LARGE_SLOTS = 10;

	public Map<Integer, Slot> occupiedSlots;
	
	private List<Slot> smallSlots;
    private List<Slot> compactSlots;
    private List<Slot> largeSlots; 
	
    
    private ParkingLot() {
        smallSlots = new LinkedList<>();
        compactSlots = new LinkedList<>();
        largeSlots = new LinkedList<>();
        occupiedSlots = new HashMap<>();
        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++)
            smallSlots.add(new Slot(i, VehicleSize.SMALL));

        for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++)
            compactSlots.add(new Slot(i, VehicleSize.MEDIUM));

        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++)
            largeSlots.add(new Slot(i, VehicleSize.LARGE));
    }
	
    public List<Slot> getSmallSlots() {
        return smallSlots;
    }

    public List<Slot> getCompactSlots() {
        return compactSlots;
    }

    public List<Slot> getLargeSlots() {
        return largeSlots;
    }
    
	/**
	 * inner static class is thread safe and this is an example of lazy loading
	 *
	 *
	 */
	  private static class ParkingLotHelper {    
	        public static final ParkingLot instance = new ParkingLot();
	    }    

	    public static ParkingLot getInstance() {    
	        return ParkingLotHelper.instance;    
	    }

	   
	    
	

}
