package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter
{
	protected static int STEALTH_CRUISER_AMOUNT = 0;
	public static final int CLOAKING_DEVICE_PRICE = 50;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) 
	{
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		STEALTH_CRUISER_AMOUNT++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers)
	{
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon ("Laser Cannons",10,100))); 
	}
	
	@Override
	public int getAnnualMaintenanceCost() 
	{
		return super.getAnnualMaintenanceCost() + (CLOAKING_DEVICE_PRICE * STEALTH_CRUISER_AMOUNT);
	}
}
