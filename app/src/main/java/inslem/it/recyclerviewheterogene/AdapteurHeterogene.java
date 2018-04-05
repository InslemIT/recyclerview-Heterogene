package inslem.it.recyclerviewheterogene;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapteurHeterogene extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> mArrayList;
    private final int MESSAGE = 1;
    private final int IMAGE = 2;
    private Context mContext;

    AdapteurHeterogene(Context context, List<Object> arrayList) {
        mArrayList = arrayList;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        if (viewType == MESSAGE)
        {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_message, parent, false);
            return new MessageViewHolder(itemView);
        }
        else //(viewType == IMAGE)
        {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == MESSAGE)
        {
            MessageClass message = (MessageClass) mArrayList.get(position);
            MessageViewHolder msg = (MessageViewHolder) holder;
            msg.mmMessage.setText(message.getMessage());

        }
        else if (holder.getItemViewType() == IMAGE)
        {
            ImageClass image = (ImageClass) mArrayList.get(position);
            ImageViewHolder imgHolder = (ImageViewHolder) holder;
            imgHolder.iiImage.setImageDrawable(image.getImage());
        }else{
            Log.d("inslem","Item non reconnu");
        }
    }

    @Override
    public int getItemCount() {
        if (mArrayList.size() == 0) {
            return 0;
        }
        else {
            return mArrayList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (mArrayList.get(position) instanceof MessageClass)
        {
            return MESSAGE;
        }
        else //if (mArrayList.get(position) instanceof ImageClass)
        {
            return IMAGE;
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iiImage;

        ImageViewHolder(View itemView)
        {
            super(itemView);
            iiImage =  itemView.findViewById(R.id.imageView2);
        }

    }

    public class MessageViewHolder extends RecyclerView.ViewHolder
    {
        TextView  mmMessage;

       MessageViewHolder(View itemView)
        {
            super(itemView);
            mmMessage =  itemView.findViewById(R.id.message);
        }
    }
}
