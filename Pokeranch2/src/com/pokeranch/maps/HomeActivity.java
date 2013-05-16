package com.pokeranch.maps;

import com.example.menugan.MenuCoy;
import com.example.menugan.Player;
import com.example.menuhome.MenuHomeActivity;
import com.pokeranch.DatabaseHandler;
import com.pokeranch.GV;
import com.pokeranch.R;
import com.pokeranch.ScreenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends ScreenActivity {
	
	private static Bundle extras;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if(extras == null) {
		extras = getIntent().getExtras();
		
		if(extras.getString("statusSwitch").equals("load")) {
			GV.player = GV.dbHandler.getPlayer(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, extras.getString("loadPlayerName")));

		} else if(extras.getString("statusSwitch").equals("new")) {
			Log.d("d", extras.getString("newPlayerName"));
			GV.player.setNama(extras.getString("newPlayerName"));
			GV.player.setPosition(6, 9);
			Log.d("d", GV.player.getNama());
			// player.setCurX(2);
		}
		}
		setId("home");
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tombol_menu_home, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {	
				
			case R.id.menu_utama_gan:
				Intent i2 = new Intent(getApplicationContext(),MenuCoy.class);
				i2.putExtra("posisiSebelum", "home");
				startActivity(i2);
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
}
