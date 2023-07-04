package com.oasisdrinks.app.utils.general;

import java.util.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class CacheUtils {
    private static String CACHE_FILE = "cache.dat";
    private File cacheFile;

    public CacheUtils() {
        this.cacheFile = getPathToCache();
    }

    private File getPathToCache() {
        File file = new File(CACHE_FILE);
        return file;
    }

    public void storeCache(Map<String, List<?>> cache) {
        try (FileOutputStream fileOut = new FileOutputStream(this.cacheFile);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            
            objectOut.writeObject(cache);
            System.out.println("HashMap serialized successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public Map<String, List<?>> loadCache () {
         Map<String, List<?>> hashMap = null;

         try (FileInputStream fileIn = new FileInputStream(this.cacheFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            
            hashMap = (HashMap<String, List<?>>) objectIn.readObject();
            
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
         return hashMap;

    }
    
}
