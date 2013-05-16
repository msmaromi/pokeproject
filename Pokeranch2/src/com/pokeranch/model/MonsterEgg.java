/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pokeranch.model;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author msmaromi
 */
public class MonsterEgg extends Item {
  private Monster isiEgg;
  
  public MonsterEgg(int harga, String nama, Monster egg) {
    super(harga, nama);
    isiEgg = egg;
  }
  
  public MonsterEgg(MonsterEgg me) {
    super(me);
    isiEgg = me.isiEgg;
  }
  
  public Monster getIsiEgg() {
    return isiEgg;
  }
  
  public void setIsiEgg(Monster egg) {
    isiEgg = egg;
  }
  
  public void execute(Player p) {
	String randomName = randomString();
	String[] listSpecies = {"yi", "er", "san", "chi", "wu", "liu", "one", "two", "three", "four", "five", "six", "uno", "dos", "tres", "cuatro", "cinch", "seis", "den", "twee", "erie", "vier", "vyf", "see"};
	String randomSpecies = listSpecies[(int) (Math.random()*listSpecies.length)];
	String[] listElement = {"api", "air", "angin", "tanah"};
	String randomElement = listElement[(int) (Math.random()*listElement.length)]; 
	isiEgg = new Monster(randomName, 0, 0, randomSpecies, randomElement, 10, 10, 5, 0, 0, 10, 10, "active", 0);
	p.addMonster(isiEgg);
    
  }
  
  private String randomString() {
	    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 5; i++) {
	        char c = chars[random.nextInt(chars.length)];
	        sb.append(c);
	    }
	    return sb.toString();
  }
}
