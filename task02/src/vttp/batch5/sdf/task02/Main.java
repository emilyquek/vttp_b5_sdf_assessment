package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main implements Cloneable {

	public static void main(String[] args) throws Exception {
		String fileName = "";
		if (args.length > 0) {
			fileName = args[0];
			System.out.println("Processing: TTT/" + fileName);
			System.out.print("\n");
		} else {
			System.err.println("Invalid number of arguments! Please insert file name!");
		}

		char[][] board = new char[3][3];

		File file = new File ("task02/TTT", fileName);
		Reader reader = new FileReader(file);
		BufferedReader breader = new BufferedReader(reader);
		String line = "q";

		while (line != null) {
			for (int i = 0; i < board.length; i++) {
				line = breader.readLine();
				if (line == null)
					break;
				char[] indivLine = line.toCharArray();
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = indivLine[j];
				}
			}

		}

		System.out.println("Board:");
		System.out.println(board[0]);
		System.out.println(board[1]);
		System.out.println(board[2]);
		System.out.println("---------------------------");

		int rowY;
		int rowX;
		String boardCoordinates = "";
		List<String> allEmptyPositions = new ArrayList<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					rowY = i;
					rowX = j;
					boardCoordinates = Integer.toString(rowY) + "," + Integer.toString(rowX);
					allEmptyPositions.add(boardCoordinates);
				}
			}
		}

		System.out.println(allEmptyPositions);
		int utility;
		
		for (String pos : allEmptyPositions) {
			char[][] newBoard = board.clone();
			String[] coordinate = pos.split(",");
			newBoard[Integer.parseInt(coordinate[0])][Integer.parseInt(coordinate[1])] = 'X';

			if (newBoard[0][0] == 'X' && newBoard[0][1] == 'X' && newBoard[0][2] == 'X' ||
				newBoard[1][0] == 'X' && newBoard[1][1] == 'X' && newBoard[1][2] == 'X' ||
				newBoard[2][0] == 'X' && newBoard[2][1] == 'X' && newBoard[2][2] == 'X' ||
				newBoard[0][0] == 'X' && newBoard[1][0] == 'X' && newBoard[2][0] == 'X' ||
				newBoard[0][1] == 'X' && newBoard[1][1] == 'X' && newBoard[2][1] == 'X' ||
				newBoard[0][2] == 'X' && newBoard[1][2] == 'X' && newBoard[2][2] == 'X' ||
				newBoard[2][0] == 'X' && newBoard[1][1] == 'X' && newBoard[0][2] == 'X' ||
				newBoard[0][0] == 'X' && newBoard[1][1] == 'X' && newBoard[2][2] == 'X') 
			{ 
				utility = 1;
			} else if (
				newBoard[0][0] == 'O' && newBoard[0][1] == 'O' && newBoard[0][2] == '.' ||
				newBoard[0][0] == 'O' && newBoard[0][1] == '.' && newBoard[0][2] == 'O' ||
				newBoard[0][0] == '.' && newBoard[0][1] == 'O' && newBoard[0][2] == 'O' ||
				newBoard[1][0] == '.' && newBoard[1][1] == 'O' && newBoard[1][2] == 'O' ||
				newBoard[1][0] == 'O' && newBoard[1][1] == 'O' && newBoard[1][2] == '.' ||
				newBoard[1][0] == 'O' && newBoard[1][1] == '.' && newBoard[1][2] == 'O' ||
				newBoard[2][0] == 'O' && newBoard[2][1] == 'O' && newBoard[2][2] == '.' ||
				newBoard[2][0] == 'O' && newBoard[2][1] == '.' && newBoard[2][2] == 'O' ||
				newBoard[2][0] == '.' && newBoard[2][1] == 'O' && newBoard[2][2] == 'O' ||
				newBoard[0][0] == 'O' && newBoard[1][0] == 'O' && newBoard[2][0] == '.' ||
				newBoard[0][0] == 'O' && newBoard[1][0] == '.' && newBoard[2][0] == 'O' ||
				newBoard[0][0] == '.' && newBoard[1][0] == 'O' && newBoard[2][0] == 'O' ||
				newBoard[0][1] == 'O' && newBoard[1][1] == 'O' && newBoard[2][1] == '.' ||
				newBoard[0][1] == 'O' && newBoard[1][1] == '.' && newBoard[2][1] == 'O' ||
				newBoard[0][1] == '.' && newBoard[1][1] == 'O' && newBoard[2][1] == 'O' ||
				newBoard[0][2] == 'O' && newBoard[1][2] == 'O' && newBoard[2][2] == '.' ||
				newBoard[0][2] == 'O' && newBoard[1][2] == '.' && newBoard[2][2] == 'O' ||
				newBoard[0][2] == '.' && newBoard[1][2] == 'O' && newBoard[2][2] == 'O' ||
				newBoard[2][0] == 'O' && newBoard[1][1] == 'O' && newBoard[0][2] == '.' ||
				newBoard[2][0] == 'O' && newBoard[1][1] == '.' && newBoard[0][2] == 'O' ||
				newBoard[2][0] == '.' && newBoard[1][1] == 'O' && newBoard[0][2] == 'O' ||
				newBoard[0][0] == 'O' && newBoard[1][1] == 'O' && newBoard[2][2] == '.' ||
				newBoard[0][0] == 'O' && newBoard[1][1] == '.' && newBoard[2][2] == 'O' ||
				newBoard[0][0] == '.' && newBoard[1][1] == 'O' && newBoard[2][2] == 'O'
			) {
				utility = -1;
			} else {
				utility = 0;
			}
			System.out.printf("y=%s, x=%s, utility=%d\n", coordinate[0], coordinate[1], utility);
			newBoard[Integer.parseInt(coordinate[0])][Integer.parseInt(coordinate[1])] = '.';
		}	
	}
}
