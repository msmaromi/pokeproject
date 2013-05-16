package com.pokeranch;

import com.example.menugan.Item;
import com.example.menugan.Monster;
import com.example.menugan.MonsterBall;
import com.example.menugan.MonsterEgg;
import com.example.menugan.Player;
import com.example.menugan.Potion;
import com.pokeranch.maps.HomeActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class GV extends Activity {
	
	public static Player player;
	public static ScreenActivity activeActivity;
	public static DatabaseHandler dbHandler;
	
	private static Context context;
	
	protected void onCreate(Bundle savedInstanceState) {
		dbHandler = DatabaseHandler.getInstance(getApplicationContext());
		context = getApplicationContext();
		super.onCreate(savedInstanceState);
		DrawableManager.initInstance(context);
		player = new Player();
		
		// tambahin item & monster
		
		Item i1 = new Potion();
        Item i2 = new MonsterBall();
        Item i3 = new MonsterEgg();
        Item i4 = new MonsterEgg();
        Item i5 = new MonsterEgg();
        Item i6 = new MonsterEgg();
        Item i7 = new MonsterEgg();
        Item i8 = new MonsterEgg();
        Item i9 = new MonsterEgg();
        Item i10 = new MonsterEgg();
        Item i11= new Potion();
        Item i12= new Potion();
        Item i13 = new MonsterBall();
        player.addItem(i1);
        player.addItem(i2); 
        player.addItem(i3); 
        player.addItem(i4);
        player.addItem(i5);
        player.addItem(i6);
        player.addItem(i7);
        player.addItem(i8);
        player.addItem(i9);
        player.addItem(i10);
        player.addItem(i11);
        player.addItem(i12);
        player.addItem(i13);
        
        Monster m5 = new Monster("imba 1", 99, 1, "Yi", "Api", 5000, 5000, 5000, 100, 100, 0, 0,"xxxx", 100);
        m5.addSkill();
        m5.setCurrentHP(1);
        Monster m6 = new Monster("imba 2", 99, 1, "One", "Air", 4000, 6000, 5000, 100, 100, 0, 0, "xxxx", 100);
        m6.addSkill();
        Monster m1 = new Monster("monster 1");
        m1.setHP(1000);
        m1.setMP(1000);
        m1.addSkill();
        Monster m2 = new Monster("monster 2");
        m2.setHP(2000);
        m2.setMP(2000);
        m2.addSkill();
        Monster m3 = new Monster("monster 3");
        m3.addSkill();
        Monster m4 = new Monster("monster 4");
        m4.addSkill();
        
        player.addMonster(m1);	        
        player.addMonster(m2);
        player.addMonster(m3);
        player.addMonster(m4);
        player.addMonster(new Monster("a"));
        player.addMonster(m5);
        player.addMonster(m6);
		
		
		
		
		
		
		
		
		// pindah ke new/load
		Intent i = new Intent();
		GV.player.setPosition(6, 10);
		i = new Intent(getApplicationContext(), Cover.class);
		startActivity(i);
		finish();
	}

}
