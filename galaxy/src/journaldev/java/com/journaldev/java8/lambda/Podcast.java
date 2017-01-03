package com.journaldev.java8.lambda;

import java.util.Comparator;

public class Podcast {

	int id;
	String title;
	String producer;
	int subscriptionsNumber;

	/** number of up votes(likes) */
	int upVotes;

	/** number of down votes */
	int downVotes;

	public Podcast() {
		this.subscriptionsNumber = 0;
	}

	public Podcast(int id, String title, String producer,
			int subscriptionsNumber, int upVotes, int downVotes) {
		this.id = id;
		this.title = title;
		this.producer = producer;
		this.subscriptionsNumber = subscriptionsNumber;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
	}

	public static final Comparator<Podcast> BY_POSITIVE_VOTES_DIFFERENCE = (
			left, right) -> (right.getUpVotes() - right.getDownVotes())
			- (left.getUpVotes() - left.getDownVotes());

	@Override
	public String toString() {
		return "Podcast{" + "title='" + title + '\'' + ", producer='"
				+ producer + '\'' + ", upVotes=" + upVotes + ", downVotes="
				+ downVotes + ", subscriptionsNumber=" + subscriptionsNumber
				+ '}';
	}

	public static String toJSON(Podcast p) {
		return "{" + "title:'" + p.title + '\'' + ", producer:'" + p.producer
				+ '\'' + ", upVotes:" + p.upVotes + ", downVotes:"
				+ p.downVotes + ", subscriptionsNumber:"
				+ p.subscriptionsNumber + "}";
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getSubscriptionsNumber() {
		return subscriptionsNumber;
	}

	public void setSubscriptionsNumber(int subscriptionsNumber) {
		this.subscriptionsNumber = subscriptionsNumber;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}