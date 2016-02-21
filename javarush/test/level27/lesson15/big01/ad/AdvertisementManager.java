package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty())
        {
            throw new NoVideoAvailableException();
        }
        else
        {
            Collections.sort(storage.list(), new Comparator<Advertisement>()
            {
                @Override
                public int compare(Advertisement o1, Advertisement o2)
                {
                    int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                    if (result != 0)
                        return -result;
                    long seconds1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    long seconds2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    return Long.compare(seconds1, seconds2);
                }
            });
            int time = timeSeconds;
            for (Advertisement advertisement : storage.list())
            {
                if (time < advertisement.getDuration())
                    continue;
                ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + ", " + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
                time -= advertisement.getDuration();
                advertisement.revalidate();
            }
            if (time == timeSeconds)
            {
                throw new NoVideoAvailableException();
            }
        }
    }


}