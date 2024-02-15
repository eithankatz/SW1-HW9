package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myBattleship
{
	public static final int RAIDER_BASE_PRICE = 3500;
	public static final int RAIDER_ENGINE_PRICE = 1200;
	public static final int CYLON_PRICE = 500;
	
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) 
	{
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost += RAIDER_BASE_PRICE + (CYLON_PRICE * crewMembers.size()) + (RAIDER_ENGINE_PRICE * maximalSpeed);
	}
}
