package io.nortonahu.customhorizonviewpage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.nortonahu.customhorizonviewpage.AppContext;
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
        return new NormalTextViewHolder(mLayoutInflate.inflate(R.layout.item_text, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder normalTextViewHolder, int i) {
        normalTextViewHolder.mTextView .setText(mTitles[i]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;

        NormalTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @OnClick(R.id.text_view)
        void onItemClick(TextView view) {
            Toast.makeText(AppContext.getContext(),"onClick is " + view.getText(), Toast.LENGTH_LONG).show();
        }
    }
}
