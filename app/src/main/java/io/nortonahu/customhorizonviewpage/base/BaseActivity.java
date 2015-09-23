package io.nortonahu.customhorizonviewpage.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import io.nortonahu.customhorizonviewpage.R;

/**
 * Created by hongyu on 2015/9/21.
 */
public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void initView() {
//        toolbar = fin
    }
}
