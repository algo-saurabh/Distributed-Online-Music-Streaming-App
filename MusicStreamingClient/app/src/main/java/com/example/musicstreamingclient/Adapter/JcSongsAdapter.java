package com.example.musicstreamingclient.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstreamingclient.Model.GetSongs;
import com.example.musicstreamingclient.Model.Utility;
import com.example.musicstreamingclient.R;

import java.util.List;

public class JcSongsAdapter extends RecyclerView.Adapter<JcSongsAdapter.SongsAdapterViewHolder>{

    private int selectedPosition;
    Context context;
    List<GetSongs> arraylistSongs;
    private RecyclerItemClickListner listner;

    public JcSongsAdapter(Context context, List<GetSongs> arraylistSongs, RecyclerItemClickListner listner) {
        this.context = context;
        this.arraylistSongs = arraylistSongs;
        this.listner = listner;
    }

    @NonNull
    @Override
    public SongsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.songs_row,parent,false);
        return new SongsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapterViewHolder holder, int position) {
        GetSongs getSongs = arraylistSongs.get(position);

        if (getSongs != null){
            if(selectedPosition == position){
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimary));
                holder.iv_play_active.setVisibility(View.VISIBLE);
            }
            else{
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
                holder.iv_play_active.setVisibility(View.INVISIBLE);
            }
        }

        holder.tv_title.setText(getSongs.getSongTitle());
        holder.tv_artist.setText(getSongs.getArtist());
        String duration = Utility.convertDuration(Long.parseLong(getSongs.getSongDuration()));
        holder.tv_duration.setText(duration);
        holder.bind(getSongs,listner);
    }

    @Override
    public int getItemCount() {
        return arraylistSongs.size();
    }

    public class SongsAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title, tv_artist, tv_duration;
        ImageView iv_play_active;
        public SongsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_artist = itemView.findViewById(R.id.tv_artist);
            tv_duration = itemView.findViewById(R.id.tv_duration);
            iv_play_active = itemView.findViewById(R.id.iv_play_active);
        }

        public void bind(GetSongs getSongs, RecyclerItemClickListner listner) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onClickListener(getSongs,getAdapterPosition());
                }
            });
        }
    }

    public interface RecyclerItemClickListner {
        void onClickListener (GetSongs songs, int position);
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}
