package com.example.drivermenu;

import java.io.Serializable;

import com.example.menucombinatorium.MenuCombinatorium;
import com.example.menugan.Item;
import com.example.menugan.MenuCoy;
import com.example.menugan.Monster;
import com.example.menugan.MonsterBall;
import com.example.menugan.MonsterEgg;
import com.example.menugan.Player;
import com.example.menugan.Potion;
import com.pokeranch.R;
import com.example.menuhome.MenuHomeActivity;
import com.example.menustore.MainActivityMenuStore;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class DriverActivity extends Activity {

//	Player playerDiMenu;
	public static Player playerDriver;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(playerDriver==null){
			playerDriver = new Player();
			playerDriver.setNama("player driver");
			Item i = new Potion();
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
	        playerDriver.addItem(i);
	        playerDriver.addItem(i2); 
	        playerDriver.addItem(i3); 
	        playerDriver.addItem(i4);
	        playerDriver.addItem(i5);
	        playerDriver.addItem(i6);
	        playerDriver.addItem(i7);
	        playerDriver.addItem(i8);
	        playerDriver.addItem(i9);
	        playerDriver.addItem(i10);
	        playerDriver.addItem(i11);
	        playerDriver.addItem(i12);
	        playerDriver.addItem(i13);
	        
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
	        
	        playerDriver.addMonster(m1);	        
	        playerDriver.addMonster(m2);
	        playerDriver.addMonster(m3);
	        playerDriver.addMonster(m4);
	        playerDriver.addMonster(new Monster("a"));
	        playerDriver.addMonster(m5);
	        playerDriver.addMonster(m6);
		}//end if
		
		setContentView(R.layout.activity_driver);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_driver, menu);
		return true;
	}

	public void klikDriverUtama(View v){
//		int duitPlayer = this.getIntent().getIntExtra("duit", playerDiMenu.getUang());
		Intent i = new Intent(getApplicationContext(),MenuCoy.class);
//		i.putExtra("duit", duitPlayer);
		
		
//		i.putExtra("player", playerDiMenu);
		
//		Intent i = new Intent(this,MenuCoy.class);
//		Player player = new Player();
//		i.putExtra("player", player);
//		
		startActivity(i);
	}
	
	public void klikDriverStore(View v){
//		int duitPlayer = this.getIntent().getIntExtra("duit", playerDiMenu.getUang());		
		Intent i = new Intent(getApplicationContext(),MainActivityMenuStore.class);
//		i.putExtra("duit", duitPlayer);
		startActivity(i);
	}

	public void klikDriverComb(View v){
		Intent i = new Intent(getApplicationContext(),MenuCombinatorium.class);
		startActivity(i);
	}
		
	public void klikDriverHome(View v){
		Intent i = new Intent(getApplicationContext(),MenuHomeActivity.class);
		startActivity(i);
	}
	
	
}//end class
