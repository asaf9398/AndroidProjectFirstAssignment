package com.example.androidprojectfirstassignment;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private Context context;
    private List<Character> characterList;

    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.characterName.setText(character.getName());
        holder.characterDescription.setText(character.getDescription());
        holder.characterImage.setImageResource(character.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            showDialog(character);
            Toast.makeText(context, "Selected: " + character.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void filterList(List<Character> filteredList) {
        characterList = filteredList;
        notifyDataSetChanged();
    }

    private void showDialog(Character character) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_character);

        ImageView dialogCharacterImage = dialog.findViewById(R.id.dialogCharacterImage);
        TextView dialogCharacterName = dialog.findViewById(R.id.dialogCharacterName);
        TextView dialogCharacterDescription = dialog.findViewById(R.id.dialogCharacterDescription);

        dialogCharacterImage.setImageResource(character.getImageResId());
        dialogCharacterName.setText(character.getName());
        dialogCharacterDescription.setText(character.getDescription());

        dialog.show();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView characterName, characterDescription;
        ImageView characterImage;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.characterName);
            characterDescription = itemView.findViewById(R.id.characterDescription);
            characterImage = itemView.findViewById(R.id.characterImage);
        }
    }
}
