package io.nortonahu.customhorizonviewpage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.nortonahu.customhorizonviewpage.R;

/**
 * Created by hongyu on 2015/9/22.
 * recyclerView适配器
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {

    private LayoutInflater mLayoutInflate;
    private Context mContext;

    private String[] mTitles;

    public NormalRecyclerViewAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.recyclerviewarray);
        mContext = context;
        mLayoutInflate = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder normalTextViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {

        NormalTextViewHolder(View itemView) {
            super(itemView);
        }
    }
}
