package com.cyberspace.materialanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

public class TransitionActivity extends AppCompatActivity {

    Constants.AnimType type;

    String toolBarTitle, animName;
    TextView _txvAnimName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate()
        // Must also be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        type = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolBarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);
        animName = getIntent().getExtras().getString(Constants.KEY_NAME);

        setupAnimation();

        bindControl();

        setupToolbar();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolBarTitle);
    }

    private void setupAnimation() {

        switch (type) {
            case ExplodeJava: {
                Explode enterTransition = new Explode();
                enterTransition.setInterpolator(new OvershootInterpolator());
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case ExplodeXML: {
                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case SlideJava: {
                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.END);
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case SlideXML: {
                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case FadeJava: {
                Fade enterTransition = new Fade();
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case FadeXML: {
                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    private void bindControl() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

        _txvAnimName = (TextView) findViewById(R.id.txvAnimName);
        _txvAnimName.setText(animName);
    }
}
