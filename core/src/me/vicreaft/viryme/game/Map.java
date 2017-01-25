package me.vicreaft.viryme.game;

import me.vicreaft.viryme.OsuReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private HashMap<Integer, Integer> notesData;
    private List<Integer> notesTime = new ArrayList<Integer>();
    private int index;

    public Map(){
        notesData = new HashMap<Integer, Integer>();
    }

    public void loadOsuFile(String osuFile){
        OsuReader osureader = new OsuReader("/root/Desktop/Viryme/core/assets/game/eos/ginkiha - EOS -INFINITE EDIT- (MeowPaz) [Pharos' ADVANCED].osu");
        notesData = osureader.getNotesData();
        notesTime = osureader.getNotesTime();
    }

    public int[] getNextNote(){
        int i = index;
        index++;
        System.out.println("Note " + i + " sur " + notesTime.size());
        return new int[] {notesData.get(notesTime.get(i)), notesTime.get(i)};
    }
}
