package game;
import player.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Game {
	//Map<String, Player> stpm = new TreeMap<String, Player>();
	Map<Player, Integer> ptsm = new HashMap<Player, Integer>();	// p to score
	PlayerStack ps;
	public Game() {
		ps = new PlayerStack();
	}
	
	public void addPlayer(Player p) {
		ps.addPlayer(p);
		ptsm.put(p, 0);
	}
	
	public void printTop(int num) {
		PriorityQueue<Player> pq = new PriorityQueue<Player>(new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				// TODO Auto-generated method stub
				return ptsm.get(arg1) - ptsm.get(arg0);
			}
			
		});
		pq.addAll(ptsm.keySet());
		for (int i = 0; i < num; i++) {
			try {
				Player p = pq.remove();
				System.out.println((i+1)+".\t"+p.name+"\t"+ptsm.get(p));
			} catch (NoSuchElementException e) {
				break;
			}
		}
	}
	
	public void step() {
		Player p = ps.step();
		if (p != null) {
			ptsm.put(p, ptsm.get(p)+1);
		}
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Game g = new Game();
		Player p1 = new Player("abc","def","name"),
				p2 = new Player("player2","pass","person");
		g.addPlayer(p1);
		g.step();
		g.addPlayer(p2);
		g.step();
		p1.enterStack(g.ps);
		g.step();
		g.step();
		p2.enterStack(g.ps);
		p1.enterStack(g.ps);
		g.step();
		g.step();
		g.printTop(5);
	}
}
