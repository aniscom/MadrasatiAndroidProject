package info.androidhive.loginandregistration.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.model.Entity;

public class DetailsActivity extends Activity {


    Toolbar v1;
    TextView v2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        v1 = (Toolbar) findViewById(R.id.title);
        v2 = (TextView) findViewById(R.id.info);
        imageView = (ImageView) findViewById(R.id.imageView);


        Entity entity = (Entity) getIntent().getSerializableExtra("ecole");
    if (entity!=null) {
        v1.setTitle(entity.getNom_ecole());
        v2.setText(entity.getInfo());

        Glide.with(this).load(entity.getImage()).into(imageView);
    }

    }


}
