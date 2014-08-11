package com.cvte.game.game.Btn;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cvte.game.Assets;

public class Btn extends Actor {

	private Sprite mSpSquare;
	private Arrow mArrow;
	
	private int mSquareWidth;//方块的宽
	private int mDir;//箭头的运动方向
	
	public final static int DIR_L2R = 0;//左往右方向
	public final static int DIR_D2U = 1;//下往上方向

	public Btn() {
		
	}
	
	public void dispose() {
		mSpSquare = null;
		if (mArrow != null) {
			mArrow.dispose();
			mArrow = null;
		}
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		if (mSpSquare != null) {
			mSpSquare.draw(batch);
		}
		if (mArrow != null) {
			mArrow.draw(batch, parentAlpha);
		}
	}
	
	
	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		
		if (mSpSquare != null) {
			mSpSquare.setPosition(x, y);
		}
		if (mArrow != null) {
			mArrow.setPosition(x, y);
		}
	}

	public void init(int squareWidth, int dir) {
		mSquareWidth = squareWidth;
		mDir = dir;
		
		mSpSquare = new Sprite(Assets.getTextureSquare());
		mSpSquare.setSize(mSquareWidth, mSquareWidth);
		mSpSquare.getColor().a = 0.5f;
		
		int arrowWidth = (int)(mSquareWidth * 0.8);
		mArrow = new Arrow();
		mArrow.init(arrowWidth, mDir);
		
		if (mDir == DIR_L2R) {
//			setBounds(0, 0, width, mSquareWidth);
		}
		else {
//			setBounds(0, 0, mSquareWidth, height);
		}
		
	}
	
}
