package edu.learn.strangerthings.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.learn.strangerthings.datas.StrangerThingsTrack;
import edu.learn.strangerthings.R;


public class StrangerThingsTrackAdapter extends RecyclerView.Adapter<StrangerThingsTrackAdapter.ViewHolder> {

    private List<StrangerThingsTrack> trackList;
    private Context context;

    public StrangerThingsTrackAdapter(List<StrangerThingsTrack> trackList, Context context) {
        this.trackList = trackList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stranger_things_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StrangerThingsTrack track = trackList.get(position);

        holder.title.setText(track.getTitle());
        holder.artist.setText(track.getArtist());
        holder.releaseYear.setText(track.getReleaseYear());
        holder.image.setImageResource(track.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(track.getSongUrl()));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView artist;
        public TextView releaseYear;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artist);
            releaseYear = itemView.findViewById(R.id.releaseYear);
            image = itemView.findViewById(R.id.image);
        }
    }
}
