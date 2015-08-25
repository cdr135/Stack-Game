package player;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Player {
	String name;
	String username;
	byte[] passHash;
	static final int hashCt = 4;
	static int acctCt = 0;
	int acctNum;
	public Player(String un, String pwd, String nm) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.reset();
		passHash = md.digest(pwd.getBytes());
		for (int i = 0; i < hashCt; i++) {
			passHash = md.digest(passHash);
		}
		name = nm;
		username = un;
		acctNum = ++acctCt;
	}
	public PlayerRep rep() {
		return new PlayerRep(this);
	}
}
