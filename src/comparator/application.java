package comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import entities.ProductService;
import util.UppercaseName;

public class application {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		ProductService ps = new ProductService();
		double sum = ps.FilteredSum(list, p -> p.getName().charAt(0) == 'T');
		System.out.println(sum);
		
		
		//pratica de Stream e Function
		List<String> names = list.stream().map(new UppercaseName()).collect(Collectors.toList());
		
		//método estático
		List<String> names2 = list.stream().map(Product::StaticUppercase).collect(Collectors.toList());
		
		// Lambda 
		Function<Product, String> func = p -> p.getName().toUpperCase();
		List<String> names3 = list.stream().map(func).collect(Collectors.toList());

		
		
		for (String s : names) {
			System.out.println(s);
		}
		
		
		//referencia para método
		/*list.removeIf(Product::nonStaticProductPredicate);
		
		double min = 100.0;
		
		Consumer<Product> cons = (p) -> p.setPrice(p.getPrice() * 1.1);
		list.forEach(new PriceUpdate());
		
		list.forEach(System.out::println);
		lambda 
		Predicate<Product> pred = p -> p.getPrice() >= min;
		
		list.remove(pred);
		list.removeIf( p -> p.getPrice() >= min);
		
		
		for (Product p : list) {
			System.out.println(p);
		}*/
	}
}
