package game;

import java.util.Deque;
import java.util.LinkedList;

import player.PlayerRep;

public class PlayerStack {
	Deque<PlayerRep> stack;
	final double fe;
	final double be;
	final int cd;	//cooldown, steps
	
	public PlayerStack() {
		stack = new LinkedList<PlayerRep>();
		fe = .2;
		be = .04;
		cd = 40;
	}
	
	public PlayerRep step() {
		PlayerRep ret = null;
		if (Math.random() < fe)
			ret = stack.pollFirst();
		if (Math.random() < be)
			stack.pollLast();
		return ret;
	}
}
