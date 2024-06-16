package com.game.SnakeAndLadder.model;

import java.util.Random;

public class Dice {
	
	private int numberOfDice;
	Random random;
	
	public Dice()
	{
		numberOfDice = 1;
		random = new Random();
	}
	
	public Dice(int dices)
	{
		numberOfDice = dices;
		random = new Random();
	}
	
	public int rollDice()
	{
		return numberOfDice + random.nextInt(numberOfDice * 6 + 1 - numberOfDice);
	}
}
