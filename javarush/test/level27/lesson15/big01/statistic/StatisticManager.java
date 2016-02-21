package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private StatisticManager() {
    }

    public static StatisticManager getInstance() {

        return instance;
    }
    public void register(EventDataRow data){


    }


    private class StatisticStorage {
            private Map<EventType, List<EventDataRow>> map = new HashMap<>();
            private StatisticStorage() {
                for (EventType type : EventType.values()) {
                    map.put(type, new ArrayList<EventDataRow>());
                }
            }

        }
}
