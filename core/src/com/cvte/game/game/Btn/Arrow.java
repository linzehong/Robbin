package com.cvte.game.game.Btn;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cvte.game.Assets;

public class Arrow extends Actor {

	private Sprite mSpArrow;

	private int mDir;//箭头的运动方向

//	public final static int DIR_L2R = 0;//左往右方向
//	public final static int DIR_D2U = 1;//下往上方向
	
	public Arrow() {
		
	}
	
	public void dispose() {
		mSpArrow = null;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		if (mSpArrow != null) {
			mSpArrow.draw(batch);
		}
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		
		if (mSpArrow != null) {
			mSpArrow.setPosition(x, y);
		}
	}

	public void init(int arrowWidth, int dir) {
		
		mDir = dir;
		
		mSpArrow = new Sprite(Assets.getTextureArrow());
		mSpArrow.setScale(arrowWidth / mSpArrow.getHeight());
		
		setBounds(0, 0, mSpArrow.getWidth(), mSpArrow.getHeight());
	}
	
	
}
