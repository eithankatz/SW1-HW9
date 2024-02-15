package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class mySpaceshipComparator implements Comparator<Spaceship>
{
	

	@Override
	public int compare(Spaceship s1, Spaceship s2) 
	{
		//compare by firePower
		int cmp = Integer.compare(s1.getFirePower(), s2.getFirePower());
		if(cmp != 0)
		{
			return -1 * cmp;
		}
		else
		{
			//compare by  commissionYear
			cmp = Integer.compare(s1.getCommissionYear(), s2.getCommissionYear());
			if(cmp != 0)
			{
				return -1 * cmp;
			}
			else
			{
				//compare by name
				return s1.getName().compareTo(s2.getName());
			}
		}
	}
}
