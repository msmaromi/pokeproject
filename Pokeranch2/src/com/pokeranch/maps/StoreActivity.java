package com.pokeranch.maps;

import com.example.menugan.MenuCoy;
import com.example.menuhome.MenuHomeActivity;
import com.example.menustore.MainActivityMenuStore;
import com.pokeranch.R;
import com.pokeranch.ScreenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StoreActivity extends ScreenActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setId("store");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tombol_menu_store, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.menu_store_gan:
				Intent i = new Intent(getApplicationContext(),MainActivityMenuStore.class);
				startActivity(i);
				return true;			
			
			case R.id.menu_utama_gan:
				Intent i2 = new Intent(getApplicationContext(),MenuCoy.class);
				i2.putExtra("posisiSebelum", "store");
				startActivity(i2);
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}
