package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

abstract class myBattleship extends mySpaceship
{
	List<Weapon> weapons;
	
	public myBattleship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons)
	{
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
		this.annualMaintenanceCost = 0;
		for (Weapon weapon : this.weapons)
		{
			this.firePower += weapon.getFirePower();
			this.annualMaintenanceCost += weapon.getAnnualMaintenanceCost();
		}
	}

	public List<Weapon> getWeapon()
	{
		return this.weapons;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + System.lineSeparator() 
				+ "\t" + "WeaponArray=" + this.getWeapon();
	}
}
