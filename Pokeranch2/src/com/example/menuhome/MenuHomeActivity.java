package com.example.menuhome;

import com.example.drivermenu.DriverActivity;
import com.example.menugan.Player;
//import com.example.menugan.R;
import com.pokeranch.GV;
import com.pokeranch.R;
import com.pokeranch.maps.HomeActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuHomeActivity extends Activity {

	private Player playerHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		playerHome = GV.player;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

	public void klikSleep(View v){
		for(int i=0;i<playerHome.listMonster.size();i++){
			playerHome.listMonster.get(i).fullRecoverHPMP();			
		}
		
		//waktu jadi pagi 6.00 
		
		GV.player = playerHome;
	}//end klik

	public void klikBackFromHome(View v){
		GV.player = playerHome;
		Intent i = new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(i);
	}
	
	
	
}//end class
