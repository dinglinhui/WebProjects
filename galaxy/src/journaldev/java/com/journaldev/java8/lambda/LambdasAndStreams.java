package com.journaldev.java8.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasAndStreams {

	public static void main(String[] args) {

		List<Podcast> podcasts = Arrays.asList(
				// new Podcast(podcastId, title, producer, subscriptionsNumber,
				// upVotes, downVotes),
				new Podcast(1, "Quarks&Co", "wdr", 50, 18, 1),
				new Podcast(2, "Angeklickt - zum Mitnehmen", "wdr", 10, 5, 1),
				new Podcast(3, "Leonardo im WDR 5-Radio zum Mitnehmen", "wdr", 12, 10, 5),
				new Podcast(4, "L'ESPRIT PUBLIC", "France culture", 3, 10, 1),
				new Podcast(5, "LA FABRIQUE DE L'HISTOIRE", "France culture", 10, 4, 1),
				new Podcast(6, "LES MATINS DE FRANCE CULTURE", "France culture", 46, 12, 8));

		System.out.println("*********** Display initial podcasts with forEach ************");
		podcasts.forEach(podcast -> System.out.println(podcast));

		System.out.println("\n\n********************** Sorting with lambdas ***********************");
		// Sort by title
		System.out.println("\n*********** Sort by title (default alphabetically) - highlight comparator ************");
		Collections.sort(podcasts, Comparator.comparing(Podcast::getTitle));
		podcasts.forEach(podcast -> System.out.println(podcast));

		System.out.println("\n*********** Sort by numbers of subscribers DESCENDING - highlight reversed ************");
		Collections.sort(podcasts, Comparator.comparing(Podcast::getSubscriptionsNumber).reversed());
		podcasts.forEach(podcast -> System.out.println(podcast));

		System.out.println(
				"\n*********** Sort by producer and then by title - highlight composed conditions************");
		Collections.sort(podcasts, Comparator.comparing(Podcast::getProducer).thenComparing(Podcast::getTitle));
		podcasts.forEach(podcast -> System.out.println(podcast));

		System.out.println("\n*********** Sort by difference in positive votes DESCENDING ************");
		Collections.sort(podcasts, Podcast.BY_POSITIVE_VOTES_DIFFERENCE);
		podcasts.forEach(podcast -> System.out.println(podcast));

		System.out.println("\n\n******************** Streams *************************");
		System.out.println(
				"\n*********** Filter podcasts with more than 21 subscribers - highlight filters ************");
		podcasts.stream().filter((podcast) -> podcast.getSubscriptionsNumber() >= 21)
				.forEach((podcast) -> System.out.println(podcast));

		System.out.println(
				"\n********* Filter podcasts from producer with more than 21 subscribers - highlight predicate **************");
		Predicate<Podcast> hasManySubscribers = (podcast) -> podcast.getSubscriptionsNumber() >= 21;
		Predicate<Podcast> wdrProducer = (podcast) -> podcast.getProducer().equals("wdr");
		podcasts.stream().filter(hasManySubscribers.and(wdrProducer)).forEach((podcast) -> System.out.println(podcast));

		System.out.println("\n********* Display popular podcasts - highlight \"or\" in predicate **************");
		Predicate<Podcast> hasManyLikes = (podcast) -> (podcast.getUpVotes() - podcast.getDownVotes()) > 8;
		podcasts.stream().filter(hasManySubscribers.or(hasManyLikes)).forEach((podcast) -> System.out.println(podcast));

		System.out.println("\n********* Collect subscription numbers - highlight \"mapToInt\" **************");
		int numberOfSubscriptions = podcasts.stream().mapToInt(Podcast::getSubscriptionsNumber).sum();
		System.out.println("Number of all subscriptions : " + numberOfSubscriptions);

		System.out.println(
				"\n********* Display podcast with most subscriptions -highlight \"map reduce\" capabilities **************");
		Podcast podcastWithMostSubscriptions;
		podcastWithMostSubscriptions = podcasts.stream()
				.map(podcast -> new Podcast(podcast.getId(), podcast.getTitle(), podcast.getProducer(),
						podcast.getSubscriptionsNumber(), podcast.getUpVotes(), podcast.getDownVotes()))
				.reduce(new Podcast(),
						(pod1, pod2) -> (pod1.getSubscriptionsNumber() > pod2.getSubscriptionsNumber()) ? pod1 : pod2);
		System.out.println(podcastWithMostSubscriptions);

		System.out.println(
				"\n********* Display podcasts titles in XML format -highlight \"map reduce\" capabilities **************");
		String titlesInXml = "<podcasts data='titles'>" + podcasts.stream()
				.map(podcast -> "<title>" + podcast.getTitle() + "</title>").reduce("", String::concat) + "</podcasts>";
		System.out.println(titlesInXml);

		System.out.println(
				"\n********* Display podcasts in JSON format -highlight \"map reduce\" capabilities **************");
		String json = podcasts.stream().map(Podcast::toJSON).reduce("[", (l, r) -> l + (l.equals("[") ? "" : ",") + r)
				+ "]";
		System.out.println(json);

		System.out.println(
				"\n********* Display sorted podcasts by title in JSON format -highlight \"map collect\" capabilities **************");
		String jsonViaCollectors = podcasts.stream().sorted(Comparator.comparing(Podcast::getTitle))
				.map(Podcast::toJSON).collect(Collectors.joining(",", "[", "]"));
		System.out.println(jsonViaCollectors);

		System.out.println(
				"\n********* Select first 3 podcasts with most subscribers -highlight \"map collect\" capabilities **************");
		List<Podcast> podcastsWithMostSubscribers = podcasts.stream()
				.sorted(Comparator.comparing(Podcast::getSubscriptionsNumber).reversed()).limit(3)
				.collect(Collectors.toList());
		System.out.println(podcastsWithMostSubscribers);

		System.out.println(
				"\n********* Get podcasts grouped by producer -highlight \"collector\" capabilities **************");
		Map<String, List<Podcast>> podcastsByProducer = podcasts.stream()
				.collect(Collectors.groupingBy(podcast -> podcast.getProducer()));
		System.out.println(podcastsByProducer);
	}
}