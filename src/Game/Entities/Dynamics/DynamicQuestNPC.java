package Game.Entities.Dynamics;

import Game.Entities.BaseEntity;
import Game.World.InWorldAreas.TownArea;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DynamicQuestNPC extends BaseDynamicEntity {
	
	private Rectangle collision;
	private Animation blink;
	private int width, height;

	public DynamicQuestNPC(Handler handler, int xPosition, int yPosition, BufferedImage[] animFrames) {
		super(handler, xPosition, yPosition, animFrames);
		
		width = 28*5;
		height = 32*5;
		
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		blink = new Animation(1000, Images.kirbyNPC);   // blinking animation
		collision = new Rectangle();
	}
	
	@Override
	public void tick() {
		blink.tick();
	}
	
	@Override
	public void render(Graphics g) {
		if (TownArea.isInTown == true) {   // render only when in town
		g.drawImage(blink.getCurrentFrame(), (int)(handler.getXInWorldDisplacement() + xPosition),(int)( handler.getYInWorldDisplacement() + yPosition), width, height, null);
		}
	}

	@Override
	public Rectangle getCollision() {
		return collision;
	}
	

}
