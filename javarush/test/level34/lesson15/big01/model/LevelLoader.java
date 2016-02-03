package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        while (level > 60)
        {
            level = level - 60;
        }
        Set<Wall> wallSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Set<Home> homeSet = new HashSet<>();
        Player player = new Player(0,0);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.toString()));
            while(true)
            {
                String lev = reader.readLine();
                if (("Maze: " + level).equals(lev))
                {break;}
            }
              reader.readLine();
            String[] split = reader.readLine().split(" ");
            String[] split2 = reader.readLine().split(" ");

            int width = Integer.parseInt(split[2]);
            int height = Integer.parseInt(split2[2]);
            reader.readLine();
            reader.readLine();
            reader.readLine();

            for (int y = 0; y < height; y++ )
            {
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                for(int x = 0; x < width; x++)
                {
                    char aChar = chars[x];

                    switch (aChar)
                    {
                        case ' ': break;
                        case 'X': wallSet.add(new Wall(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            break;
                        case '*' :
                            boxSet.add(new Box(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            break;
                        case '.':
                            homeSet.add(new Home(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            break;
                        case '&' :
                            boxSet.add(new Box(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            homeSet.add(new Home(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            break;
                        case '@' :
                            player = new Player(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2);
                            break;




                    }



                }


            }



        } catch (IOException e) {
            e.printStackTrace();
        }
       return new GameObjects(wallSet,boxSet,homeSet,player);
    }

}
