package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myBattleship
{
	public static final int VIPER_BASE_PRICE = 4000;
	public static final int VIPER_ENGINE_PRICE = 500;
	public static final int HUMAN_PRICE = 500;
	
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) 
	{
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost += VIPER_BASE_PRICE + (HUMAN_PRICE * crewMembers.size()) + (VIPER_ENGINE_PRICE * maximalSpeed);
	}
}
