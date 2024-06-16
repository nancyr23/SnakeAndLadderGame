package com.game.SnakeAndLadder.model;

public class Player {
	
	int id; // Primary Key
	private String name;
	private int currentPosition;
	
static int idGenerator = 0;
	
	public Player()
	{
		id = ++idGenerator;
		currentPosition = 0;
	}
	
	public Player(String name)
	{
		id = ++idGenerator;
		this.name = name;
		currentPosition = 0;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
}
