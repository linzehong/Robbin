package com.cvte.game.game.cell;

import com.badlogic.gdx.graphics.Color;


public class CellData {

	
//	public final static int CELL_WIDTH = 160;//方块宽
	
//	public static final Color WHITE = new Color(1, 1, 1, 1);
//	public static final Color BLACK = new Color(0, 0, 0, 1);
//	public static final Color RED = new Color(1, 0, 0, 1);
//	public static final Color GREEN = new Color(0, 1, 0, 1);
//	public static final Color BLUE = new Color(0, 0, 1, 1);
//	public static final Color LIGHT_GRAY = new Color(0.75f, 0.75f, 0.75f, 1);
//	public static final Color GRAY = new Color(0.5f, 0.5f, 0.5f, 1);
//	public static final Color DARK_GRAY = new Color(0.25f, 0.25f, 0.25f, 1);
//	public static final Color PINK = new Color(1, 0.68f, 0.68f, 1);
//	public static final Color ORANGE = new Color(1, 0.78f, 0, 1);
//	public static final Color YELLOW = new Color(1, 1, 0, 1);
//	public static final Color MAGENTA = new Color(1, 0, 1, 1);
//	public static final Color CYAN = new Color(0, 1, 1, 1);
//	public static final Color OLIVE = new Color(0.5f, 0.5f, 0, 1);
//	public static final Color PURPLE = new Color(0.5f, 0, 0.5f, 1);
//	public static final Color MAROON = new Color(0.5f, 0, 0, 1);
//	public static final Color TEAL = new Color(0, 0.5f, 0.5f, 1);
//	public static final Color NAVY = new Color(0, 0, 0.5f, 1);
	
	//颜色类型
	public final static int COLOR_TYPE_0_YELLOW = 0;//黄色
	public final static int COLOR_TYPE_1_RED = 1;//红色
	public final static int COLOR_TYPE_2_BULE = 2;//蓝色
	public final static int COLOR_TYPE_3_ORANGE = 3;//橙色
	public final static int COLOR_TYPE_4_GREEN = 4;//绿色
	
	//关卡布关数据表
	//-1 表示为空，其他值表示在关卡对应的颜色表中的索引
	private final static int[][] LEVEL_TABLE_LV_0 = {
		{1, 1, -1},
		{-1, -1, 0},
		{1, -1, 1},
	};
	//关卡用到的颜色类型表
	private final static int[] COLOR_TYPE_TABLE_LV_0 = {
		COLOR_TYPE_0_YELLOW, COLOR_TYPE_1_RED
	};
	
	private final static int[][] LEVEL_TABLE_LV_1 = {
		{1, 1, -1, 1},
		{0, -1, 0, 2},
		{1, 1, -1, 2},
		{2, 2, 2, -1},
	};
	private final static int[] COLOR_TYPE_TABLE_LV_1 = {
		COLOR_TYPE_2_BULE, COLOR_TYPE_3_ORANGE, COLOR_TYPE_4_GREEN
	};
	
	
	public static int[][] getLevelTable() {
		return LEVEL_TABLE_LV_1;
	}
	
	public static int[] getColorTypeTable() {
		return COLOR_TYPE_TABLE_LV_1;
	}
	
	public static Color getColorWithType(int colorType) {
		Color color = Color.CLEAR;
		switch (colorType) {
		case CellData.COLOR_TYPE_0_YELLOW:
			color = Color.YELLOW;
			break;
		case CellData.COLOR_TYPE_1_RED:
			color = Color.RED;
			break;
		case COLOR_TYPE_2_BULE:
			color = Color.BLUE;
			break;
		case COLOR_TYPE_3_ORANGE:
			color = Color.ORANGE;
			break;
		case COLOR_TYPE_4_GREEN:
			color = Color.GREEN;
			break;
		}
		return color;
	}
	
}
