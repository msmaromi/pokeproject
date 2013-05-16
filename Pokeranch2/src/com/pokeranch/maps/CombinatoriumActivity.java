package com.pokeranch.maps;

import com.example.menucombinatorium.MenuCombinatorium;
import com.example.menugan.MenuCoy;
import com.example.menuhome.MenuHomeActivity;
import com.pokeranch.R;
import com.pokeranch.ScreenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CombinatoriumActivity extends ScreenActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setId("combinatorium");
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tombol_comb_gan, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.menu_comb_gan:
				Intent i = new Intent(getApplicationContext(),MenuCombinatorium.class);
				startActivity(i);
				return true;			
				
			case R.id.menu_utama_gan:
				Intent i2 = new Intent(getApplicationContext(),MenuCoy.class);
				i2.putExtra("posisiSebelum", "combinatorium");
				startActivity(i2);
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	
}
