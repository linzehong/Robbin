package com.cvte.game.game.cell;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.cvte.game.Data;

public class CellManager extends Group {
	private static CellManager instance;

	private Cell[][] mCells;
	
	private int mCellNumInLine;//一行由几个格子组成
	
	private int mCellWidth;//格子的宽
	private int mCellInterval;//格子间的空隙
	
	//格子显示区域
	private final int BOUNDS_WIDTH = 400;//480;
	private final int BOUNDS_HEIGHT = 400;//480;
	private final int BOUNDS_X = (Data.SCREEN_WIDTH - BOUNDS_WIDTH) / 2;
	private final int BOUNDS_Y = 350;
	
	public static CellManager getInstance() {
		if (instance == null) {
			instance = new CellManager();
		}
		return instance;
	}
	
	public static CellManager getInstanceValue() {
		return instance;
	}
	
	private CellManager() {
		int[][] levelTable = CellData.getLevelTable();
		int[] colorTypeTable = CellData.getColorTypeTable();
		
		mCellNumInLine = levelTable.length;
		calcCellWidthAndInterval();
		
		mCells = new Cell[mCellNumInLine][mCellNumInLine];
		
		int colorIndex;
		int colorType;
		int cellX;
		int cellY;
		for (int i = 0; i < mCellNumInLine; ++i) {
			for (int j = 0; j < mCellNumInLine; ++j) {
				mCells[i][j] = new Cell();
				addActor(mCells[i][j]);
				
				colorIndex = levelTable[i][j];
				if (colorIndex != -1) {
					colorType = colorTypeTable[colorIndex];
					
					mCells[i][j].initDefault(colorType, mCellWidth);
					cellX = mCellWidth * j + mCellInterval * (j + 1);
					cellY = mCellWidth * (mCellNumInLine - i - 1) + mCellInterval * (mCellNumInLine - i);
					mCells[i][j].setPosition(cellX, cellY);
				}
			}
		}
		
		setBounds(BOUNDS_X, BOUNDS_Y, BOUNDS_WIDTH, BOUNDS_HEIGHT);
	}
	
	public void dispose() {
		if (mCells != null) {
			int length = mCells.length;
			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length; ++j) {
					if (mCells[i][j] != null) {
						mCells[i][j].dispose();
						mCells[i][j] = null;
					}
				}
			}
			mCells = null;
		}
		
		instance = null;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	/**
	 * 计算获得格子的宽和格子间隔
	 * 每个格子边上都有一个间隔
	 * (格子宽  * 一行格子数) + (间隔宽 * (一行格子数 + 1)) = 显示区宽
	 * 间隔宽 = 格子宽 * 10%
	 */
	private void calcCellWidthAndInterval() {
		mCellWidth = (int)(BOUNDS_WIDTH / (mCellNumInLine * 1.1 + 0.1));
		mCellInterval = (int)(mCellWidth * 0.1);
	}
	
	public int getCellNumInLine() {
		return mCellNumInLine;
	}
	
	public int getCellWidth() {
		return mCellWidth;
	}
	
}
