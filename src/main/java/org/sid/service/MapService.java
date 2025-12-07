package org.sid.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MapService {

    /*
    if the key "a" has a value, set the key "b" to have that value, and set the key "a" to have the value "".
    Basically "b" is a bully, taking the value and replacing it with the empty string.
     */
    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.containsKey("a") && map.get("a") != null) {
            map.put("b", map.get("a"));
            map.replace("a", "");
        }
        return map;
    }

    /*
    if the key "a" has a value, set the key "b" to have that same value.
    In all cases remove the key "c", leaving the rest of the map unchanged.
     */
    public Map<String, String> mapShare(Map<String, String> map) {
        if (map.containsKey("a") && map.get("a") != null) {
            map.put("b", map.get("a"));
        }
        map.remove("c");
        return map;
    }

    /*
    The map may or may not contain the "a" and "b" keys.
    If both keys are present, append their 2 string values together and store the result under the key "ab".
     */
    public Map<String, String> mapAB(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", map.get("a")+ map.get("b"));
        }
        return map;
    }

    /*
    if the keys "a" and "b" are both in the map and have equal values, remove them both.
     */
    public Map<String, String> mapAB2(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b") && map.get("a").equals(map.get("b"))) {
           map.remove("a");
           map.remove("b");
        }
        return map;
    }

    /*
    if the keys "a" and "b" have values that have different lengths, then set "c" to have the longer value.
    If the values exist and have the same length, change them both to the empty string in the map.
     */
    public Map<String, String> mapAB4(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            int lengthA = map.get("a").length();
            int lengthB = map.get("b").length();
            if(lengthA == lengthB) {
                map.replace("a","");
                map.replace("b","");
            }else {
                map.put("c", lengthA > lengthB ? map.get("a"): map.get("b"));
            }
        }
        return map;
    }

    /*
    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array,
        always with the value 0. For example the string "hello" makes the pair "hello":0.
     We'll do more complicated counting later, but for this problem the value is simply 0.
     */
    public Map<String, Integer> word0(String[] strings) {
        final Map<String, Integer> result= new HashMap<>();
        Arrays.stream(strings).forEach(str -> result.put(str,0));
        return result;
    }

    public Map<String, Integer> wordLength(String[] strings) {
        final Map<String, Integer> result= new HashMap<>();
        Arrays.stream(strings).forEach(str -> result.put(str,str.length()));
        return result;
    }

    /*
    Given an array of non-empty strings, create and return a Map<String, String> as follows:
     for each string add its first character as a key with its last character as the value.
     */
    public Map<String, String> pairs(String[] strings) {
        final Map<String, String> result= new HashMap<>();
        Arrays.stream(strings)
                .forEach(str -> result.put(str.substring(0,1),str.substring(str.length()-1)));
        return result;
    }

    /*
    Given an array of strings, return a Map<String, Boolean> where each different string is a key
        and its value is true if that string appears 2 or more times in the array.
     */
    public Map<String, Boolean> wordMultiple(String[] strings) {
        final Map<String, Boolean> result= new HashMap<>();
        Arrays.stream(strings)
                .forEach(str -> {
                    if(result.containsKey(str)) result.put(str,true);
                    else result.put(str,false);
                });
        return result;
    }

    /*
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows:
        if a string matches an earlier string in the array, swap the 2 strings in the array.
        When a position in the array has been swapped, it no longer matches anything.
         Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap(String[] strings) {
        final Map<String, Integer> mapMatch= new HashMap<>();
     IntStream.range(0, strings.length)
             .forEach(i-> {
                 String firstChar = strings[i].substring(0, 1);
                 if(mapMatch.containsKey(firstChar)){
                     Integer firstCharPosition = mapMatch.get(firstChar);
                     swap(strings, i,firstCharPosition);
                     mapMatch.remove(firstChar);
                 }else
                    mapMatch.put(firstChar, i);

             });
        return strings;
    }

    private void swap(String[] tab, int firstPosition,  int secondPosition){
        final String swapContainer = tab[firstPosition];
        tab[firstPosition] = tab[secondPosition];
        tab[secondPosition] = swapContainer;
    }
     public boolean exists(int [] ints, int k){
        return Arrays.stream(ints)
                .parallel()
                .anyMatch(item -> item == k);
     }





}
