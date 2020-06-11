package com.example.testapp.ui.skills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.testapp.MainActivity;
import com.example.testapp.R;
import com.example.testapp.lists.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SkillsFragment extends Fragment {

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExpandableListAdapter listAdapter;
        ExpandableListView expandableListView;

        View root = inflater.inflate(R.layout.fragment_skills, container, false);

        expandableListView = root.findViewById(R.id.skills_list);
        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        expandableListView.setAdapter(listAdapter);

        return root;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Human");
        listDataHeader.add("Elf");
        listDataHeader.add("DarkElf");
        listDataHeader.add("Orc");
        listDataHeader.add("Dwarf");
        listDataHeader.add("Kamael");

        List<String> humanFirstProfessions= new ArrayList<String>();
        humanFirstProfessions.add("Warrior");
        humanFirstProfessions.add("Human Knight");
        humanFirstProfessions.add("Rogue");
        humanFirstProfessions.add("Wizard");
        humanFirstProfessions.add("Cleric");

        List<String> elfFirstProfessions = new ArrayList<>();
        elfFirstProfessions.add("Elven Knight");
        elfFirstProfessions.add("Elven Scout");
        elfFirstProfessions.add("Elven Wizard");
        elfFirstProfessions.add("Elven Oracle");

        List<String> darkElfFirstProfessions = new ArrayList<>();
        darkElfFirstProfessions.add("Palus Knight");
        darkElfFirstProfessions.add("Assassin");
        darkElfFirstProfessions.add("Dark Wizard");
        darkElfFirstProfessions.add("Shillien Oracle");

        List<String> orcFirstProfessions = new ArrayList<>();
        orcFirstProfessions.add("Orc Raider");
        orcFirstProfessions.add("Monk");
        orcFirstProfessions.add("Orc Mystic");

        List<String> dwarfFirstProfessions = new ArrayList<>();
        dwarfFirstProfessions.add("Scavenger");
        dwarfFirstProfessions.add("Artisan");

        List<String> kamaelFirstProfessions = new ArrayList<>();
        kamaelFirstProfessions.add("Trooper");
        kamaelFirstProfessions.add("Warder");

        listDataChild.put(listDataHeader.get(0), humanFirstProfessions);
        listDataChild.put(listDataHeader.get(1), elfFirstProfessions);
        listDataChild.put(listDataHeader.get(2), darkElfFirstProfessions);
        listDataChild.put(listDataHeader.get(3), orcFirstProfessions);
        listDataChild.put(listDataHeader.get(4), dwarfFirstProfessions);
        listDataChild.put(listDataHeader.get(5), kamaelFirstProfessions);



    }
}
