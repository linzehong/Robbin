package com.cvte.game.game.Btn;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.cvte.game.game.cell.CellManager;

public class BtnManager extends Group {
	private static BtnManager instance;
	
	private Btn[][] mBtns;
	
	
	public static BtnManager getInstance() {
		if (instance == null) {
			instance = new BtnManager();
		}
		return instance;
	}
	
	public static BtnManager getInstanceValue()  {
		return instance;
	}
	
	private BtnManager() {
		int btnNumInLine = CellManager.getInstance().getCellNumInLine();
		int btnWidth = CellManager.getInstance().getCellWidth()>>1;
		int dir = Btn.DIR_L2R;
		int btnX;
		int btnY;
		
		mBtns = new Btn[2][btnNumInLine];
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < btnNumInLine; ++j) {
				mBtns[i][j] = new Btn();
				addActor(mBtns[i][j]);
			
				dir = (i == 0) ? (Btn.DIR_L2R) : (Btn.DIR_D2U);
				mBtns[i][j].init(btnWidth, dir);
				
				if (i == 0) {
					btnX = 200;
					btnY = 100;
				}
				else {
					btnX = 200;
					btnY = 200;
				}
				mBtns[i][j].setPosition(btnX, btnY);
			}
		}
		
		
	}
	
	public void dispose() {
		if (mBtns != null) {
			int length = mBtns.length;
			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length; ++j) {
					if (mBtns[i][j] != null) {
						mBtns[i][j].dispose();
						mBtns[i][j] = null;
					}
				}
			}
			mBtns = null;
		}
		
		instance = null;
	}
	
	
	
	
}
