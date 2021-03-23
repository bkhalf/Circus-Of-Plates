package eg.edu.alexu.csd.oop.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shape implements GameObject,gettingPath{
	
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	protected int x;
	protected int y;
	private boolean visible;
	protected String mypath;
	private int where=5;

	public void doit() {
		x=450;
		 y=0;
		 visible=true;
		 mypath="/java"+ (int)(1 + Math.random() * 3)+".png";
		 try {
				spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(mypath));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public String getpath() {
		String sub=mypath.substring(1,6);
		return sub;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX) {
		if((mX>=1000-120&&where==0)|| (mX<=80&&where==1) )return;
		this.x=mX;
	}

	public void setWhere(int n) {
		this.where=n;
	}
	@Override
	public int getY() {
		
		return y;
	}

	@Override
	public void setY(int y) {
		if(where==5)
		this.y=y;
	}

	@Override
	public int getWidth() {
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return  spriteImages;
	}

}
