package com.ayush.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.ayush.travelapp.Domains.SliderItems;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ayush.travelapp.R;

import java.util.List;
public class SlidersAdapter extends RecyclerView.Adapter<SlidersAdapter.SliderViewholder> {
    private List<SliderItems>  sliderItems;
    private ViewPager2 viewPager2;

    private Context context;

    private Runnable runnable=new Runnable(){

        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    public SlidersAdapter(List<SliderItems> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlidersAdapter.SliderViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        return new SliderViewholder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.slider_viewholder,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlidersAdapter.SliderViewholder sliderViewholder, int i) {
        sliderViewholder.setImage(sliderItems.get(i));
        if(i==sliderItems.size()-2){
            viewPager2.post(runnable);
        }

    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class SliderViewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView nameTxt,genreTxt,ageTxt,yearTxt,timeTxt;
        public SliderViewholder(@NonNull View itemView) {
            super(itemView);
            nameTxt=itemView.findViewById(R.id.nameTxt);
            ageTxt=itemView.findViewById(R.id.ageTxt);
            yearTxt=itemView.findViewById(R.id.yearTxt);
            timeTxt=itemView.findViewById(R.id.hourTxt);
            genreTxt=itemView.findViewById(R.id.genreTxt);
            imageView=itemView.findViewById(R.id.imageSlide);
        }

        void setImage(SliderItems sliderItems){
            RequestOptions requestOptions=new RequestOptions();
            requestOptions= requestOptions.transform(new CenterCrop(),new RoundedCorners(60));
            Glide.with(context)
                    .load(sliderItems.getImage())
                    .apply(requestOptions)
                    .into(imageView);

            nameTxt.setText(sliderItems.getName());
            genreTxt.setText(sliderItems.getGenre());
            ageTxt.setText(sliderItems.getAge());
            yearTxt.setText(sliderItems.getYear());
            timeTxt.setText(sliderItems.getTime());
        }
    }
}

