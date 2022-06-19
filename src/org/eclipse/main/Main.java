package org.eclipse.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.classes.Letter;

public class Main {

	public static void main(String[] args) {

		// filter() retourne un nouveau Stream qui contient les éléments qui
		// correspondent au Predicate (renvoie true ou false)
		List<String> genre = Arrays.asList("Rock", "Pop", "Jazz");

		Long a = genre.stream().filter(s -> s.startsWith("R")).count();

		System.out.println(a);

		long elementsLessThanThree = Stream.of(1, 2, 3, 4).filter(p -> p.intValue() < 3).count();

		System.out.println(elementsLessThanThree);

		// map() transforme les éléments d’un Stream
		List<String> strings = Stream.of("one", null, "three").map(s -> {
			if (s == null)
				return "[inconnu]";
			else
				return s;
		}).collect(Collectors.toList());

		System.out.println(strings);

		// Avec flatMap(), vous appliquez d'abord une fonction à vos éléments,
		// puis l'aplatissez (flat)
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(List::stream)
				.map(integer -> integer + 1).collect(Collectors.toList());

		System.out.println(together);

		Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(List::stream).map(integer -> integer + 1)
				.forEach((i) -> System.out.println(i));

		// Convertit toutes les chaînes d'une liste en majuscules grâce à l'appel d'une
		// méthode statique
		System.out.println(genre.parallelStream().map(String::toUpperCase).collect(Collectors.toList()));

		// Renvoie une liste de toutes les chaînes contenant exactement 3 lettres
		System.out.println(
				genre.stream().map(String::toUpperCase).filter(s -> s.length() == 3).collect(Collectors.toList()));

		// peek() : Il permet de lire une donnée du Stream avant qu’une action
		// intermediaire soit engagée.
		System.out.println(genre.stream().peek(s -> System.out.println(s)).map(String::toLowerCase)
				.filter(s -> s.length() == 3).collect(Collectors.toList()));

		// distinct() : Ne retourne qu’une occurrence des valeurs d’un Stream
		List<Integer> distinctIntegers = Stream.of(5, 6, 6, 6, 3, 2).distinct().collect(Collectors.toList());

		System.out.println("distinctIntegers = " + distinctIntegers);

		// sorted() : Permet de retourner un Stream trié dans l’ordre croissant.
		List<Integer> sortedNumbersASC = Stream.of(5, 3, 1, 3, 6).sorted().collect(Collectors.toList());

		System.out.println(sortedNumbersASC);

		// sorted() : Permet de retourner un Stream trié dans l’ordre decroissant.
		List<Integer> sortedNumbersDESC = Stream.of(5, 3, 1, 3, 6).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		System.out.println(sortedNumbersDESC);

		List<Letter> letters = Arrays.asList(new Letter("Rue Massena", "Nice"), new Letter("Rue Jean Jaures", "Paris"),
				new Letter("Rue Victor Hugo", "Lyon"), new Letter("Rue Foch", "Marseille"));

//		List<String> noSortedLetters = letters
//				.stream()
//				.map(Letter::getCity)
//				.collect(Collectors.toList());

		List<String> noSortedLetters = letters.stream().map(s -> s.getCity()).collect(Collectors.toList());

		System.out.println(noSortedLetters);

		List<Letter> sortedLettersASC = letters.stream().sorted(Comparator.comparing(Letter::getCity))
				.collect(Collectors.toList());

		System.out.println(sortedLettersASC);

		List<Letter> sortedLettersDESC = letters.stream().sorted(Comparator.comparing(Letter::getCity).reversed())
				.collect(Collectors.toList());

		System.out.println(sortedLettersDESC);

		// limit() : Limite le nombre d element ds un Stream
		List<String> vals = Stream.of("limit", "by", "two").limit(2).collect(Collectors.toList());

		System.out.println(vals);

		// reduce() : Exemple ici d’une somme des éléments du Stream
		int sum = IntStream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);

		System.out.println(sum);

		// .min() : Permet de retourner la valeur minimale d’un Stream
		OptionalInt min = IntStream.of(1, 2, 3).min();

		if (min.isPresent()) {
			System.out.println(min);
		}

		// max() : Permet de retourner la valeur maximale d’un Stream
		OptionalDouble max = Stream.of(1d, 2d, 3d).mapToDouble(Double::doubleValue).max();

		if (max.isPresent()) {
			System.out.println(max);
		}

		// count() : Permet de trouver le nombre d’éléments d’un Stream.
		long count = Stream.of("one").count();

		System.out.println(count);

		// anyMatch() : teste si la longueur d’un String est supérieure à 5
		boolean lengthOver5 = Stream.of("two", "three", "eighteen").anyMatch(s -> s.length() > 5);

		System.out.println(lengthOver5);

		// allMatch() : Contrôle chaque élément du Stream et cherche si chacun d’entre
		// eux correspond
		// au Predicate fourni.
		boolean cv = Stream.of("pas de satellite à mercure", "pas de satellite à vénus ", "un satellite à la terre")
				.allMatch(p -> p.contains("satellite"));

		System.out.println(cv);

		// noneMatch() : Contrôle si aucun élément du Stream ne correspond au Predicate
		// spécifié.
		boolean noElementEqualTo5 = IntStream.of(1, 2).noneMatch(p -> p == 5);
		System.out.println(noElementEqualTo5);

		// Cherche le premier élément d’un Stream
		Optional<String> val = Stream.of("one", " findFirst").findFirst();

		System.out.println(val);
	}

}
