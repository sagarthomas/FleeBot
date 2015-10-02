package com.unlimitedstudios.fleebotbeta.utils;

import com.unlimitedstudios.fleebotbeta.enums.PlatformType;

import java.util.Random;

/**
 * Created by Sagar on 2015-09-25.
 */
public class RandomUtils {

    public static PlatformType getRandomPlatformType() {
        RandomEnum<PlatformType> randomEnum = new RandomEnum<PlatformType>(PlatformType.class);
        return randomEnum.random();
    }


    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}
