package com.javarush.test.level38.lesson06.home01;

class ExceptionFactory {
    public static Throwable getExceptionsFactory(Enum eEnum) {
       if (eEnum != null) {
           String enumVal = eEnum.name().replaceAll("_", " ");
           String startMess = enumVal.substring(0, 1);
           String endMess = enumVal.substring(1, enumVal.length()).toLowerCase();
           String message = startMess + endMess;

           if (ExceptionApplicationMessage.class.isAssignableFrom(eEnum.getDeclaringClass())) {
               return new Exception(message);
           } else if (ExceptionDBMessage.class.isAssignableFrom(eEnum.getDeclaringClass())) {
               return new RuntimeException(message);
           } else if (ExceptionUserMessage.class.isAssignableFrom(eEnum.getDeclaringClass())) {
               return new Error(message);
           }
       }
        return new IllegalArgumentException();
    }
}