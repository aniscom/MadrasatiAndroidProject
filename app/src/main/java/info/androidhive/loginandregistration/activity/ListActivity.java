package info.androidhive.loginandregistration.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.adapter.RecyclerAdapter;
import info.androidhive.loginandregistration.model.Entity;

/**
 * Created by Anis on 07/05/2017.
 */

public class ListActivity  extends AppCompatActivity{

    RecyclerView recyclerView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);

        ArrayList<Entity>entities = new ArrayList<>();
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));

        RecyclerAdapter adapter=new RecyclerAdapter(ListActivity.this,entities);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        //Layout manager for Recycler view

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
