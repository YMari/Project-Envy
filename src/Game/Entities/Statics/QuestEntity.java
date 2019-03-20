package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Entities.Dynamics.Player;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

public class QuestEntity extends BaseStaticEntity {

	private Rectangle collision;
	private int width, height;

	public QuestEntity(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);

		width = 28*5;
		height = 32*5;

		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		collision = new Rectangle();
	}


	@Override
	public void render(Graphics g) {
		g.drawImage(Images.kirbyNPC,  (int)(handler.getXInWorldDisplacement() + xPosition),(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition + 35), (int)(handler.getYDisplacement() + yPosition + 50), width/4, height/2);
		}

	@Override
	public Rectangle getCollision() {
		return collision;
	}

	@Override
	public double getXOffset() {
		return xPosition;
	}


}



//package Game.Entities.Dynamics;
//
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
//
//import Game.Entities.Dynamics.Player;
//import Main.Handler;
//import Resources.Animation;
//import Resources.Images;
//
//public class QuestEntity extends BaseDynamicEntity {
//
//	private Rectangle collision;
//	private int width, height;
//
//	public QuestEntity(Handler handler, int xPosition, int yPosition,BufferedImage[] animFrames) {
//		super(handler, xPosition, yPosition, animFrames);
////        nextArea = new Rectangle();
////		PEnemyIdle = new Animation(120, animFrames);
//		frames = animFrames;
//
//		width = 28*5;
//		height = 32*5;
//
//		this.setXOffset(xPosition);
//		this.setYOffset(yPosition);
//
//		collision = new Rectangle();
//	}
//
//
//	@Override
//	public void render(Graphics g) {
//		g.drawImage(Images.kirbyNPC, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
//		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition + 35), (int)(handler.getYDisplacement() + yPosition + 50), width/4, height/2);
//		}
//
//	@Override
//	public Rectangle getCollision() {
//		return collision;
//	}
//
//
//
//
//}
