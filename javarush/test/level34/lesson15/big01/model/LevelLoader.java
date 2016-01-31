package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
        Set<Wall> wallSet = new HashSet<>();
        wallSet.add(new Wall((Model.FIELD_SELL_SIZE/2)*2,(Model.FIELD_SELL_SIZE/2)*2));
        wallSet.add(new Wall((Model.FIELD_SELL_SIZE/2)*4,(Model.FIELD_SELL_SIZE/2)*4));
        wallSet.add(new Wall((Model.FIELD_SELL_SIZE/2)*6,(Model.FIELD_SELL_SIZE/2)*6));

        Set<Box> boxSet = new HashSet<>();
        boxSet.add(new Box((Model.FIELD_SELL_SIZE/2)*8,(Model.FIELD_SELL_SIZE/2)*8));
        Set<Home> homeSet = new HashSet<>();
        homeSet.add(new Home((Model.FIELD_SELL_SIZE/2)*10,(Model.FIELD_SELL_SIZE/2)*10));
        Player player = new Player((Model.FIELD_SELL_SIZE/2)*12,(Model.FIELD_SELL_SIZE/2)*12);

        return new GameObjects(wallSet,boxSet,homeSet,player);
    }

}
