package com.pokeranch;

import java.util.HashMap;

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
	private Bitmap bitmap;
	private String id;
	
	protected static HashMap<String, String[]> map;
	
	protected ScreenView(Context context, int screenWidth, int screenHeight, String id) {
		super(context);
		this.id = id;
		
		getHolder().addCallback(this);
		setFocusable(true);
		
		matrix = new Matrix();
		paint = new Paint();
		bitmap = DrawableManager.getInstance().getMapBitmap();
		
		map = new HashMap<String, String[]>();
		
		map.put("city", new String[] {
				"CCCCCCCCCCCC",
				"CBBBAAACAAAC",
				"CBKBAAAAACAC",
				"CAAAACAAAAAC",
				"CCAAAAAAAAAC",
				"CAACABLBAAAC",
				"CAAAABBBAAAO",
				"CAAACBBBCAAC",
				"CAAACCACAAAC",
				"CAAAAAAAACAC",
				"CAAABBBBAAAC",
				"CACAMBBBAAAC",
				"CAAABBBBAAAC",
				"CAAAACAAAAAC",
				"CCAAAAAAAAAC",
				"CAABBBBACAAC",
				"CAABBBNAAACC",
				"CAABBBBACAAC",
				"CCAAACAAAAAC",
				"CCCCCCCCCCCC"
			});
		
		map.put("home", new String[] {
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZFFFFFFFFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFFFFPFFFZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ"
			});
		
		map.put("store", new String[] {
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZFFFQFFFFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFEEEEEEFZZ",
				"ZZFFFFFFFFZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ"
			});
		
		map.put("combinatorium", new String[] {
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"FFFFFFFFFFFF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"REEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FFFFFFFFFFFF",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ"
			});
		
		map.put("stadium", new String[] {
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"FFFFFFFFFFFF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEES",
				"FEEEEEEEEEEF",
				"FEEEEEEEEEEF",
				"FFFFFFFFFFFF",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ",
				"ZZZZZZZZZZZZ"
			});
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
	
	private void drawMap(Canvas canvas) {
		for (int i = 0; i < map.get(id).length; i++) {
			for (int j = 0; j < map.get(id)[0].length(); j++) {
				if (getMapId(j, i) == 25) {
					paint.setColor(Color.BLACK);
					canvas.drawRect(j * 40, i * 40, (j + 1) * 40, (i + 1) * 40, paint);
				} else {
					Rect src = new Rect(0, getMapId(j, i) * 60, 40, (getMapId(j, i) + 1) * 60);
					Rect dst = new Rect(j * 40, i * 40, (j + 1) * 40, (i + 1) * 40);
					canvas.drawBitmap(bitmap, src, dst, paint);
				}
			}
		}
		paint.setColor(Color.BLACK);
		if(GV.player != null) {
			canvas.drawCircle(GV.player.getX() * 40 + 20, GV.player.getY() * 40 + 20, 20, paint);
		}
		paint.setColor(Color.WHITE);
	}
	
	public int getMapId(int x, int y) {
		return map.get(id)[y].charAt(x) - 'A';
	}
	
	public int getMapWidth() {
		return map.get(id)[0].length();
	}
	
	public int getMapHeight() {
		return map.get(id).length;
	}

}
