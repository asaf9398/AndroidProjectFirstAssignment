package com.example.androidprojectfirstassignment;
import android.widget.EditText;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        characterList = new ArrayList<>();
        loadCharacters();

        adapter = new CharacterAdapter(this, characterList);
        recyclerView.setAdapter(adapter);

        EditText searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void loadCharacters() {
        String characterName="Goku";
        String characterDescription="The main protagonist of the series. A Saiyan raised on Earth who is known for his incredible strength, pure heart, and love for martial arts. Goku constantly seeks to improve his skills and protect the world.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.goku));

        characterName="Vegeta";
        characterDescription="The Prince of the Saiyans and Goku's rival. Initially a villain, Vegeta evolves into a complex character who values family and honor, while still striving to surpass Goku.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.vegeta));

        characterName="Gohan";
        characterDescription="Goku's eldest son. A half-Saiyan with immense potential, Gohan balances his peaceful nature with a fierce determination to protect his loved ones.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.gohan));

        characterName="Piccolo";
        characterDescription="A wise and strategic Namekian warrior. Initially Goku's enemy, Piccolo becomes a mentor and father figure to Gohan, contributing significantly to Earth's defense.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.piccolo));

        characterName="Krillin";
        characterDescription="Goku's best friend and a skilled martial artist. Despite being human and less powerful than the Saiyans, Krillin shows immense bravery and loyalty.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.krillin));

        characterName="Bulma";
        characterDescription="A genius inventor and one of Goku's oldest friends. Bulma is instrumental in the group's adventures, often providing gadgets and solutions to complex problems.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.bulma));

        characterName="Trunks";
        characterDescription="Vegeta and Bulma's son. A time traveler from a dystopian future, Trunks is a ";
        characterList.add(new Character(characterName,characterDescription, R.drawable.trunks));

        characterName="Frieza";
        characterDescription="A tyrannical intergalactic overlord and one of Goku's most iconic enemies. Frieza's ruthless quest for power leads to many battles with the Z Fighters.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.frieza));

        characterName="Majin Buu";
        characterDescription="A magical, childlike creature with immense power. Initially a villain, Buu's character transforms as he develops friendships with Earth's inhabitants.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.majin));

        characterName="Android 18";
        characterDescription="A former antagonist created by Dr. Gero, Android 18 later becomes a valuable ally and Krillin's wife. She is strong, independent, and caring.";
        characterList.add(new Character(characterName,characterDescription, R.drawable.and18));


    }

    private void filter(String text) {
        List<Character> filteredList = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(character);
            }
        }
        adapter.filterList(filteredList);
    }
}
