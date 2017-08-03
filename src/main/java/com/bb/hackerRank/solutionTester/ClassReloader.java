package com.bb.hackerRank.solutionTester;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassReloader {

    /**
     * Tries to reload the given class
     *
     * @param clazz the class to be reloaded
     * @return new Class instance in case of a successful reload, otherwise the original instance
     */
    public Class<?> reloadClass(Class<?> clazz) {
        try {
            URL[] classPath = {clazz.getProtectionDomain().getCodeSource().getLocation()};
            URLClassLoader classLoader = new URLClassLoader(classPath, clazz.getClassLoader().getParent());
            return classLoader.loadClass(clazz.getName());
        }
        catch (Exception e) {
            return clazz;
        }
    }
}