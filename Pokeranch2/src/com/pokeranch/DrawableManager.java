package com.pokeranch;

import java.util.Random;

import com.pokeranch.R;

//import com.labpro.game.ember.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class DrawableManager{
	
	/**
	 * construct pake aplication context
	 * @param context
	 */
	private Resources res;
	private DrawableManager(Context context) {
		// TODO ganti gambar
		res = context.getResources();
		rand = new Random();
	}
	
	/**
	 * must be called only once
	 * @param context
	 */
	public static void initInstance(Context context) {
		assert instance == null;
		instance = new DrawableManager(context);
	}
	
	/**
	 * must have called initInstance() before
	 * @return
	 */
	public static DrawableManager getInstance() {
		assert instance != null;
		return instance;
	}
	
	public Bitmap getMapBitmap() {
		if (map == null) {
			map = BitmapFactory.decodeResource(res, R.drawable.map);
		}
		return map;
	}
	
	private static DrawableManager instance;
	private Bitmap map;
	public final Random rand; 	
}
