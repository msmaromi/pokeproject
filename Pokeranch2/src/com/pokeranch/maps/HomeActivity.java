package com.pokeranch.maps;

import com.example.menugan.Player;
import com.pokeranch.DatabaseHandler;
import com.pokeranch.GV;
import com.pokeranch.ScreenActivity;

import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends ScreenActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle extras = getIntent().getExtras();
		
		if(extras.getString("statusSwitch").equals("load")) {
			GV.player = GV.dbHandler.getPlayer(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, extras.getString("loadPlayerName")));

		} else if(extras.getString("statusSwitch").equals("new")) {
			Log.d("d", extras.getString("newPlayerName"));
			GV.player = new Player(extras.getString("newPlayerName"));
			GV.player.setPosition(6, 9);
			Log.d("d", GV.player.getNama());
			// player.setCurX(2);
		}
		setId("home");
		super.onCreate(savedInstanceState);
	}

}
