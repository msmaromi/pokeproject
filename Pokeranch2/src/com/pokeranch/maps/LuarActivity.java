package com.pokeranch.maps;

import java.util.Random;
import java.util.Vector;

import com.example.menugan.MenuCoy;
import com.pokeranch.GV;
import com.pokeranch.MonsterNPC;
import com.pokeranch.R;
import com.pokeranch.ScreenActivity;
import com.pokeranch.ScreenView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tombol_luar_gan, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {			
			case R.id.menu_utama_gan:
				Intent i2 = new Intent(getApplicationContext(),MenuCoy.class);
				i2.putExtra("posisiSebelum", "luar");
				startActivity(i2);
				return true;
				
			case R.id.menu_cut_gan:
				//method cut
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
