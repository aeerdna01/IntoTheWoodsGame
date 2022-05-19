package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {
    /// Referinte catre elementele grafice (dale) utilizate in joc.

    static boolean passed = false;
    static long now;
    static long then;
    static boolean monster_passed = false;
    static long monster_then, monster_now;

    public static BufferedImage[] hero_walk_down;
    public static BufferedImage[] hero_walk_up;
    public static BufferedImage[] hero_walk_left;
    public static BufferedImage[] hero_walk_right;

    public static BufferedImage[] chimera_walk_down;
    public static BufferedImage[] chimera_walk_up;
    public static BufferedImage[] chimera_walk_left;
    public static BufferedImage[] chimera_walk_right;


    public static BufferedImage[] hero_attack_down;
    public static BufferedImage[] hero_attack_up;
    public static BufferedImage[] hero_attack_left;
    public static BufferedImage[] hero_attack_right;


    public static BufferedImage monster1;


    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_play;
    public static BufferedImage[] btn_back;


    //level1
    public static BufferedImage tree1;
    public static BufferedImage tree2;
    public static BufferedImage tree3;
    public static BufferedImage tree4;


    //level1
    public static BufferedImage stone;
    public static BufferedImage water;
    public static BufferedImage grass;
    public static BufferedImage bush1;
    public static BufferedImage bush2;
    public static BufferedImage bush3;
    public static BufferedImage wood;
    public static BufferedImage flower1;
    public static BufferedImage flower2;
    public static BufferedImage edge;
    public static BufferedImage soilP;
    public static BufferedImage soilT;
    public static BufferedImage mushroom1;
    public static BufferedImage mushroom2;

    //level2
    public static BufferedImage lvl2grass;
    public static BufferedImage lvl2stone;
    public static BufferedImage verticalBoard;
    public static BufferedImage damagedVerticalBoard;
    public static BufferedImage horizontalBoard;
    public static BufferedImage damagedHorizontalBoard;
    public static BufferedImage lvl2bush1;
    public static BufferedImage lvl2bush2;
    public static BufferedImage lvl2woods;



    public static BufferedImage blueDiamond;
    public static BufferedImage heart;

    public static BufferedImage sword;

    public static BufferedImage menu1;
    public static BufferedImage intro;
    public static BufferedImage help;

    public static BufferedImage gameover;
    public static BufferedImage level2unlocked;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet hero = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/cavaler_walk.png"), 64, 64);
        SpriteSheet hero_attack = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/cavaler_attack.png"), 192, 180);
        SpriteSheet enemy_lvl1_walk = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/chimera_walk.png"), 64, 64);
        SpriteSheet level1 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/level1.png"), 32, 32);
        SpriteSheet level2 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/level2.png"), 32, 32);


        /// Se obtin subimaginile corespunzatoare elementelor necesare.

        btn_start = new BufferedImage[2];
        btn_start[0] = ImageLoader.LoadImage("/textures/buttons/buttonPlayN.png");
        btn_start[1] = ImageLoader.LoadImage("/textures/buttons/buttonPlayP.png");

        btn_back = new BufferedImage[2];
        btn_back[0] = ImageLoader.LoadImage("/textures/buttons/backN.png");
        btn_back[1] = ImageLoader.LoadImage("/textures/buttons/backP.png");


        monster1 = enemy_lvl1_walk.crop(0, 1);

        hero_walk_down = new BufferedImage[9];
        hero_walk_up = new BufferedImage[9];
        hero_walk_right = new BufferedImage[9];
        hero_walk_left = new BufferedImage[9];
        for (int i = 0; i < 9; i++)
            hero_walk_left[i] = hero.crop(i, 1);
        for (int i = 0; i < 9; i++)
            hero_walk_right[i] = hero.crop(i, 3);
        for (int i = 0; i < 9; i++)
            hero_walk_up[i] = hero.crop(i, 0);
        for (int i = 0; i < 9; i++)
            hero_walk_down[i] = hero.crop(i, 2);

        chimera_walk_down = new BufferedImage[7];
        chimera_walk_up = new BufferedImage[7];
        chimera_walk_right = new BufferedImage[7];
        chimera_walk_left = new BufferedImage[7];
        for (int i = 0; i < 7; i++)
            chimera_walk_left[i] = enemy_lvl1_walk.crop(i, 1);
        for (int i = 0; i < 7; i++)
            chimera_walk_right[i] = enemy_lvl1_walk.crop(i, 3);
        for (int i = 0; i < 7; i++)
            chimera_walk_up[i] = enemy_lvl1_walk.crop(i, 0);
        for (int i = 0; i < 7; i++)
            chimera_walk_down[i] = enemy_lvl1_walk.crop(i, 2);



        hero_attack_left = new BufferedImage[6];
        hero_attack_right = new BufferedImage[6];
        hero_attack_up = new BufferedImage[6];
        hero_attack_down = new BufferedImage[6];
        for (int i = 0; i < 6; i++)
            hero_attack_left[i] = hero_attack.crop(i, 1);
        for (int i = 0; i < 6; i++)
            hero_attack_right[i] = hero_attack.crop(i, 3);
        for (int i = 0; i < 6; i++)
            hero_attack_up[i] = hero_attack.crop(i, 0);
        for (int i = 0; i < 6; i++)
            hero_attack_down[i] = hero_attack.crop(i, 2);

        edge = level1.crop(0, 0);
        grass = level1.crop(2, 3);
        water = level1.crop(1, 0);
        wood = level1.crop(0, 1);
        bush1 = level1.crop(0, 2);
        bush2 = level1.crop(0, 3);
        bush3 = level1.crop(1, 2);
        stone = level1.crop(1, 3);
        flower1 = level1.crop(0, 4);
        flower2 = level1.crop(1, 4);
        mushroom1 = level1.crop(0, 5);
        mushroom2 = level1.crop(1, 5);
        soilP = level1.crop(1, 1);
        soilT = level1.crop(2, 0);

        lvl2grass = level2.crop(1,0);
        lvl2stone = level2.crop(0,0);
        verticalBoard = level2.crop(0,1);
        damagedVerticalBoard = level2.crop(1,1);
        horizontalBoard = level2.crop(0,2);
        damagedHorizontalBoard = level2.crop(1,2);
        lvl2bush1 = level2.crop(0,3);
        lvl2bush2 = level2.crop(0,4);
        lvl2woods = level2.crop(0,5);

        tree1 = ImageLoader.LoadImage("/textures/objects/tree1.png");
        tree2 = ImageLoader.LoadImage("/textures/objects/tree2.png");
        tree3 = ImageLoader.LoadImage("/textures/objects/tree3.png");
        tree4 = ImageLoader.LoadImage("/textures/objects/tree4.png");

        blueDiamond = ImageLoader.LoadImage("/textures/objects/blueDiamond.png");
        heart = ImageLoader.LoadImage("/textures/objects/heart.png");

        sword = ImageLoader.LoadImage("/textures/objects/sword.png");

        menu1 = ImageLoader.LoadImage("/textures/menu/menu1.png");
        intro = ImageLoader.LoadImage("/textures/menu/menu2.png");
        help = ImageLoader.LoadImage("/textures/menu/help.png");
        gameover = ImageLoader.LoadImage("/textures/menu/gameover.png");
        level2unlocked = ImageLoader.LoadImage("/textures/menu/level2unlocked.png");

    }

    public static boolean attackTimeElapsed() {
        if (!passed) {
            then = System.nanoTime();
            passed = true;
        }
        now = System.nanoTime();
        if (now - then > 1000000000 / 0.7) {
            passed = false;
            return true;
        }
        return false;
    }
}
