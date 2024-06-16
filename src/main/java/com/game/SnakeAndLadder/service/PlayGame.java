package com.game.SnakeAndLadder.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import com.game.SnakeAndLadder.model.Board;
import com.game.SnakeAndLadder.model.Ladder;
import com.game.SnakeAndLadder.model.Player;
import com.game.SnakeAndLadder.model.Snake;

public class PlayGame {
	
	public static void startGame(Board b)
	{
		// Generate Maps for Snakes and Ladders for O(1) check if player landed on snake's head or ladder's start
		Map<Integer, Integer> snakesMap = new HashMap<>();
		Map<Integer, Integer> laddersMap = new HashMap<>();
		
		fillTheMaps(snakesMap, laddersMap, b.getSnakes(), b.getLadders());
	
		Queue<Player> playerQueue = new LinkedList<>(b.getPlayers());
		
		while(true)
		{
			// get the player from the queue
			Player player = playerQueue.poll();
			playerQueue.add(player);
			int value = b.getDice().rollDice();
			int currentValue = player.getCurrentPosition();
			int newValue = currentValue + value;
			
			// If player went outside the board, then don't move
			if(!b.isInsideBoard(newValue))
			{
				printMessage(player.getName(), value, currentValue, currentValue, 0, 0);
				continue;
			}
			
			int caughtBySnake = 0;
			int gotLadder = 0;
			
			// Check if player landed on snake's head or ladder's start on loop
			while(snakesMap.containsKey(newValue) || laddersMap.containsKey(newValue))
			{
				if(snakesMap.containsKey(newValue))
				{
					newValue = snakesMap.get(newValue);
					caughtBySnake++;
				}
				if(laddersMap.containsKey(newValue))
				{
					newValue = laddersMap.get(newValue);
					gotLadder++;
				}
			}
			
			// Update the player currentPosition and print the message
			player.setCurrentPosition(newValue);
			printMessage(player.getName(), value, currentValue, newValue, caughtBySnake, gotLadder);

			// Check if player landed on end of the Board
			if(newValue == b.getEnd())
			{
				System.out.println(player.getName() + " wins the game. Hoorray!!!");
				System.exit(0);
			}
		}
	}

	private static void fillTheMaps(Map<Integer, Integer> snakesMap, Map<Integer, Integer> laddersMap,
			List<Snake> snakes, List<Ladder> ladders) {
		// Generate Maps for Snakes and Ladders for O(1) check if player landed on snake's head or ladder's start
		snakesMap.putAll(snakes.stream().collect(Collectors.toMap(snake -> snake.getHead(), snake -> snake.getTail())));
		laddersMap.putAll(ladders.stream().collect(Collectors.toMap(ladder -> ladder.getStart(), ladder -> ladder.getEnd())));
	}
	
	private static void printMessage(String playerName, int diceValue, int oldPosition, int newPosition, int caughtBySnake, int gotLadder)
	{
		System.out.print(playerName + " rolled a " + diceValue + " and moved from " + oldPosition + " to " + newPosition);
		if(caughtBySnake != 0)
			System.out.print(" Bitten by snake " + caughtBySnake + " times");
		if(gotLadder != 0)
			System.out.print(" Got help via ladder " + gotLadder + " times");
		System.out.println();
	}
}
