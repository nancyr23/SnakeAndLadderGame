package com.game.SnakeAndLadder.model;

import com.game.SnakeAndLadder.exception.InvalidSnakePositionsException;
import com.game.SnakeAndLadder.exception.InvalidBoardException;
import com.game.SnakeAndLadder.model.Board;

public class Snake {
	private int id; // Primary Key
	private int head;
	private int tail;
	
	static int idGenerator = 0;
	
	public Snake()
	{
		id = ++idGenerator;
	}
	
	public Snake(int head, int tail) throws Exception
	{
		if(!isValidSnake(head, tail))
			throw new InvalidSnakePositionsException("Snake head position should be greater than tail position. Invalid Snake - Head at " + head + " and Tail at " + tail);
		
		id = ++idGenerator;
		this.head = head;
		this.tail = tail;
		
	}
	
	private boolean isValidSnake(int head, int tail) {
		return head > tail;
	}

	public int getId() {
		return id;
	}
	
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getTail() {
		return tail;
	}
	public void setTail(int tail) {
		this.tail = tail;
	}
	
	
	

}
