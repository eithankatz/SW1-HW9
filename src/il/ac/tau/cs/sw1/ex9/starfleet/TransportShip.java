package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends mySpaceship
{
	public static final int FIGHTER_BASE_PRICE = 3000;
	public static final int CARGO_PRICE = 5;
	public static final int PASSENGER_PRICE = 3;
	int cargoCapacity;
	int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity)
	{
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
		this.annualMaintenanceCost = FIGHTER_BASE_PRICE + (CARGO_PRICE * this.cargoCapacity) + (PASSENGER_PRICE * this.passengerCapacity);
	}

	public int getCargoCapacity()
	{
		return cargoCapacity;
	}

	public int getPassengerCapacity()
	{
		return passengerCapacity;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + System.lineSeparator() 
				+ "\t" + "CargoCapacity=" + this.getCargoCapacity() + System.lineSeparator() 
				+ "\t" + "PassengerCapacity=" + this.getPassengerCapacity();
	} 
}
