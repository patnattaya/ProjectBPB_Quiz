package com.example.hp.projectbpb_quiz;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.projectbpb_quiz.model.Quiz;
import com.example.hp.projectbpb_quiz.adater.QuizListAdapter;
import com.example.hp.projectbpb_quiz.db.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListVew;
    //private ArrayList<Animal> mData;

    private final QuizData quizData = QuizData.getInstance();   // global

    private QuizListAdapter mAdapter;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListVew = (ListView) findViewById(R.id.listView);

        quizData.quizDataList = new ArrayList<>();               // เรียดสิ่งที่อยู่ข้างใน

        mHelper = new DatabaseHelper(this);
        mDatabase = mHelper.getWritableDatabase();
//////
        Cursor cursor = mDatabase.query(
                DatabaseHelper.TABLE_NAME1,
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME1));
            String picture = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PICTURE1));
            String detail = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DEATIL1));
            quizData.quizDataList.add(new Quiz(name, picture, detail));
        }
///////
        mAdapter = new QuizListAdapter(
                this,
                R.layout.item,
                quizData.quizDataList
        );

        mListVew.setAdapter(mAdapter);

        mListVew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Quiz animal = quizData.quizDataList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, QuizDataDetailsActivity.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Method Inflate Menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu); // เริ่ม Inflate menu
        return super.onCreateOptionsMenu(menu); // ไปแสดงผลที่ Activity
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // Method ทำงานหลังกด Menu
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.action_add :
                addAnimal();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addAnimal() {
        Quiz a = new Quiz(
                "A",
                "a.jpg",
                getString(R.string.details_o)
        );
        quizData.quizDataList.add(a);
        mAdapter.notifyDataSetChanged(); // ทำหน้่าที่ แจ้ง Adapter ว่าข้อมูลมีการเปลี่ยนแปลง ให้กลับไปอ่านข้อมูลมาใหม่
    }
}

