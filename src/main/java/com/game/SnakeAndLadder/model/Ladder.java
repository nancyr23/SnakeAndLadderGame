package com.game.SnakeAndLadder.model;

import com.game.SnakeAndLadder.exception.InvalidLadderPositionsException;
import com.game.SnakeAndLadder.exception.InvalidBoardException;

public class Ladder {
	
	private int id; // Primary Key
	private int start;
	private int end;
	
	static int idGenerator = 0;
	
	public Ladder()
	{
		id = ++idGenerator;
	}
	
	public Ladder(int start, int end) throws Exception
	{
		if(!isValidLadder(start, end))
			throw new InvalidLadderPositionsException("Ladder starting point should be smaller than end point. Invalid Ladder - Start at " + start + " and End at " + end);
		
		id = ++idGenerator;
		this.start = start;
		this.end = end;
		
	}
	
	private boolean isValidLadder(int start, int end) {
		return end > start;
	}

	public int getId() {
		return id;
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
	
}
