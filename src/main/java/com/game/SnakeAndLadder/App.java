package com.game.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.game.SnakeAndLadder.exception.InvalidBoardException;
import com.game.SnakeAndLadder.model.Board;
import com.game.SnakeAndLadder.model.Ladder;
import com.game.SnakeAndLadder.model.Player;
import com.game.SnakeAndLadder.model.Snake;
import com.game.SnakeAndLadder.service.PlayGame;

public class App 
{
    static List<Snake> snakes = new ArrayList<>();
    static List<Ladder> ladders = new ArrayList<>();
    static List<Player> players = new ArrayList<>();
    static Board board;
    
    public static void main( String[] args) throws Exception
    {
        getInputFromUser();
        createBoard();
        PlayGame.startGame(board);
    }
    
    public static void getInputFromUser() throws Exception
    {
    	Scanner sn = new Scanner(System.in);
    	
    	System.out.println("Please provide the input for Snakes and Ladders Game - \n");
    	
    	// Get the snakes details
        int numberOfSnakes = sn.nextInt();
        
        Snake snake;
        for(int i=0; i<numberOfSnakes; i++)
        {
        	int head = sn.nextInt();
        	int tail = sn.nextInt();
        	snake = new Snake(head, tail);
        	snakes.add(snake);
        }
        
        // Get the ladders details
        int numberOfLadders = sn.nextInt();
        
        Ladder ladder;
        for(int i=0; i<numberOfLadders; i++)
        {
        	int start = sn.nextInt();
        	int end = sn.nextInt();
        	ladder = new Ladder(start, end);
        	ladders.add(ladder);
        }
        
        // Get the players details
        int numberOfPlayers = sn.nextInt();
        
        Player player;
        for(int i=0; i<numberOfPlayers; i++)
        {
        	String name = sn.next();
        	player = new Player(name);
        	players.add(player);
        }
        
        sn.close();
    }
    
    public static void createBoard() throws InvalidBoardException
    {
    	board = new Board(snakes, ladders, players);
    	if(!board.isBoardValid())
    		throw new InvalidBoardException("Invalid Board! Make sure all the board components are inside board.");
    }
}
