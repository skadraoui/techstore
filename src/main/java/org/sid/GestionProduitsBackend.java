package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProduitsBackend {

//private static final Predicate<String> chaineVide = String::isBlank;

	public static void main(String[] args) {
		// ApplicationContext ctx= SpringApplication.run(CataMvc4Application.class, args);
		SpringApplication.run(GestionProduitsBackend.class, args);
	/*	String gogo = "google";
		String startWidh = String.valueOf(gogo.charAt(0));
		String firstCaracter= String.valueOf(gogo.charAt(1));

		System.out.println(startWidh);
		System.out.println(firstCaracter);
		long ho = 1000;
		int fi = Math.toIntExact(ho);
		int [] numes = {1,6,6,9};
		String [] words = {"a", "bb", "b", "ccc"};
		int num = 321 ;
		System.out.println(num%10);
		//String [] wordsLimit = Arrays.stream(words).limit(2).collect(Collectors.toList()).toArray(String[]::new );

		System.out.println("lenght if : "+words[3].length());
		int gaga = Math.toIntExact(Math.round(Arrays.stream(numes)
				.limit(10)
				.skip(1)
				.average().getAsDouble()));

		Double x=10.0d;
		int intX = Math.toIntExact(Math.round(x));
		int length = numes.length;
		List<Integer> nums = List.of(2, 5, 8);
		//nums.stream().dropWhile()
		List <String> numbers = List.of("one", "two", "three", "four");
		numbers.stream()
				.map(s->s+"*")
						.collect(Collectors.toList());


		numbers.forEach(System.out::println );
		//numbers.removeIf(chaineVide);
		IntStream ints= IntStream.range(0,9);

	 */

	/*
		ProduitRepository pRepo= ctx.getBean(ProduitRepository.class);
		pRepo.save(new Produit(1L,"Pc Portable",1900d, 100));
		pRepo.save(new Produit(2L,"Ecran",1900d, 100));
		pRepo.save(new Produit(3L,"Souris",1900d, 100));
		pRepo.save(new Produit(4L,"Cable HDMI",1900d, 100));
		pRepo.save(new Produit(5L,"Cable alimentation",1900d, 100));
		pRepo.save(new Produit(6L,"Ecran",1900d, 100));

		pRepo.findAll().forEach(p->System.out.println(p.getDesignation()));
	 */
	}

	/*public static Map<String, String> firstChar(String[] strings) {

		Map<String, String> map= new HashMap<>();

		for(String str: strings){
			String firstChar = String.valueOf(str.charAt(0)) ;
			if(map.containsKey(firstChar)){
				String oldValue = map.get(firstChar) ;
				map.replace(firstChar , oldValue, oldValue.concat(str) );
			}else {
				map.put(firstChar, str);
			}

		}
		return map;
	}
	 */

}
