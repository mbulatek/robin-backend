package com.robin.backend;

public class TopItem {
	private String playerName;
	private String playerMail;
	private int levelReached;
	
	public TopItem(String playerName, String playerMail, int levelReached) {
		this.playerName = playerName;
		this.playerMail = playerMail;
		this.levelReached = levelReached;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getPlayerMail() {
		return playerMail;
	}
	
	public int getLevelReached() {
		return levelReached;
	}
}
