package com.example.letstrythisagain;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter;
//    private cards cards_data[];
    private ArrayList<String> al;
    private ImageView image;
    private int i =1;

    private FirebaseAuth myAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

//    ListView listView;
//    List<cards> rowItems;


    int [] picArray = {
            R.drawable.ashma,
            R.drawable.courtney,
            R.drawable.jacob,
            R.drawable.mark,
            R.drawable.mohamed,
            R.drawable.sydney,
            R.drawable.will
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        al = new ArrayList<>();

        al.add("Jacob DeCamp");
        al.add("Mark Fogle");
        al.add("Ashma");
        al.add("Sydney");
        al.add("Will");
        al.add("Ritu");
        al.add("Armin");
        al.add("Damon");
        al.add("Mohamed");
        al.add("Courtney");


//        rowItems = new ArrayList<cards>();
        arrayAdapter = new ArrayAdapter(this, R.layout.item, R.id.name, al  );//adds cards into an array
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);


        myAuth= FirebaseAuth.getInstance();
//      firebaseAuthStateListener= new FirebaseAuth.AuthStateListener()

        flingContainer.setAdapter(arrayAdapter);



        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onLeftCardExit(Object dataObject) {  //The teacher does not remember
//                cards obj = (cards) dataObject;
                newPicCard();
                Toast.makeText(MainActivity.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {  //The teacher does remember
//                cards obj = (cards) dataObject;
                newPicCard();
                Toast.makeText(MainActivity.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
//                al.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter.notifyDataSetChanged();
//                Log.d("LIST", "notified");
//                i++;
//                myAuth.signOut();
                Intent intent = new Intent(MainActivity.this, AttendanceFlashcards.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

//                image.setImageDrawable(getResources().getDrawable(R.drawable.ashma));
                Toast.makeText(MainActivity.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });


    }
public void newPicCard(){
    for (int b=0; b>picArray.length;b++){
//        ImageViewCompat. =getResources().getDrawable(picArray[0]);
        image = findViewById(R.id.imagecard);
        image.setImageResource(picArray[0]);
        image.setImageResource(picArray[1]);
        image.setImageResource(picArray[2]);
        image.setImageResource(picArray[3]);
        image.setImageResource(picArray[4]);
        image.setImageResource(picArray[5]);
        image.setImageResource(picArray[6]);
        image.setImageResource(picArray[7]);
        image.setImageResource(picArray[8]);
        image.setImageResource(picArray[9]);

    }
}


}

//    backBack= (Button) findViewById(R.id.backward);
//
//        backBack.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick(View view){
//        myAuth.signOut();
//        Intent intent = new Intent(MainActivity.this, AttendanceFlashcards.class);
//        startActivity(intent);
//        finish();
//
//    }
//};