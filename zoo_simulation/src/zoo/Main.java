package zoo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Type an animal name to see in which animal family it belongs and in which Zoo you can find it.");
		System.out.println("Type 'exit' to terminate the program.");
		Scanner s = new Scanner(System.in);
		Animal animal = new Animal();
		String a = s.nextLine();
		while(!a.equals("exit")) {
			animal.checkAnimalFamily(a);
			animal.checkAnimalZoo(a);
			System.out.println("Type next animal name :");				
			a = s.nextLine();
		}
		s.close();
		System.out.println("Program terminating...");
	}
}



interface Mamals{
	public void checkAnimalFamily(String name);
	public void checkAnimalZoo(String name);
	public final List<String> animals = Arrays.asList("tiger", "zebra", "byson");
	public final List<String> zoos = Arrays.asList("Berlin Zoo", "Bronx Zoo", "London Zoo");
}

interface Reptiles{
	public void checkAnimalFamily(String name);
	public void checkAnimalZoo(String name);
	public final List<String> animals = Arrays.asList("python", "anaconda", "viper");
	public final List<String> zoos = Arrays.asList("Beijing Zoo", "Wellington Zoo");
}

interface Birds{
	public void checkAnimalFamily(String name);
	public void checkAnimalZoo(String name);
	public final List<String> animals = Arrays.asList("parrot", "canary", "eagle");
	public final List<String> zoos = Arrays.asList("Singapore Zoo", "San Diego Zoo");
}



class Animal implements Mamals, Reptiles, Birds{
	String animal_family = "none";

	@Override
	public void checkAnimalFamily(String name) {
		// TODO Auto-generated method stub
		for (String n : Mamals.animals) {
			if (name.equals(n)) {
				animal_family = "mamal";
			}
		}
		for (String n : Reptiles.animals) {
			if (name.equals(n)) {
				animal_family = "reptile";
			}
		}
		for (String n : Birds.animals) {
			if (name.equals(n)) {
				animal_family = "bird";
			}
		}
		if (!animal_family.equals("none")) {
			System.out.println("Animal : '" + name + "', belongs to the animal family : " + animal_family);
		}
		else
		{
			System.out.println("We don't know anything about the animal : '" + name + "'");
		}
	}

	@Override
	public void checkAnimalZoo(String name) {
		// TODO Auto-generated method stub
		if (!animal_family.equals("none")) {
			System.out.println("You can find this animal at these Zoos : ");
			if (animal_family.equals("mamal")) {
				for (String n : Mamals.zoos) {
					System.out.println(n);
				}
			}
			else if (animal_family.equals("reptile")) {
				for (String n : Reptiles.zoos) {
					System.out.println(n);
				}
			}
			else if (animal_family.equals("bird")) {
				for (String n : Birds.zoos) {
					System.out.println(n);
				}
			}
		}	
	}
	
}

