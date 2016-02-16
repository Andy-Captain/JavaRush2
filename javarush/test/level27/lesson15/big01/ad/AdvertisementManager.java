package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = storage.list();
        List<Advertisement> expensiveAdvertisiments = new ArrayList<>();
        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                return -result;
            }
        });
        int timeLeft = timeSeconds;
        for(Advertisement advertisement : advertisements) {
            if(timeLeft <= 0)
                break;
            if(advertisement.getDuration() <= timeLeft) {
                expensiveAdvertisiments.add(advertisement);
                timeLeft -= advertisement.getDuration();
            }
        }
        if(expensiveAdvertisiments.isEmpty())
            throw new NoVideoAvailableException();
        Collections.sort(expensiveAdvertisiments, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;
                long amountPerSec1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long amountPerSec2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                return Long.compare(amountPerSec1, amountPerSec2);
            }
        });
        for(Advertisement advertisement : expensiveAdvertisiments) {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %s, %s",
                    advertisement.getName(), advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
                advertisement.revalidate();
        }

    }

}