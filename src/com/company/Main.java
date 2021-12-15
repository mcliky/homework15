package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        IntList intList = new IntList();
        System.out.println(intList.size());
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(8);
        System.out.println(intList.toString());
        intList.set(2, 10);
        System.out.println(intList.toString());
        System.out.println(intList.size());
        System.out.println(intList.get(1));
        List<String> webList = new ArrayList<>();
        List<String> result = readFromFile("urls.txt", webList);


        Map<String, Integer> map = createMap(result);

        List<Helper> helpers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            helpers.add(new Helper(entry.getKey(), entry.getValue()));
        }

        Collections.sort(helpers, new Comparator<Helper>() {
            @Override
            public int compare(Helper o1, Helper o2) {
                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(helpers.get(i));
        }

    }

    public static Map<String, Integer> createMap(List<String> wordList) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : wordList) {
            if (result.containsKey(word)) {
                int oldCount = result.get(word);
                oldCount++;
                result.put(word, oldCount);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

    private static List<String> readFromFile(String fileName, List<String> webList) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("www.")) {
                    int index = currentLine.indexOf(".");
                    currentLine = currentLine.substring(index + 1, currentLine.length());
                }
                int index = currentLine.indexOf("/");
                currentLine = currentLine.substring(0, index + 1);
                webList.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return webList;
    }
}








