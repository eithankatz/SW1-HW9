package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;


public class StarfleetManager 
{
	
	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) 
	{
		return fleet.stream().sorted(new mySpaceshipComparator()).map(ship -> ship.toString()).collect(Collectors.toList());
		/*
		List<String> ret = new ArrayList<String>();
		List<Spaceship> fleetList = new ArrayList<Spaceship>(fleet);
		fleetList.sort(new mySpaceshipComparator());
		for (Spaceship ship : fleetList) 
		{
			ret.add(ship.toString());
		}
		return ret;
		*/
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) 
	{
		
		
		Map<String, Integer> ret = new HashMap<String, Integer>();
		fleet.stream().map(ship -> ship.getClass().getSimpleName()).forEach(x -> ret.put(x, ret.containsKey(x) ? ret.get(x) + 1 : 1));
		/*
		for (Spaceship ship : fleet) 
		{
			String type = ship.getClass().getSimpleName();
			ret.put(type, ret.containsKey(type) ? ret.get(type) + 1 : 1);
		}
		*/
		return ret;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) 
	{
		return fleet.stream().map(ship -> ship.getAnnualMaintenanceCost()).reduce(0, Integer::sum);
		/*
		int sum = 0;
		for (Spaceship ship : fleet) 
		{
			sum += ship.getAnnualMaintenanceCost();
		}
		return sum;
		*/
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) 
	{
		Set<String> fleetWeaponNames = new HashSet<String>();
		fleet.stream().filter(ship -> !ship.getClass().getSimpleName().equals("TransportShip")).map(x -> (myBattleship)x).
		forEach(ship-> ship.getWeapon().stream().forEach(weapon -> fleetWeaponNames.add(weapon.getName())));
		/*
		for (Spaceship ship : fleet) 
		{
			if(!ship.getClass().getSimpleName().equals("TransportShip"))
			{
				myBattleship bs = (myBattleship)ship;
				for(Weapon weapon : bs.getWeapons())
				{
					fleetWeaponNames.add(weapon.getName());
				}
			}
		}
		*/
		return fleetWeaponNames;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) 
	{
		return fleet.stream().map(ship -> ship.getCrewMembers().size()).reduce(0, Integer::sum);
		/*
		int sum = 0;
		for (Spaceship ship : fleet) 
		{
			sum += ship.getCrewMembers().size();
		}
		return sum;
		*/
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) 
	{
		return (float)fleet.stream().flatMap(ship -> ship.getCrewMembers().stream()).filter(member -> member.getClass().getSimpleName().equals("Officer")).
				map(officer -> officer.getAge()).mapToDouble(val -> val).average().orElse(0.0);
		/*
		float ageSum = 0;
		float officersCnt = 0;
		
		for (Spaceship ship : fleet) 
		{
			for(CrewMember member : ship.getCrewMembers())
			{
				if(member.getClass().getSimpleName().equals("Officer"))
				{
					ageSum += member.getAge();
					officersCnt++;
				}
			}
		}
		return ageSum/officersCnt;
		*/
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) 
	{
		Map<Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<Officer, Spaceship>();
		/*
		for (Spaceship ship : fleet) 
		{
			Officer highestRankingOfficer = ship.getCrewMembers().stream().filter(member -> member.getClass().getSimpleName().equals("Officer")).
					map(member -> (Officer)member).max(new Comparator<Officer>()
					{
						public int compare(Officer o1, Officer o2) 
						{
							return Integer.compare(o1.getAge(), o2.getAge());
						}}).orElse(null);
			if (highestRankingOfficer != null) 
				highestRankingOfficerPerShip.put(highestRankingOfficer, ship);
		}
		*/
		
		for (Spaceship ship : fleet) 
		{
			Officer highestRankingOfficer = null;
			boolean isFirst = true;
			for (CrewMember member : ship.getCrewMembers()) 
			{
				if (member.getClass().getSimpleName().equals("Officer")) 
				{
					Officer off =  (Officer)member;
					if(isFirst || off.getRank().compareTo(highestRankingOfficer.getRank()) > 0) 
					{
						highestRankingOfficer = off;
						isFirst = false;
					}
				}
			}
			if (highestRankingOfficer != null) 
				highestRankingOfficerPerShip.put(highestRankingOfficer, ship);
		}
		return highestRankingOfficerPerShip;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) 
	{
		Map<OfficerRank, Integer> ranks = new HashMap<OfficerRank, Integer>();
		fleet.stream().forEach(ship -> ship.getCrewMembers().stream().filter(member -> member.getClass().getSimpleName().equals("Officer"))
				.map(officer -> (Officer)officer).forEach(x -> ranks.put(x.getRank(), ranks.containsKey(x.getRank())?ranks.get(x.getRank()) + 1 : 1)));
		
		return ranks.entrySet().stream().sorted(new Comparator<Map.Entry<OfficerRank, Integer>>()
		{
			public int compare(Entry<OfficerRank, Integer> e1, Entry<OfficerRank, Integer> e2) 
			{
				int cmp = Integer.compare(e1.getValue(), e2.getValue());
				return cmp != 0 ? cmp : e1.getKey().compareTo(e2.getKey());
			}}).collect(Collectors.toList());
		/*
		for (Spaceship ship : fleet) 
		{
			for(CrewMember member : ship.getCrewMembers())
			{
				if(member.getClass().getSimpleName().equals("Officer"))
				{
					Officer officer = (Officer)member;
					OfficerRank rank = officer.getRank();
					ranks.put(rank, ranks.containsKey(rank)?ranks.get(rank) + 1 : 1);
				}
			}
		}
		Set<Map.Entry<OfficerRank, Integer>>ranksSet = ranks.entrySet();
		List<Map.Entry<OfficerRank, Integer>>ranksList = new ArrayList<>(ranksSet);
		Collections.sort(ranksList,new Comparator<Map.Entry<OfficerRank, Integer>>()
		{
			public int compare(Entry<OfficerRank, Integer> e1, Entry<OfficerRank, Integer> e2) 
			{
				int cmp = Integer.compare(e1.getValue(), e2.getValue());
				return cmp != 0 ? cmp : e1.getKey().compareTo(e2.getKey());

			}});
		return ranksList; 
		*/
	}
}
