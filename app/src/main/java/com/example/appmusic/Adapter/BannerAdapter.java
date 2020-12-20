package com.example.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appmusic.Model.Advertisement;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter  extends PagerAdapter {
    Context context;
    ArrayList<Advertisement> arrayListBanner; //mãng quảng cáo

    public BannerAdapter(Context context, ArrayList<Advertisement> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }
//trả về view tùy theo object định hình
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    //định hình object (mỗi object tương trưng cho mỗi page
    //Nhìn view mẫu sẽ đi thiết kế cho những page còn lại
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.line_banner,null);
        //ánh xạ view trong phần banner vào
        ImageView imageViewBackgroundBanner=view.findViewById(R.id.imageViewBackgroundBanner);
        ImageView imageSongBanner=view.findViewById(R.id.imageViewBanner);
        TextView txtTitleSongBanner=view.findViewById(R.id.textviewTitleSongBanner);
        TextView txtnoidung=view.findViewById(R.id.textviewindex);
        //gắn giá trị //load từ dữ liệu nào
        Picasso.with(context).load(arrayListBanner.get(position).getImageAdver()).into(imageViewBackgroundBanner);
        Picasso.with(context).load(arrayListBanner.get(position).getImageSong()).into(imageSongBanner);
        txtTitleSongBanner.setText(arrayListBanner.get(position).getNameSong());
        txtnoidung.setText(arrayListBanner.get(position).getContentAdver());

        //add vào viewpager
        container.addView(view);
        return view;
    }
// xáo view sau khi thực hiện xong
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
