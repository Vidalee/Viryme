package me.vicreaft.viryme;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OsuReader {
    private static HashMap<Integer, Integer> notes = new HashMap<Integer, Integer>();
    private static List<Integer> notesTime = new ArrayList<Integer>();
    private static int index;
    public OsuReader() {
        index = 0;


        String osuFile = "/root/Desktop/Viryme/core/assets/game/eos/ginkiha - EOS -INFINITE EDIT- (MeowPaz) [Pharos' ADVANCED].osu";
        System.out.println(osuFile);
        String line = "";
        String splitWith = ",";
        boolean passed = false;
        try (BufferedReader br = new BufferedReader(new FileReader(osuFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(splitWith);

                if(passed){

                    notes.put(Integer.parseInt(data[2]), getColumn(Integer.parseInt(data[0]), 4));
                    notesTime.add(Integer.parseInt(data[2]));
                }

                if(data[0].equalsIgnoreCase("[HitObjects]")) passed = true;



            }
            System.out.println(notes.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {



    }

    public int getNextNote(){
        int i = index;
        index++;
        System.out.println("Note " + i + " sur " + notesTime.size());
        return notes.get(notesTime.get(i));
    }
    private static int getColumn(int key, int maxKey){
        if(key == 64) return 0;
        if(key == 192) return 1;
        if(key == 320) return 2;
        if(key == 448) return 3;
        else return key;


    }
}