package com.oasisdrinks.app.utils.general;

import java.util.*;
import java.io.*;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class CacheUtils {
    private static String CACHE_FILE = "cache.dat";
    private File pathToCache;

    public CacheUtils() {
        this.pathToCache = getPathToCache();
    }

    private File getPathToCache() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(CACHE_FILE).getFile());
        //File file = null;
        //if (classLoader.getResource(CACHE_FILE) == null)
        //    // File file = new File(classLoader.getResource(CACHE_FILE).getFile());
        //if (!file.exists())
        //    file.createNewFile();
        //    .getFile());
        return file;
    }

    public void storeCache(Map<String, List<?>> cache) {
        try (FileOutputStream fileOut = new FileOutputStream(this.pathToCache);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            
            objectOut.writeObject(cache);
            System.out.println("HashMap serialized successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public Map<String, List<?>> loadCache () {
         Map<String, List<?>> hashMap = null;

         try (FileInputStream fileIn = new FileInputStream(this.pathToCache);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            
            hashMap = (HashMap<String, List<?>>) objectIn.readObject();
            
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
         return hashMap;

    }
    
}
