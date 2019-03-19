package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.util.ArrayList;

import Game.Entities.EntityManager;
import Game.World.Walls;

public class TownArea extends BaseArea {

    Rectangle exit;
    Rectangle playerRect;
    public static boolean isInTown = false;

    private int imageWidth = 2155, imageHeight = 2000;
    public final static int playerXSpawn = -380, playerYSpawn = -10;

    private Rectangle background = new Rectangle(3000, 3000);

    public static ArrayList<InWorldWalls> townWalls;

    public TownArea(Handler handler, EntityManager entityManager) {
        super(handler, entityManager);
        name="Town";
        handler.setXInWorldDisplacement(playerXSpawn);
        handler.setYInWorldDisplacement(playerYSpawn);

        playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

        this.entityManager = entityManager;

        

//        this.entityManager.AddEntity(handler.newEnemy(Images.PEnemyIdle,handler,700, 2000,"InWorldState","Sergio","Cave","EnemyOne",150,25,80,1,8,12,20,10,20,10,1,10,"None","Thunder",null,null)); //lvl 2 difficulty
//        this.entityManager.AddEntity(handler.newEnemy(Images.PEnemyIdle,handler,3000, 1000,"InWorldState","Cave Dweller","Cave","EnemyOne",100,25,60,10,1,12,20,10,20,13,1,10,"None","Thunder",null,null)); // lvl 1 difficulty

//        this.entityManager.AddEntity(new LightStatue (handler, 2080, 1770));
        
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

//        gotta do the same but for "scaled town"
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


    }

    @Override
    public ArrayList<InWorldWalls> getWalls() {
        return townWalls;
    }
}




