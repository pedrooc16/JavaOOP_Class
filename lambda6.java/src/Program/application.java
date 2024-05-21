package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;


import entities.Product;

public class application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			double average = list.stream().map(p -> p.getPrice()).reduce(0.0, (x,y) -> x + y) / list.size();
			System.out.println("Average price" + average);
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream().filter(p -> p.getPrice() < average).map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
		
	}
		catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		sc.close();

}
	
}
