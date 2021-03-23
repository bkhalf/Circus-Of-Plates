package eg.edu.alexu.csd.oop.game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Obj implements GameObject  {
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	protected int x;
	protected int y;
	private boolean visible;
	protected MovingUp movingup;
	protected String mypath;
//	private clown_information subject;
	

	public Obj(int posX, int posY, String path, boolean type){
		this.x = posX;
		this.y = posY;
		this.visible = true;
		
//		this.subjects=subject;
		
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
			mypath=path;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public abstract void setX(int mX) ;

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		if(movingup.move())
		this.y = mY;
	}


	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
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
	
}
