package me.vicreaft.viryme.game;

import java.util.ArrayList;
import java.util.List;

public class FireEvents {

    private List<VirymeListener> listeners = new ArrayList<VirymeListener>();

    public void addListener(VirymeListener toAdd) {
        listeners.add(toAdd);
    }

    public void noteDestruct(Note note, int column) {
        // Notify everybody that may be interested.
        for (VirymeListener hl : listeners)
            hl.onNoteDestruct(note, column);
    }
}