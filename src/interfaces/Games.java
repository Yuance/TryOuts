package interfaces;

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Chess implements Game {
	Chess() {}
	private int moves = 0;
	private final int MOVES = 3;
	public boolean move() {
		System.out.println("Chess move" + moves);
		return moves++ != MOVES;
	}
}

class Checker implements Game {
	Checker() {}
	private int moves = 0;
	private final int MOVES = 4;
	public boolean move() {
		System.out.println("Checker move" + moves);
		return moves++ != MOVES;
	}
}

class ChessFactory implements GameFactory {
	ChessFactory() {}
	public Game getGame() {
		return new Chess();
	}
}

class CheckerFactory implements GameFactory {
	CheckerFactory() {}
	public Game getGame() {
		return new Checker();
	}
}

public class Games {
	public static void playGame (GameFactory fact) {
		Game s = fact.getGame();
		while (s.move())
			;
	}
	public static void main(String[] args) {
		playGame(new CheckerFactory());
		playGame(new ChessFactory());
	}
}