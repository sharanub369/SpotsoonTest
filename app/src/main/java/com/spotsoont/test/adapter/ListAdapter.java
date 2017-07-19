package com.spotsoont.test.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spotsoont.test.R;
import com.spotsoont.test.activity.MainActivity;
import com.spotsoont.test.model.VideoModel;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    List<VideoModel> mListData;
    Context context;

    /**
     * @param mListData
     * @param context
     */
    public ListAdapter(List<VideoModel> mListData, Context context) {
        this.mListData = mListData;
        this.context = context;
    }


    /**
     * Creating view holder
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_item,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    /**
     * Binding view holder items with values
     *
     * @param myViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int i) {
        final VideoModel model = mListData.get(i);
        myViewHolder.songNameTxt.setText(model.getSongName());
        myViewHolder.postedBeforeTxt.setText(model.getPostedBefore() + " HOURS AGO");
        myViewHolder.songImageView.setImageResource(model.getImageId());
        myViewHolder.listItemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) context).playVideo(model.getmPath());
            }
        });

    }

    /**
     * getting number of items in the list
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    /**
     * View holder for recycler view
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView songNameTxt;
        private TextView postedBeforeTxt;
        private CardView listItemCardView;
        private ImageView songImageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            songNameTxt = (TextView) itemView.findViewById(R.id.songTitleTxt);
            postedBeforeTxt = (TextView) itemView.findViewById(R.id.hoursTxt);
            listItemCardView = (CardView) itemView.findViewById(R.id.listItemCardView);
            songImageView = (ImageView) itemView.findViewById(R.id.songImage);
        }
    }

}

