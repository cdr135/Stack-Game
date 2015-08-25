package game;
import player.*;
import java.util.*;

public class Game {
	Map<Integer, Player> itpm = new TreeMap<Integer, Player>();
	Map<String, Player> stpm = new TreeMap<String, Player>();
	Map<Player, Integer> ptsm = new TreeMap<Player, Integer>();
	PlayerStack ps;
	
	public void step() {
		PlayerRep pr = ps.step();
		if (pr != null) {
			Player p = itpm.get(pr.id);
			ptsm.put(p, ptsm.get(p)+1);
		}
	}
}
