package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        ((TextView) listItemView.findViewById(R.id.englishTextView)).setText(currentWord.getDefaultTranslation());
        ((TextView) listItemView.findViewById(R.id.miwokTextView)).setText(currentWord.getMiwokTranslation());

        if (currentWord.getImageResourceId() > 0) {
            ((ImageView) listItemView.findViewById(R.id.image)).setImageResource(currentWord.getImageResourceId());
        } else {
            listItemView.findViewById(R.id.image).setVisibility(View.GONE);
        }

        return listItemView;
    }
}
