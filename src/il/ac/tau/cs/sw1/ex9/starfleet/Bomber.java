package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myBattleship
{
	public static final int BOMBER_BASE_PRICE = 5000;
	int numberOfTechnicians;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians)
	{
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
		this.annualMaintenanceCost *= (10 - (float)this.numberOfTechnicians)/10;
		this.annualMaintenanceCost += BOMBER_BASE_PRICE;
	}

	public int getNumberOfTechnicians()
	{
		return numberOfTechnicians;
	}

	public String toString()
	{
		return super.toString() + System.lineSeparator() 
				+ "\t" + "NumberOfTechnicians=" + this.getNumberOfTechnicians();
	}
}
