package com.example.hp.projectbpb_quiz.adater;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.projectbpb_quiz.MainActivity;
import com.example.hp.projectbpb_quiz.R;
import com.example.hp.projectbpb_quiz.model.Quiz;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class QuizListAdapter extends ArrayAdapter<Quiz> {
    private Context mContext;
    private ArrayList<Quiz> mQuiz;
    private int mLayoutResId;


    public QuizListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Quiz> objects) {
        super(context, resource, objects);//////////// textViewResourceID ต่อจาก รีซอร์จ
        this.mContext = context;
        this.mLayoutResId = resource;
        this.mQuiz = objects;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        Quiz item = mQuiz.get(position);

        ImageView img = itemLayout.findViewById(R.id.imageViewList);
        TextView name = itemLayout.findViewById(R.id.textViewList);

        name.setText(item.name);
        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            img.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }



        return itemLayout;

    }
}
