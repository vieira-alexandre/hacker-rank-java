package dev.alexandrevieira.advanced.c07_can_you_access_private;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;


class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private


            Class<?> innerClass = Inner.class;
            Constructor<?> innerConstructor = innerClass.getDeclaredConstructor();
            innerConstructor.setAccessible(true);
            Object innerObject = innerConstructor.newInstance();

            Class<?> privateClass = innerClass.getDeclaredClasses()[0];
            Constructor<?> declaredConstructor = privateClass.getDeclaredConstructor(innerClass);
            declaredConstructor.setAccessible(true);
            o = declaredConstructor.newInstance(innerObject);

            Method powerof2method = privateClass.getDeclaredMethod("powerof2", int.class);
            powerof2method.setAccessible(true);

            System.out.print(num + " is ");
            String result = (String) powerof2method.invoke(o, num);
            System.out.println(result);

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}	