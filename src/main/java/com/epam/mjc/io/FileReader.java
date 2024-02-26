package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> profileMap = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] arr = line.split("\\:");
                profileMap.put(arr[0], arr[1]);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
        return new Profile(profileMap.get("Name").trim(), Integer.parseInt(profileMap.get("Age").trim()),
                profileMap.get("Email").trim(), Long.parseLong(profileMap.get("Phone").trim()));
    }
}
