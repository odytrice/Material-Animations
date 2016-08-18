package com.cyberspace.materialanimations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView _txvShared;
    private ImageView _imgStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindControls();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    private void bindControls() {

        Button btnExplodeJava = (Button) findViewById(R.id.btnExplodeJava);
        Button btnExplodeXML = (Button) findViewById(R.id.btnExplodeXML);
        Button btnSlideJava = (Button) findViewById(R.id.btnSlideJava);
        Button btnSlideXML = (Button) findViewById(R.id.btnSlideXML);
        Button btnFadeJava = (Button) findViewById(R.id.btnFadeJava);
        Button btnFadeXML = (Button) findViewById(R.id.btnFadeXML);

        LinearLayout layoutSharedElement = (LinearLayout) findViewById(R.id.shared_element);
        _imgStar = (ImageView) findViewById(R.id.imgStarSharedElement);
        _txvShared = (TextView) findViewById(R.id.txvSharedElement);

        layoutSharedElement.setOnClickListener(this);

        btnExplodeJava.setOnClickListener(this);
        btnExplodeXML.setOnClickListener(this);
        btnSlideJava.setOnClickListener(this);
        btnSlideXML.setOnClickListener(this);
        btnFadeJava.setOnClickListener(this);
        btnFadeXML.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExplodeJava: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeJava);
                intent.putExtra(Constants.KEY_TITLE, "Explode Animation");
                intent.putExtra(Constants.KEY_NAME, "Explode by Code");

                startActivity(intent, options.toBundle());

                break;
            }
            case R.id.btnExplodeXML: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeXML);
                intent.putExtra(Constants.KEY_TITLE, "Explode Animation");
                intent.putExtra(Constants.KEY_NAME, "Explode by XML");

                startActivity(intent, options.toBundle());

                break;
            }
            case R.id.btnSlideJava: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideJava);
                intent.putExtra(Constants.KEY_TITLE, "Slide Animation");
                intent.putExtra(Constants.KEY_NAME, "Slide by Java");

                startActivity(intent, options.toBundle());

                break;
            }
            case R.id.btnSlideXML: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideXML);
                intent.putExtra(Constants.KEY_TITLE, "Slide Animation");
                intent.putExtra(Constants.KEY_NAME, "Slide by XML");

                startActivity(intent, options.toBundle());

                break;
            }
            case R.id.btnFadeJava: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeJava);
                intent.putExtra(Constants.KEY_TITLE, "Fade Animation");
                intent.putExtra(Constants.KEY_NAME, "Fade by Java");

                startActivity(intent, options.toBundle());
                break;
            }
            case R.id.btnFadeXML: {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeXML);
                intent.putExtra(Constants.KEY_TITLE, "Fade Animation");
                intent.putExtra(Constants.KEY_NAME, "Fade by XML");

                startActivity(intent, options.toBundle());

                break;
            }

            case R.id.shared_element:{
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(_imgStar,"star");
                pairs[1] = new Pair<View,String>(_txvShared,"text_shared");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
                Intent intent = new Intent(MainActivity.this,SharedElementActivity.class);
                startActivity(intent,options.toBundle());
                break;
            }
        }
    }
}
