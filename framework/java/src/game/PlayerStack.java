package game;

import java.util.Deque;
import java.util.LinkedList;

import player.Player;

public class PlayerStack {
	Deque<Player> stack;
	final double fe;
	final double be;
	final int cd;	//cooldown, steps
	
	public PlayerStack() {
		this(.2, .04, 40);
	}
	public PlayerStack(double f, double b, int c) {
		stack = new LinkedList<Player>();
		fe = f;
		be = b;
		cd = c;
	}
	
	public void addPlayer(Player p) {
		if (!stack.contains(p))
			stack.addFirst(p);
	}
	
	public Player step() {
		Player ret = null;
		if (Math.random() < fe)
			ret = stack.pollFirst();
		if (Math.random() < be)
			stack.pollLast();
		return ret;
	}
}
