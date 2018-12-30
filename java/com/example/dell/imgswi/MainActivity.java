package com.example.dell.imgswi;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity implements View.OnClickListener{
    ImageSwitcher sw;
    Button pr,nx;
    int logo[] = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };

    int currentindex = -1;

  @Override
    protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      pr = findViewById(R.id.pr);
      nx = findViewById(R.id.nx);
      pr.setOnClickListener(this);
      nx.setOnClickListener(this);
      sw = findViewById(R.id.imgsw);
      sw.setFactory(new ViewSwitcher.ViewFactory() {
          @Override
          public View makeView() {
              ImageView image = new ImageView(getApplicationContext());
              image.setScaleType(ImageView.ScaleType.FIT_CENTER);
              image.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
             return image;
          }
      });

    }
    public void onClick(View view){
      switch (view.getId())
      {
          case R.id.pr:
              if(currentindex<logo.length-1){
                  currentindex = currentindex+1;
                  sw.setBackgroundResource(logo[currentindex]);
              }
              break;
          case R.id.nx:
              if(currentindex>0){
                  currentindex = currentindex-1;
                  sw.setBackgroundResource(logo[currentindex]);
              }
              break;

      }
    }
}


