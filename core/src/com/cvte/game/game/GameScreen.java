package com.cvte.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cvte.game.game.Btn.BtnManager;
import com.cvte.game.game.cell.CellManager;

public class GameScreen implements Screen {

	private Stage mStage;
	private BG mBG;
	private CellManager mCellManager;
	private BtnManager mBtnManager;
	
	public GameScreen() {
		
	}
	
	@Override
	public void dispose() {
		if (mStage != null) {
			mStage.dispose();
			mStage = null;
		}
		if (mBG != null) {
			mBG.dispose();
			mBG = null;
		}
		if (mCellManager != null) {
			mCellManager.dispose();
			mCellManager = null;
		}
		if (mBtnManager != null) {
			mBtnManager.dispose();
			mBtnManager = null;
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mStage.act(delta);
		mStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		mStage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {
		mStage = new Stage();
		
		mBG = new BG();
		
		mCellManager = CellManager.getInstance();
		mBtnManager = BtnManager.getInstance();
		
		mStage.addActor(mBG);
		mStage.addActor(mCellManager);
		mStage.addActor(mBtnManager);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
