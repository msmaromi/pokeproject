package com.pokeranch.maps;

import java.util.Random;
import java.util.Vector;

import com.pokeranch.GV;
import com.pokeranch.MonsterNPC;
import com.pokeranch.ScreenActivity;
import com.pokeranch.ScreenView;

import android.os.Bundle;
import android.util.Log;

public class LuarActivity extends ScreenActivity {
	
	private Vector<MonsterNPC> monsters = new Vector<MonsterNPC>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setId("luar");
		
		ScreenView screen = GV.activeActivity.getScreenView();
		for (int i = 0; i < 6; i++) {
			int x, y;
			do {
				Random rand = new Random();
				Log.d("height", Integer.toString(screen.getHeight()));
				x = rand.nextInt(screen.getMapWidth());
				y = rand.nextInt(screen.getMapHeight());
			} while (screen.getMapId(x, y) != 0 || checkExist(x, y));
			if (i < 2) {
				monsters.add(new MonsterNPC("random", x, y));
			} else if (i < 4) {
				monsters.add(new MonsterNPC("mendekat", x, y));
			} else {
				monsters.add(new MonsterNPC("menjauh", x, y));
			}
		}
		
		super.onCreate(savedInstanceState);
	}
	
	public boolean checkExist(int x, int y) {
		for (int i = 0; i < monsters.size(); i++) {
			if (monsters.elementAt(i).getX() == x && monsters.elementAt(i).getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public void moveMonsters() {
		for (int i = 0; i < monsters.size(); i++) {
			monsters.elementAt(i).move();
		}
	}
	
	public Vector<MonsterNPC> getMonsters() {
		return monsters;
	}

}
