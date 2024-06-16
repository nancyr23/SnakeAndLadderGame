package com.game.SnakeAndLadder.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private int start;
	private int end;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private List<Player> players;
	private Dice dice;
	
	public Board(){
		start = 1;
		end = 100;
		snakes = new ArrayList<>();
		ladders = new ArrayList<>();
		players = new ArrayList<>();
		dice = new Dice(1);
	}
	
	public Board(int start, int end, List<Snake> snakes, List<Ladder> ladders, List<Player> players, Dice dice)
	{
		this.start = start;
		this.end = end;
		this.snakes = snakes;
		this.ladders = ladders;
		this.players = players;
		this.dice = dice;
	}
	
	public Board(List<Snake> snakes, List<Ladder> ladders, List<Player> players)
	{
		this.start = 0;
		this.end = 100;
		this.snakes = snakes;
		this.ladders = ladders;
		this.players = players;
		dice = new Dice(1);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public boolean isInsideBoard(int value)
	{
		return (value >= start && value <= end);
	}
	
	public boolean isBoardValid()
	{
		return (snakes.stream().
				allMatch(snake -> isInsideBoard(snake.getHead()) && isInsideBoard(snake.getTail()))
			   )
				&& 
			   (ladders.stream().
				allMatch(ladder -> isInsideBoard(ladder.getStart()) && isInsideBoard(ladder.getEnd()))
			   );
		
	}
}
