package com.pokeranch;

import com.example.menugan.Player;
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
		Intent i = new Intent();
		GV.player.setPosition(6, 10);
		i = new Intent(getApplicationContext(), Cover.class);
		startActivity(i);
		finish();
	}

}
