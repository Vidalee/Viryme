package me.vicreaft.viryme;


import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OsuReader {

    public OsuReader() {

    }

    public static void main(String[] args) {

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
                    System.out.print("\n");
                    for (int i = 0; i<data.length; i++){
                        System.out.print(data[i] + ",");

                    }
                }

                if(data[0].equalsIgnoreCase("[HitObjects]")) passed = true;



            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}