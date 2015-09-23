package io.nortonahu.customhorizonviewpage.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.nortonahu.customhorizonviewpage.R;

/**
 * Created by hongyu on 2015/9/22.
 * 主要为了学习toolbar深度指示
 */
public class ToolBarActivity extends AppCompatActivity {
    @Bind(R.id.toolBar_act)
    Toolbar _toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_bar_activity);
        ButterKnife.bind(this);
        _toolBar.setTitle("Tool Bar");
        setSupportActionBar(_toolBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            onBackPressed();
            return true;
        }else
        {
            return super.onOptionsItemSelected(item);
        }
    }
}
