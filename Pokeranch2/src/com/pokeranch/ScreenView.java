package com.pokeranch;

import com.pokeranch.model.Player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("ViewConstructor")
public class ScreenView extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = ScreenView.class.getSimpleName();
	public GameLoopThread thread;
	private Matrix matrix;	
	private Paint paint;
	
	protected Player player;
	
	protected ScreenView(Context context, int screenWidth, int screenHeight, Player player) {
		super(context);
		this.player = player;
		
		getHolder().addCallback(this);
		setFocusable(true);
		
		matrix = new Matrix();
		paint = new Paint();
		bitmap = DrawableManager.getInstance().getMapBitmap();
		map = new String[20];
		for (int i = 0; i < map.length; i++) {
			map[i] = "";
			for (int j = 0; j < map[0].length(); j++) {
				map[i] += "0";
			}
		}
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		initThread();
		Log.d(TAG, "surface created");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {		
		releaseThread();
		Log.d(TAG, "surface destroyed");
	}
	
	public void initThread() {
		if (thread == null || !thread.isAlive()) {
			thread = new GameLoopThread(getHolder(), this);
			thread.start();
		}
		thread.setRunning(true);
	}
	 
	private void releaseThread() {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
				thread = null;
			} catch (InterruptedException e) {
			}
		}
	}

	public void render(Canvas canvas) {	
		if (canvas != null && matrix != null) {
			canvas.setMatrix(matrix);
			drawMap(canvas);
		}
	}
	
	public void update() {
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		final int actioncode = event.getAction() & MotionEvent.ACTION_MASK;				
		switch (actioncode) {
			case MotionEvent.ACTION_DOWN:
				Log.d(TAG, "down at " + event.getX() + " " + event.getY());
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d(TAG, "move at " + event.getX() + " " + event.getY());
				break;
			case MotionEvent.ACTION_UP:
				Log.d(TAG, "up at " + event.getX() + " " + event.getY());
				break;		
		}				
		return true;
	}
	
	private Bitmap bitmap;
	
	protected String[] map;
	
	private void drawMap(Canvas canvas) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length(); j++) {
				Rect src = new Rect(0, getMapId(j, i) * 60, 40, (getMapId(j, i) + 1) * 60);
				Rect dst = new Rect(j * 40, i * 40, (j + 1) * 40, (i + 1) * 40);
				canvas.drawBitmap(bitmap, src, dst, paint);
			}
		}
		paint.setColor(Color.BLACK);
		if(player != null) {
			canvas.drawCircle(player.getCurX() * 40 + 20, player.getCurY() * 40 + 20, 20, paint);
		}
		paint.setColor(Color.WHITE);
	}
	
	public int getMapId(int x, int y) {
		return map[y].charAt(x) - 'A';
	}

}
