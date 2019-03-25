package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.util.ArrayList;

import Game.Entities.EntityManager;
import Game.Entities.Dynamics.DynamicQuestNPC;
import Game.Entities.Statics.LightStatue;
import Game.World.Walls;

public class TownArea extends BaseArea {

    Rectangle exit;
    Rectangle playerRect;
    public static boolean isInTown = false;

    private int imageWidth = 2155, imageHeight = 2000;
    public final static int playerXSpawn = -380, playerYSpawn = -10;

    private Rectangle background = new Rectangle(2500, 2500);

    public static ArrayList<InWorldWalls> townWalls;

    public TownArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Town";
        handler.setXInWorldDisplacement(playerXSpawn);
        handler.setYInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

        this.entityManager = entityManager;


        this.entityManager.AddEntity(new DynamicQuestNPC(handler, 1450, 1300, null));
        
        townWalls = new ArrayList<>();
        AddWalls();

    }

    public void tick() {
        super.tick();

        for (Walls w : townWalls) {
            w.tick();
        }
        if(!GameSetUp.LOADING) {
            entityManager.tick();
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);


        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.fill(background);

        g.drawImage(Images.ScaledTown, handler.getXInWorldDisplacement(), handler.getYInWorldDisplacement(), null);

        if (GameSetUp.DEBUGMODE) {
            for (Walls w : townWalls) {

                if (w.getType().equals("Wall"))
                    g2.setColor(Color.black);
                else
                    g2.setColor(Color.PINK);

                w.render(g2);
            }
        }


        entityManager.render(g);

    }

    private void AddWalls() {

    	// Top Walls
    	townWalls.add(new InWorldWalls(handler, 0, 0, 925, 200, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1225, 0, 925, 200, "Wall"));
    	
    	// Bottom Walls
    	townWalls.add(new InWorldWalls(handler, 0, 1475, 930, 500, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 930, 1900, 850, 450, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1540, 1765, 930, 400, "Wall"));
    	
    	// Side Walls
    	townWalls.add(new InWorldWalls(handler, 0, 0, 125, 2000, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 2015, 0, 200, 2000, "Wall"));
    	
    	// House Walls
    	townWalls.add(new InWorldWalls(handler, 375, 375, 500, 360, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1250, 375, 500, 360, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1250, 910, 545, 415, "Wall"));
    	
    	// Fence Walls
    	townWalls.add(new InWorldWalls(handler, 440, 1050, 405, 60, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1250, 1600, 540, 60, "Wall"));
    	
    	// Exit
    	townWalls.add(new InWorldWalls(handler, 925, 0, 300, 180, "Exit"));
    	
    	// QuestEntity Wall
    	townWalls.add(new InWorldWalls(handler, 1450, 1300, 28*5, 32*5, "Wall"));
    	townWalls.add(new InWorldWalls(handler, 1425, 1275, 28*5 + 50, 32*5 + 50, "Quest"));   // detection radius for the quest prompt


    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return townWalls;
    }
}




