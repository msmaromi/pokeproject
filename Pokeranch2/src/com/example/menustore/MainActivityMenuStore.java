package com.example.menustore;

import com.example.drivermenu.DriverActivity;
//import com.example.menugan.R;
import com.pokeranch.R;
import com.example.menugan.Item;
import com.example.menugan.Player;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivityMenuStore extends Activity{

	private Player playerDiMenu;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        playerDiMenu = new Player();
        playerDiMenu = DriverActivity.playerDriver;
//        playerDiMenu.setNama("a");
//        playerDiMenu.setUang(10000);
        
//        Item i = new Item(100,"Potion");
//        Item i2 = new Item(500,"Monster Ball");
//        Item i3 = new Item(1000,"Monster Egg");
//        Item i4 = new Item(1000,"Monster Egg");
//        Item i5 = new Item(1000,"Monster Egg");
//        Item i6 = new Item(1000,"Monster Egg");
//        Item i7 = new Item(1000,"Monster Egg");
//        Item i8 = new Item(1000,"Monster Egg");
//        Item i9 = new Item(1000,"Monster Egg");
//        Item i10 = new Item(1000,"Monster Egg");
//        Item i11= new Item(100,"Potion");
//        Item i12= new Item(100,"Potion");
//        playerDiMenu.addItem(i);
//        playerDiMenu.addItem(i2); 
//        playerDiMenu.addItem(i3); 
//        playerDiMenu.addItem(i4);
//        playerDiMenu.addItem(i5);
//        playerDiMenu.addItem(i6);
//        playerDiMenu.addItem(i7);
//        playerDiMenu.addItem(i8);
//        playerDiMenu.addItem(i9);
//        playerDiMenu.addItem(i10);
//        playerDiMenu.addItem(i11);
//        playerDiMenu.addItem(i12);
        
        setContentView(R.layout.activity_main_activity_menu_store);
        
        TextView status = (TextView)findViewById(R.id.statusPlayer);

        
        
//        String duit = this.getIntent().getStringExtra("duit");
//        int duit = this.getIntent().getIntExtra("duit", 2);
//        playerDiMenu.setUang(duit);
//        if(duit!=null){
        	status.setText(""+playerDiMenu.getUang());
//        }else{
//        	int statusUang = playerDiMenu.getUang();
//            String stringUang = "duit = "+statusUang+"";        
//            status.setText(stringUang);
//        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_activity_menu_store, menu);
        return true;
    }
    
    public void klikBackToGameFromStore(View v){
    	DriverActivity.playerDriver=playerDiMenu;
    	Intent i = new Intent(getApplicationContext(),DriverActivity.class);    	    	
//    	i.putExtra("duit", playerDiMenu.getUang());    	
    	startActivity(i);
    }
    
    public void klikBackFromBuy(View v){
    	setContentView(R.layout.activity_main_activity_menu_store);
    	 TextView status = (TextView)findViewById(R.id.statusPlayer);

         int statusUang = playerDiMenu.getUang();
         String stringUang = ""+statusUang+"";
         
         status.setText(stringUang);
    }
    
    public void klikBuy(View v) {
		setContentView(R.layout.list_item_buy);
		
	}
    
    public void klikSell(View v) {
		setContentView(R.layout.list_item_sell);
		LinearLayout layoutBtnBack = (LinearLayout) findViewById(R.id.layoutBtnBackStoreXML);
    	layoutBtnBack.setOrientation(LinearLayout.VERTICAL);

    	LinearLayout layoutBtnItem = (LinearLayout)findViewById(R.id.layoutBtnItemStoreXML);
    	layoutBtnItem.setOrientation(LinearLayout.VERTICAL);
    	
    	int maxItemSize = playerDiMenu.listItem.size(); 
    	Button [] arrayBtnItem= new Button[maxItemSize];
    	
    	for (int i=0;i<maxItemSize;i++){
    		arrayBtnItem[i]=new Button(this);
    		arrayBtnItem[i].setText(playerDiMenu.listItem.get(i).getNama());
    		
    		if(playerDiMenu.listItem.get(i).getNama()=="Potion"){
	    		arrayBtnItem[i].setOnClickListener(new OnClickListener() {				
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						playerDiMenu.sell(new Item(100,"Potion"));					
					}
				});
    		}
    		else if(playerDiMenu.listItem.get(i).getNama()=="Monster Ball"){
	    		arrayBtnItem[i].setOnClickListener(new OnClickListener() {				
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						playerDiMenu.sell(new Item(500,"Monster Ball"));					
					}
				});
    		}
    		else if(playerDiMenu.listItem.get(i).getNama()=="Monster Egg"){
	    		arrayBtnItem[i].setOnClickListener(new OnClickListener() {				
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						playerDiMenu.sell(new Item(1000,"Monster Egg"));					
					}
				});
    		}
    		else if(playerDiMenu.listItem.get(i).getNama()=="Stat Permanen Increase"){
	    		arrayBtnItem[i].setOnClickListener(new OnClickListener() {				
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						playerDiMenu.sell(new Item(200,"Stat Permanen Increase"));					
					}
				});
    		}
    		
    		
    		layoutBtnItem.addView(arrayBtnItem[i]);
    		
    	}
    	
    	Button btnItemBack = new Button(this);
    	btnItemBack.setText("Back");    
    	    	
    	btnItemBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_main_activity_menu_store);
		        
				TextView status = (TextView)findViewById(R.id.statusPlayer);

		        int statusUang = playerDiMenu.getUang();
		        String stringUang = "duit = "+statusUang+"";
		        
		        status.setText(stringUang);
			}
		});    		    	

    	layoutBtnBack.addView(btnItemBack);   
	}//end klik sell
    
    
    public void buyPotion(View v){
    	Item potion = new Item(100,"Potion");
    	playerDiMenu.buy(potion);
    }
    
    public void buyMonsterBall(View v){
    	Item potion = new Item(500,"Monster Ball");
    	playerDiMenu.buy(potion);
    }
    
    public void buyMonsterEgg(View v){
    	Item potion = new Item(1000,"Monster Egg");
    	playerDiMenu.buy(potion);
    }
    
    public void buyStatPermanenIncrease(View v){
    	Item potion = new Item(300,"Stat Permanen Increase");
    	playerDiMenu.buy(potion);
    }
    
}//end activity
