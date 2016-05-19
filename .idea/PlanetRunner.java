
import java.util.ArrayList;

class Planet  {
	private String planetName;
	private ArrayList<Ocean> oceans = new ArrayList<>();
	private ArrayList<Mainland> mainlands = new ArrayList<>();
	private ArrayList<Island> islands = new ArrayList<>();

	
	public void addIsland(String islandName,double area) {
		Island island = new Island(islandName,area);
		islands.add(island);
	}

	public void addMainland(String mainlandName,int numsOfCountry,double area) {
		Mainland mainland = new Mainland(mainlandName,numsOfCountry,area);
		mainlands.add(mainland);
	}

	public void addOcaen(String oceanName, double area) {
		Ocean ocean = new Ocean(oceanName,area);
		oceans.add(ocean);
	}
	
	
	public String getAllOceans() {
		String ocean = "Ocean(s) in this planet"+"\n";
		
		for (Ocean obj:oceans) {
			ocean += obj.toString();
		}
		return ocean;
	}
	
	public String getAllMainlands() {
		String mainland = "Mainland(s) in this planet"+"\n";

		for (Mainland obj:mainlands) {
			mainland += obj.toString();
		}
		return mainland;
	}
	
	private class Ocean {
		protected String oceanName;
		protected double area;
		
		Ocean(String oceanName, double area) {
			this.oceanName = oceanName;
			this.area = area;
		}

		public void setArea(double area) {
			this.area = area;
		}

		public void setOceanName(String oceanName) {
			this.oceanName = oceanName;
		}
		
		public String getOceanName() {
			return oceanName;
		}
	
		public double getArea() {
			return area;
		}

		@Override
		public String toString() {
			return oceanName+" ocean, with "+area+" km^2"+"\n";
		}	
	}

	private class Island {
		private String islandName;
		protected double area;
		
		Island(String islandName,double area) {
			this.islandName = islandName;
			this.area = area;
		}
		
		Island(double area) {
			this.area = area;
		}
		
		public String getIslandName() {
			return islandName;
		}
	}

	private class Mainland extends Island {
		private String mainlandName;
		private int numsOfCountry;
		
		Mainland(String mainlandName,int numsOfCountry,double area) {
			super(area);
			this.mainlandName = mainlandName;
			this.numsOfCountry = numsOfCountry;
		}
		
		public int getNumOfCountry() {
			return numsOfCountry;
		}
	
		public String getMainlandName() {
			return mainlandName;
		}

		@Override
		public String toString()
		{
			return "Name of mainland "+mainlandName+"\n"+
				"with area "+area+" km^2 "+"and include "+numsOfCountry+
				" countries"+"\n";
		}
	}
	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	public int getNumOfMailands() {
		return mainlands.size();
	}
}

public class PlanetRunner {
	public static void main(String[] args) {
		Planet earth = new Planet();
		earth.setPlanetName("Earth");
		System.out.println("Planet: "+earth.getPlanetName());
		earth.addMainland("America",3,585555886);
		earth.addMainland("Eurasia",583,852874065);
		earth.addMainland("Africa",19,78855996);
		System.out.println(earth.getAllMainlands());
		System.out.println("Earth have only "+earth.getNumOfMailands()+" countries");
		
	}


}
