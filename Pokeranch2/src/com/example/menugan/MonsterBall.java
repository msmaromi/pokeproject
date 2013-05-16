/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.menugan;



/**
 *
 * @author msmaromi
 */
public class MonsterBall extends Item {
  public MonsterBall(int harga, String nama) {
    super(harga, nama);
  }
  
  public MonsterBall(){
	  super(500,"Monster Ball");
  }
  
  public MonsterBall(MonsterBall mb) {
    super(mb);
  }
  
  public void execute(Player p, Monster m) {    
    /*if(m.isSekarat())
      p.addMonster(m);
    else
      System.out.println("monster tidak bisa ditangkap");
      */
  }
}
