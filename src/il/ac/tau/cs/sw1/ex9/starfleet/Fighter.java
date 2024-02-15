package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myBattleship
{
	public static final int FIGHTER_BASE_PRICE = 2500;
	public static final int FIGHTER_ENGINE_PRICE = 1000;
	List<Weapon> weapons;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons)
	{
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost += FIGHTER_BASE_PRICE + (FIGHTER_ENGINE_PRICE * this.maximalSpeed);
	}
}
