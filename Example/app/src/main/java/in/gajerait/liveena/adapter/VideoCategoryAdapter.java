package in.gajerait.liveena.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.gajerait.liveena.R;
import in.gajerait.liveena.bean.BeanPhotoCategory;
import in.gajerait.liveena.ui.VideoSubPartActivity;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class VideoCategoryAdapter extends RecyclerView.Adapter<VideoCategoryAdapter.AvailViewHolder> {

    Context context;
    ArrayList<BeanPhotoCategory> vouchers;
    String type;
    View v;

    public VideoCategoryAdapter(Context context, ArrayList<BeanPhotoCategory> vouchers, String type) {
        this.context = context;
        this.vouchers = vouchers;
        this.type = type;
    }

    @Override
    public AvailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);

        return new AvailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AvailViewHolder holder, final int position) {

        Glide.with(context).load(vouchers.get(position).getVoucher_image()).placeholder(R.drawable.lodar).into(holder.img_background);
        holder.company_name.setText(vouchers.get(position).getCategory());

        holder.progressBar.setVisibility(View.VISIBLE);
        holder.llPCitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NAME = vouchers.get(position).getCategory();
                String ID =  vouchers.get(position).getVoucher_id();

                if (NAME.equals("")){
                    NAME = "Video Category";
                }
                Intent intent = new Intent(context, VideoSubPartActivity.class);
                intent.putExtra("ID", ID);
                intent.putExtra("NAME", NAME);
                context.startActivity(intent);
//
//                Toast.makeText(context, "" + vouchers.get(position).getVoucher_id(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return vouchers.size();
    }

    public class AvailViewHolder extends RecyclerView.ViewHolder {
        TextView company_name;
        ImageView img_background;
        LinearLayout llPCitem;
        MaterialProgressBar progressBar;

        public AvailViewHolder(View itemView) {
            super(itemView);

            img_background = (ImageView) itemView.findViewById(R.id.img_background);
            company_name = (TextView) itemView.findViewById(R.id.company_name);
            llPCitem = (LinearLayout) itemView.findViewById(R.id.llPCitem);
            progressBar = (MaterialProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }
}
