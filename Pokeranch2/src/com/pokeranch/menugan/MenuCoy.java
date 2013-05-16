package com.pokeranch.menugan;

import com.example.menugan.Item;
import com.example.menugan.Monster;
import com.example.menugan.Player;
import com.pokeranch.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MenuCoy extends Activity {
	
	public Player playerDiMenu;	
	String[] fruit_name = {"Monster 1","Monster 2"};
	Integer[] list_image = {R.drawable.ic_launcher, R.drawable.ic_launcher};

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerDiMenu = new Player();
        Item i = new Item(100,"Potion");
        Item i2 = new Item(100,"Monster Ball");
//        Item i3 = new Item(100,"Monster Egg");
//        Item i4 = new Item(100,"Monster Egg");
//        Item i5 = new Item(100,"Monster Egg");
//        Item i6 = new Item(100,"Monster Egg");
//        Item i7 = new Item(100,"Monster Egg");
//        Item i8 = new Item(100,"Monster Egg");
//        Item i9 = new Item(100,"Monster Egg");
//        Item i10 = new Item(100,"Monster Egg");
//        Item i11= new Item(100,"Potion");
//        Item i12= new Item(100,"Potion");
        playerDiMenu.addItem(i);
        playerDiMenu.addItem(i2); 
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
        
        Monster m1 = new Monster("monster 1");
        Monster m2 = new Monster("monster 2");
        Monster m3 = new Monster("monster 3");
        Monster m4 = new Monster("monster 4");
        
        playerDiMenu.addMonster(m1);
        playerDiMenu.addMonster(m2);
        playerDiMenu.addMonster(m3);
        playerDiMenu.addMonster(m4);
        
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_list_item, menu);
        return true;
    }
    
    public void klikBackToGame(View V){
    	setContentView(R.layout.activity_fullscreen);
    }
    
    public void klikItem(View v){
    	setContentView(R.layout.activity_list_item);
//    	setContentView(new ListItemView(getApplicationContext()));    	    
    	
    	
//    	LinearLayout layoutUtama = new LinearLayout(this);
//    	LinearLayout layoutUtama = (LinearLayout) findViewById(R.id.layoutUtamaXML);
//    	layoutUtama.setOrientation(LinearLayout.VERTICAL);
//    	layoutUtama.setGravity(Gravity.BOTTOM);
    	
//    	RelativeLayout layoutUtama = new RelativeLayout(this);
//    	layoutUtama.setLayoutParams(new LayoutParams(1000,1000));    	
    	
//    	LinearLayout layoutBtnBack = new LinearLayout(this);
    	LinearLayout layoutBtnBack = (LinearLayout) findViewById(R.id.layoutBtnBackXML);
    	layoutBtnBack.setOrientation(LinearLayout.VERTICAL);
//    	layoutBtnBack.setGravity(Gravity.BOTTOM);
    	
//    	TableLayout layoutBtnItem = new TableLayout(this);
    	LinearLayout layoutBtnItem = (LinearLayout)findViewById(R.id.layoutBtnItemXML);
    	layoutBtnItem.setOrientation(LinearLayout.VERTICAL);
//    	layoutBtnItem.setGravity(Gravity.TOP);    	    	    	    	
    	
    	int maxItemSize = playerDiMenu.listItem.size(); 
    	Button [] arrayBtnItem= new Button[maxItemSize];
//    	TextView[] arrayTextItem = new TextView[maxItemSize];
//    	TableRow [] arrayRowItem = new TableRow[maxItemSize];
    	
    	for (int i=0;i<maxItemSize;i++){
    		arrayBtnItem[i]=new Button(this);
    		arrayBtnItem[i].setText(playerDiMenu.listItem.get(i).getNama());
//    		arrayTextItem[i]=new TextView(this);
//    		arrayTextItem[i].setText("Jumlah = 1");
//    		arrayBtnItem[i].setWidth();
//    		layoutBtnItem.addView(arrayBtnItem[i]);    		    	
//    		arrayRowItem[i] = new TableRow(this);
//    		arrayRowItem[i].addView(arrayBtnItem[i]);
//    		arrayRowItem[i].addView(arrayTextItem[i]);
//    		layoutBtnItem.addView(arrayRowItem[i]);
    		layoutBtnItem.addView(arrayBtnItem[i]);
    	}
    	
    	Button btnItemBack = new Button(this);
    	btnItemBack.setText("Back");    
    	
    	    	
    	btnItemBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_menu);
			}
		});    		    	

    	layoutBtnBack.addView(btnItemBack);   
//    	layoutUtama.addView(layoutBtnItem);
//    	layoutUtama.addView(layoutBtnBack);
    	
//    	setContentView(layoutUtama);
    }
    
    public void klikMonster(View v){
    	setContentView(R.layout.activity_list_monster);		
    	LinearLayout layoutBtnBack = (LinearLayout) findViewById(R.id.layoutBtnBackXML);
    	layoutBtnBack.setOrientation(LinearLayout.VERTICAL);
    	
    	LinearLayout layoutBtnMonster = (LinearLayout)findViewById(R.id.layoutBtnMonsterXML);
    	layoutBtnMonster.setOrientation(LinearLayout.VERTICAL);
    	
    	int maxMonsterSize = playerDiMenu.listMonster.size(); 
    	Button [] arrayBtnMonster= new Button[maxMonsterSize];    	
    	
    	for (int i=0;i<maxMonsterSize;i++){
    		arrayBtnMonster[i]=new Button(this);
    		arrayBtnMonster[i].setText(playerDiMenu.listMonster.get(i).getNama());
    		layoutBtnMonster.addView(arrayBtnMonster[i]);
    	}
    	
    	Button btnMonsterBack = new Button(this);
    	btnMonsterBack.setText("Back");    
    	
    	    	
    	btnMonsterBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_menu);
			}
		});    		    	

    	layoutBtnBack.addView(btnMonsterBack);   
    }
    
    public void klikPokedex(View v){
    	setContentView(R.layout.activity_pokedex);
    	
    	 Gallery gallery = (Gallery) findViewById(R.id.gallery1);
    	         gallery.setAdapter(new ImageAdapter(this));
    	         gallery.setOnItemClickListener(new OnItemClickListener()
    	         {
    	             public void onItemClick(AdapterView parent,
    	             View v, int position, long id)
    	             {
    	                 Toast.makeText(getBaseContext(),
    	                        fruit_name[position],
    	                         Toast.LENGTH_SHORT).show();
    	             }    	 
    	         });

    }

    public class ImageAdapter extends BaseAdapter{
            private Context context;
            private int itemBackground;

            public ImageAdapter(Context c)
            {
                context = c;

                TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
                itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
                a.recycle();
            }

            public int getCount() {
                return list_image.length;
            }

            public Object getItem(int position) {
                return position;
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(list_image[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
                imageView.setBackgroundResource(itemBackground);
                return imageView;
            }
        }

    
    public void klikBackToMenu(View V){
    	setContentView(R.layout.activity_menu);
    }
    
}//end listitem
