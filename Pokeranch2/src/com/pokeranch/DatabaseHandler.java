package com.pokeranch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.pokeranch.model.Item;
import com.pokeranch.model.Monster;
import com.pokeranch.model.Player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.method.MovementMethod;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {	
	private static DatabaseHandler mInstance = null;
	
    private static final int DATABASE_VERSION = 2; 
    private static final String DATABASE_NAME = "pokeranch.db"; 
    public static final String TABLE_PLAYERS = "players";
    public static final String TABLE_MONSTERS = "monters";
    public static final String TABLE_ITEMS = "items"; 
 
    //atribut tabel player
    private static final String KEY_ID = "id";
    private static final String KEY_PLAYER_NAME = "player_name";
    private static final String KEY_TIME = "time";
    private static final String KEY_MONEY = "money";
    private static final String KEY_NUMBER_WIN = "number_win";
    private static final String KEY_NUMBER_LOSE = "number_lose";
    private static final String KEY_NUMBER_ESCAPE = "number_escape"; 
    private static final String KEY_CURRENT_X = "current_x";
    private static final String KEY_CURRENT_Y = "current_y";
    private static final String KEY_PLAYER_COLOR = "player_color";
    //...
    
    //atribut tabel monster
    private static final String KEY_MONSTER_NAME = "monster_name";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_EXPERIENCE = "experience";
    private static final String KEY_SPECIES = "species";
    private static final String KEY_ELEMENT = "element";
    private static final String KEY_HP = "hp";
    private static final String KEY_MP = "mp";
    private static final String KEY_SPEED = "speed";
    private static final String KEY_BONUS_MONEY = "bonus_money";
    private static final String KEY_BONUS_EXPERIENCE = "bonus_experience";
    private static final String KEY_CURRENT_HP = "current_hp";
    private static final String KEY_CURRENT_MP = "current_mp";
    private static final String KEY_STATUS = "status";
    private static final String KEY_AGE = "age";
    
    //atribut tabel item
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_NUMBER = "number";
 
    public static DatabaseHandler getInstance(Context context) {
    	if(mInstance == null) {
    		mInstance = new DatabaseHandler(context);
    	}
    	return mInstance;    	
    }
    
    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
    	Log.d("debug", "masuk");
        String createTablePlayer = 
        		"CREATE TABLE IF NOT EXISTS " + TABLE_PLAYERS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
                + KEY_PLAYER_NAME + " TEXT,"
                + KEY_TIME + " INTEGER,"
                + KEY_MONEY + " INTEGER,"
                + KEY_NUMBER_WIN + " INTEGER,"
                + KEY_NUMBER_LOSE + " INTEGER," 
                + KEY_NUMBER_ESCAPE + " INTEGER,"
                + KEY_CURRENT_X + " INTEGER,"
                + KEY_CURRENT_Y + " INTEGER,"
                + KEY_PLAYER_COLOR + " TEXT"
                + ")";
        String createTableMonster = 
                "CREATE TABLE IF NOT EXISTS " + TABLE_MONSTERS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PLAYER_NAME + " TEXT,"
                + KEY_MONSTER_NAME + " TEXT,"
                + KEY_LEVEL + " INTEGER,"
                + KEY_EXPERIENCE + " INTEGER,"
                + KEY_SPECIES + " TEXT,"
                + KEY_ELEMENT + " TEXT,"
                + KEY_HP + " INTEGER,"
                + KEY_MP + " INTEGER,"
                + KEY_SPEED + " INTEGER,"
                + KEY_BONUS_MONEY + " INTEGER,"
                + KEY_BONUS_EXPERIENCE + " INTEGER,"
                + KEY_CURRENT_HP + " INTEGER,"
                + KEY_CURRENT_MP + " INTEGER,"
                + KEY_STATUS + " TEXT,"
                + KEY_AGE + " INTEGER"
                + ")";
        String createTableItem =
                "CREATE TABLE IF NOT EXISTS " + TABLE_ITEMS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PLAYER_NAME + " TEXT,"
                + KEY_ITEM_NAME + " TEXT,"
                + KEY_PRICE + " INTEGER,"
                + KEY_NUMBER + " INTEGER"
                //...
                + ")";
               
        db.execSQL(createTablePlayer);
        db.execSQL(createTableMonster);
        db.execSQL(createTableItem);  
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
    	db.execSQL("DROP TABLE IF EXISTS " + TABLE_MONSTERS);
    	db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    } 
    
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
 
    /*
     * method2 untuk player
     */
    public void addPlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getNama().toLowerCase());
        values.put(KEY_TIME, player.getWaktu());
        values.put(KEY_MONEY, player.getUang());
        values.put(KEY_NUMBER_WIN, player.getJumlahMenang());
        values.put(KEY_NUMBER_LOSE, player.getJumlahKalah());
        values.put(KEY_NUMBER_ESCAPE, player.getJumlahEscape());
        values.put(KEY_CURRENT_X, player.getCurX());
        values.put(KEY_CURRENT_Y, player.getCurY());
        values.put(KEY_PLAYER_COLOR, player.getWarnaPlayer());
        //...
 
        db.insert(TABLE_PLAYERS, null, values);
        db.close(); 
    }
 
    public Player getPlayer(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_PLAYERS, new String[] { 
                KEY_PLAYER_NAME,                 
                KEY_MONEY,
                KEY_CURRENT_X,
                KEY_CURRENT_Y,
                KEY_NUMBER_WIN,
                KEY_NUMBER_LOSE,
                KEY_NUMBER_ESCAPE,
                KEY_TIME,               
                KEY_PLAYER_COLOR                
                //...
                }, KEY_ID + "=?",
                new String[] { id }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
                
        Player player = new Player(
        		cursor.getString(0),
        		Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), 
                Integer.parseInt(cursor.getString(3)), 
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),                
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)),
                cursor.getString(8),
                getListMonsterByPlayer(cursor.getString(0)),
                getListItemByPlayer(cursor.getString(0))
                );
        db.close(); 
        
        return player;
    }    
    
    public ArrayList<Player> getAllPlayer() {    	
    	ArrayList<Player> players = new ArrayList<Player>();    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor cursor = db.query(TABLE_PLAYERS, new String[] { 
    			KEY_PLAYER_NAME,                 
                KEY_MONEY,
                KEY_CURRENT_X,
                KEY_CURRENT_Y,
                KEY_NUMBER_WIN,
                KEY_NUMBER_LOSE,
                KEY_NUMBER_ESCAPE,
                KEY_TIME,               
                KEY_PLAYER_COLOR                
                //...
                //...
                }, null,
                null, null, null, null, null);
    	
    	cursor.moveToFirst();
    	if(cursor.getCount() > 0) {
    		while(!cursor.isLast()) {
        		Player player = new Player(
        				cursor.getString(0),
                		Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)), 
                        Integer.parseInt(cursor.getString(3)), 
                        Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)),                
                        Integer.parseInt(cursor.getString(6)),
                        Integer.parseInt(cursor.getString(7)),
                        cursor.getString(8),
                        getListMonsterByPlayer(cursor.getString(0)),
                        getListItemByPlayer(cursor.getString(0))
                        );
            	players.add(player);
            	cursor.move(1);
        	}
    		Player player = new Player(
    				cursor.getString(0),
            		Integer.parseInt(cursor.getString(1)),
                    Integer.parseInt(cursor.getString(2)), 
                    Integer.parseInt(cursor.getString(3)), 
                    Integer.parseInt(cursor.getString(4)),
                    Integer.parseInt(cursor.getString(5)),                
                    Integer.parseInt(cursor.getString(6)),
                    Integer.parseInt(cursor.getString(7)),
                    cursor.getString(8),
                    getListMonsterByPlayer(cursor.getString(0)),
                    getListItemByPlayer(cursor.getString(0))
                    );
        	players.add(player);
    	}    	
    	db.close();
    	return players;
    }
 
    public void updatePlayer(String id, Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getNama());
        values.put(KEY_TIME, player.getWaktu());
        values.put(KEY_MONEY, player.getUang());
        values.put(KEY_NUMBER_WIN, player.getJumlahMenang());
        values.put(KEY_NUMBER_LOSE, player.getJumlahKalah());
        values.put(KEY_NUMBER_ESCAPE, player.getJumlahEscape());
        values.put(KEY_CURRENT_X, player.getCurX());
        values.put(KEY_CURRENT_Y, player.getCurY());
        values.put(KEY_PLAYER_COLOR, player.getWarnaPlayer());
        //...
        db.update(TABLE_PLAYERS, values, KEY_ID + " LIKE ?",
                new String[] { id });
        db.close();
    }
 
    public void deletePlayer(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLAYERS, KEY_ID + " = ?",
                new String[] { id });
        db.close();
    }
    
    public Boolean isPlayerExists(String name) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.query(TABLE_PLAYERS, new String[] {KEY_ID}, KEY_PLAYER_NAME + " = ?", new String[] {name.toLowerCase()}, null, null, null);
    	cursor.moveToFirst();
    	if(cursor.getCount() == 0)
    		return false;    	
    	return true;
    }
    
    /*
     * method2 untuk monster
     */
   public void addMonster(Player player, Monster monster) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getNama().toLowerCase());
        values.put(KEY_MONSTER_NAME, monster.getNama().toLowerCase());
        values.put(KEY_LEVEL, monster.getLevel());
        values.put(KEY_EXPERIENCE, monster.getExp());
        values.put(KEY_SPECIES, monster.getSpecies());
        values.put(KEY_ELEMENT, monster.getElemen());
        values.put(KEY_HP, monster.getHP());
        values.put(KEY_MP, monster.getMP());
        values.put(KEY_SPEED, monster.getSpeed());
        values.put(KEY_BONUS_MONEY, monster.getBonusUang());
        values.put(KEY_BONUS_EXPERIENCE, monster.getBonusExp());
        values.put(KEY_CURRENT_HP, monster.getCurrentHP());
        values.put(KEY_CURRENT_MP, monster.getCurrentMP());
        values.put(KEY_STATUS, monster.getStatus());
        values.put(KEY_AGE, monster.getUmur());
        //...
 
        db.insert(TABLE_MONSTERS, null, values);
        db.close(); 
    }
     
    public Monster getMonster(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_MONSTERS, new String[] { 
                KEY_MONSTER_NAME, 
                KEY_LEVEL,
                KEY_EXPERIENCE,
                KEY_SPECIES,
                KEY_ELEMENT,
                KEY_HP,
                KEY_MP,
                KEY_SPEED,
                KEY_BONUS_MONEY,
                KEY_BONUS_EXPERIENCE,
                KEY_CURRENT_HP,
                KEY_CURRENT_MP,
                KEY_STATUS,
                KEY_AGE
                //...
                }, KEY_ID + "=?",
                new String[] { id }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        
        Monster monster = new Monster(
        		cursor.getString(0),	//nama monster
        		Integer.parseInt(cursor.getString(1)),	//level
                Integer.parseInt(cursor.getString(2)), 	//experience
                cursor.getString(3), 	//species
                cursor.getString(4),	//elemen
                Integer.parseInt(cursor.getString(5)),	//hp
                Integer.parseInt(cursor.getString(6)),	//mp
                Integer.parseInt(cursor.getString(7)),	//speed
                Integer.parseInt(cursor.getString(8)), 	//bonus uang
                Integer.parseInt(cursor.getString(9)),	//bonus experience
                Integer.parseInt(cursor.getString(10)),	//current x
                Integer.parseInt(cursor.getString(11)),	//current y
                cursor.getString(12),	//status
                Integer.parseInt(cursor.getString(13))
                );
        db.close();        
        return monster;
    }
    
    public void updateMonster(String id, Monster monster) {
    	
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MONSTER_NAME, monster.getNama());
        values.put(KEY_LEVEL, monster.getLevel());
        values.put(KEY_EXPERIENCE, monster.getExp());
        values.put(KEY_SPECIES, monster.getSpecies());
        values.put(KEY_ELEMENT, monster.getElemen());
        values.put(KEY_HP, monster.getHP());
        values.put(KEY_MP, monster.getMP());
        values.put(KEY_SPEED, monster.getSpeed());
        values.put(KEY_BONUS_MONEY, monster.getBonusUang());
        values.put(KEY_BONUS_EXPERIENCE, monster.getBonusExp());
        values.put(KEY_CURRENT_HP, monster.getCurrentHP());
        values.put(KEY_CURRENT_MP, monster.getCurrentMP());
        values.put(KEY_STATUS, monster.getStatus());
        values.put(KEY_AGE, monster.getUmur());
        //...
        db.update(TABLE_MONSTERS, values, KEY_ID + " LIKE ?",
                new String[] { id });
        db.close();
    }
    
    public void deleteMonster(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MONSTERS, KEY_ID + " = ?",
                new String[] { id });
        db.close();
    }
    
    public ArrayList<Monster> getListMonsterByPlayer(String name) {    	
    	ArrayList<Monster> listMonster = new ArrayList<Monster>();    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor cursor = db.query(TABLE_MONSTERS, new String[] { 
                KEY_MONSTER_NAME, 
                KEY_LEVEL,
                KEY_EXPERIENCE,
                KEY_SPECIES,
                KEY_ELEMENT,
                KEY_HP,
                KEY_MP,
                KEY_SPEED,
                KEY_BONUS_MONEY,
                KEY_BONUS_EXPERIENCE,
                KEY_CURRENT_HP,
                KEY_CURRENT_MP,
                KEY_STATUS,
                KEY_AGE
                //...
                }, KEY_PLAYER_NAME + "=?",
                new String[] { name.toLowerCase() }, null, null, null, null);
    	
    	if(cursor.getCount()>0) {
    		cursor.moveToFirst();
        	while(!cursor.isLast()) {
        		Monster monster = new Monster(
                		cursor.getString(0),	//nama monster
                		Integer.parseInt(cursor.getString(1)),	//level
                        Integer.parseInt(cursor.getString(2)), 	//experience
                        cursor.getString(3), 	//species
                        cursor.getString(4),	//elemen
                        Integer.parseInt(cursor.getString(5)),	//hp
                        Integer.parseInt(cursor.getString(6)),	//mp
                        Integer.parseInt(cursor.getString(7)),	//speed
                        Integer.parseInt(cursor.getString(8)), 	//bonus uang
                        Integer.parseInt(cursor.getString(9)),	//bonus experience
                        Integer.parseInt(cursor.getString(10)),	//current x
                        Integer.parseInt(cursor.getString(11)),	//current y
                        cursor.getString(12),	//status
                        Integer.parseInt(cursor.getString(13))
                        );
            	listMonster.add(monster);
            	cursor.move(1);
        	}
        	Monster monster = new Monster(
            		cursor.getString(0),	//nama monster
            		Integer.parseInt(cursor.getString(1)),	//level
                    Integer.parseInt(cursor.getString(2)), 	//experience
                    cursor.getString(3), 	//species
                    cursor.getString(4),	//elemen
                    Integer.parseInt(cursor.getString(5)),	//hp
                    Integer.parseInt(cursor.getString(6)),	//mp
                    Integer.parseInt(cursor.getString(7)),	//speed
                    Integer.parseInt(cursor.getString(8)), 	//bonus uang
                    Integer.parseInt(cursor.getString(9)),	//bonus experience
                    Integer.parseInt(cursor.getString(10)),	//current x
                    Integer.parseInt(cursor.getString(11)),	//current y
                    cursor.getString(12),	//status
                    Integer.parseInt(cursor.getString(13))
                    );
        	listMonster.add(monster);
    	}    	
    	
    	db.close();
    	return listMonster;
    }
    
    /*
     * method2 untuk item
     */
    public void addItem(Player player, Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getNama().toLowerCase());
        values.put(KEY_ITEM_NAME, item.getNama().toLowerCase());
        values.put(KEY_PRICE, item.getHarga());        
        //...
 
        db.insert(TABLE_ITEMS, null, values);
        db.close(); 
    } 
    
    public Item getItem(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { 
        		KEY_PRICE, 
                KEY_ITEM_NAME               
                //...
                }, KEY_ID + "=?",
                new String[] { id }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Item item = new Item(
        		Integer.parseInt(cursor.getString(0)),
        		cursor.getString(1)
                );
        db.close();        
        return item;
    }
    
    public void updateItem(String id, Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ITEM_NAME, item.getNama());
        values.put(KEY_PRICE, item.getHarga());
        //...
        db.update(TABLE_ITEMS, values, KEY_ID + " LIKE ?",
                new String[] { id });
        db.close();
    }
    
    public void deleteItem(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[] { id });
        db.close();
    }
    
    public ArrayList<Item> getListItemByPlayer(String name) {    	
    	ArrayList<Item> listItem = new ArrayList<Item>();
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	 Cursor cursor = db.query(TABLE_ITEMS, new String[] { 
                 KEY_PRICE, 
                 KEY_ITEM_NAME               
                 //...
                 }, KEY_PLAYER_NAME + "=?",
                 new String[] { name.toLowerCase() }, null, null, null, null);
    	
    	if(cursor.getCount()>0) {
    		cursor.moveToFirst();
        	while(!cursor.isLast()) {
        		Item item = new Item(
                		Integer.parseInt(cursor.getString(0)),
                		cursor.getString(1)
                        );
            	listItem.add(item);
            	cursor.move(1);
        	}
        	Item item = new Item(
            		Integer.parseInt(cursor.getString(0)),
            		cursor.getString(1)
                    );
        	listItem.add(item);
    	}    	
    	
    	db.close();
    	return listItem;
    }
    
    /*
     * method2 lain
     */
    public String getIDbyName(String table, String name) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = null;
    	if(table == TABLE_PLAYERS) {
    		cursor = db.query(table, new String[] {KEY_ID}, KEY_PLAYER_NAME + " = ?", new String[] {name.toLowerCase()}, null, null, null);
    	} else if(table == TABLE_MONSTERS) {
    		cursor = db.query(table, new String[] {KEY_ID}, KEY_MONSTER_NAME + " = ?", new String[] {name.toLowerCase()}, null, null, null);
    	} else if(table == TABLE_ITEMS) {
    		cursor = db.query(table, new String[] {KEY_ID}, KEY_ITEM_NAME + " = ?", new String[] {name.toLowerCase()}, null, null, null);
    	}
    	
    	cursor.moveToFirst();
    	db.close();
    	return cursor.getString(0);
    }
    
    public String getLastID(String table) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.query(table, new String[] {KEY_ID}, "MAX(" + KEY_ID + ")", null, null, null, null);
    	cursor.moveToFirst();
    	db.close();
    	return cursor.getString(0);
    }
}