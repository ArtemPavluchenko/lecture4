
import java.util.ArrayList;
import java.math.RoundingMode;
import java.math.BigDecimal;

abstract class Operations {
//Метод для подбора камней для ожерелья(в центре блилиант, по бокам 2 корунда и еще 4 аквамарина
	public static ArrayList<Gems> Selections(ArrayList<Gems> dateBase) {
		ArrayList <Gems> forNecklace = new ArrayList<>();
		System.out.println("Gems for necklace"+"\n");
		int numOfDiamonds = 0;
		int numOfCorunds = 0;
		int numOfBerils = 0;
		
		for (int i = 0; i < dateBase.size(); i++) {
			//Подбираем алмаз с 20...21 каратами и добавляем в ArrayList Gems
			if(dateBase.get(i).getName().equals("Diamond") && 
			compareWeight(dateBase.get(i).getWeight(),20,21) && 
			numOfDiamonds < 1) {
				forNecklace.add(dateBase.get(i));
				numOfDiamonds++;
			}
			
			if(compareWeight(dateBase.get(i).getWeight(),10,11) && 
			   numOfCorunds < 2 && dateBase.get(i).getName().equals("Corund")) {
				forNecklace.add(dateBase.get(i));
				numOfCorunds++;
			}
			
			if(compareWeight(dateBase.get(i).getWeight(),10,11) && 
			   numOfBerils < 4 && dateBase.get(i).getName().equals("Aquamarin")) {
				forNecklace.add(dateBase.get(i));
				numOfBerils++;
			}
		}
		return forNecklace;
	}
	//Метод выводит общую цену и вес ожерелья
	public static void getWeightAndPriceNechlace(ArrayList<Gems> necklace) {
		BigDecimal allStonesWeight = new BigDecimal(0);
		BigDecimal allStonesPrice = new BigDecimal(0);

		for (int i = 0; i < necklace.size(); i++) {
			BigDecimal weight = new BigDecimal(necklace.get(i).getWeight());
			allStonesWeight = allStonesWeight.add(weight).setScale(3,RoundingMode.HALF_UP);
			allStonesPrice = allStonesPrice.add(necklace.get(i).getPrice()).setScale(3,RoundingMode.HALF_UP);
		}

		System.out.println("Total price "+allStonesPrice+" $");
		System.out.println("Total weight "+allStonesWeight+" carats");
		System.out.println();
	}
	//Метод сортирует камни по цене(сверху дорогие, снизу дешевые)
	public static void sortByPrice(ArrayList<Gems> necklace) {
		System.out.println("Sort by price"+"\n");
		for (int i = 0; i < necklace.size(); i++) {
			for (int j = 0; j < necklace.size(); j++) {
				
				if (necklace.get(i).getPrice().doubleValue() > 
					necklace.get(j).getPrice().doubleValue()) {
					Gems obj = necklace.get(i);
					necklace.set(i,necklace.get(j));
					necklace.set(j,obj);
				}
			}
		}
	}
	//Метод выводит в консоль камни с которые "попадают" в заданный диапазон
	public static void showGemsInRanges(ArrayList<Gems> necklace,double rangeDoun,double rangeUp) {
		System.out.println("Gems in refraction rage"+"\n");
		int num = 0;
		for (int i = 0; i < necklace.size(); i++) {
			if (necklace.get(i).getRefraction() > rangeDoun && 
				necklace.get(i).getRefraction() < rangeUp) {
					System.out.println(necklace.get(i).toString());
					num++;
				}
		}
		if (num == 0) {
			System.out.println("Gems not found");
		}
	}
	//Метод генерирует ID
	public static int generateId() {
		int a = (int)(Math.random()*8000000)+1000000;
		return a;
	}
	//Метод генерирует вес
	public static double generateWeight() {
		double a = new BigDecimal((Math.random()*50)+0.01).
		setScale(3,RoundingMode.HALF_DOWN).doubleValue();
		return a;
	}
	//Метод для проверки попадает ли вес в "рамки"
	public static boolean compareWeight (double weight, double rangeDoun,
		double rangeUp) {
		if(weight > rangeDoun && weight < rangeUp) {
			return true;
		} else {
			return false;
		}
	}
	//Выводит в консоль все элементы ArrayList
	public static void showArray(ArrayList<Gems> gemsArray) {
		for (Gems obj:gemsArray) {
			System.out.println(obj.toString());
		}
	}
}

public class GemsRunner {
	public static void main(String[] args) {
		ArrayList<Gems> dataBase = new ArrayList<>();
		//Создаем базу данных из 1000 камней
		for (int i = 0; i < 1000; i++) {
			
			Diamond obj = new Diamond(Operations.generateWeight());
			obj.setId(Operations.generateId());
			obj.setName("Diamond");
			dataBase.add(obj);
			
			
			Corund obj1 = new Corund(Operations.generateWeight());
			obj1.setId(Operations.generateId());
			obj1.setName("Corund");
			dataBase.add(obj1);
			
			Aquamarin obj2 = new Aquamarin(Operations.generateWeight());
			obj2.setId(Operations.generateId());
			obj2.setName("Aquamarin");
			dataBase.add(obj2);
			
			Beril obj3 = new Beril(Operations.generateWeight());
			obj3.setId(Operations.generateId());
			obj3.setName("Beril");
			dataBase.add(obj3);
			
		}
		
		ArrayList<Gems> necklace = new ArrayList<>();

		necklace = Operations.Selections(dataBase);
		Operations.showArray(necklace);

		Operations.getWeightAndPriceNechlace(necklace);

		Operations.sortByPrice(necklace);

		Operations.showArray(necklace);

		Operations.showGemsInRanges(necklace,1.7,2.5);
		
	}
}
