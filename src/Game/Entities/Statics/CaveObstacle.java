package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Entities.Dynamics.Player;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

public class CaveObstacle extends BaseStaticEntity {

	private Rectangle collision;
	private int width, height;

	public CaveObstacle(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);

		width = 88;
		height = 56;

		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		collision = new Rectangle();
	}


	@Override
	public void render(Graphics g) {
		if (handler.getWorldManager().removeObstacle == false) {
			g.drawImage(Images.BPie, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
			collision = new Rectangle((int)(handler.getXDisplacement() + xPosition + 35), (int)(handler.getYDisplacement() + yPosition + 50), width/4, height/2);
		}
		else {
		}
	}

	@Override
	public Rectangle getCollision() {
		return collision;
	}




}
