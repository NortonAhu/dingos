package io.nortonahu.customhorizonviewpage.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.nortonahu.customhorizonviewpage.R;
import io.nortonahu.customhorizonviewpage.adapter.NormalRecyclerViewAdapter;

/**
 * Created by hongyu on 2015/9/22.
 * RecycleView 深度学习
 */
public class RecyclerViewActivity extends AppCompatActivity {
    @Bind(R.id.recycle_view)
    RecyclerView _recyclerView;
    @Bind(R.id.recycle_toolbar)
    Toolbar _toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view_activity);
        ButterKnife.bind(this);
        setSupportActionBar(_toolBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        // 这里使用线性显示
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        _recyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            onBackPressed();
            return true;
        }else
            return super.onOptionsItemSelected(item);
    }
}
