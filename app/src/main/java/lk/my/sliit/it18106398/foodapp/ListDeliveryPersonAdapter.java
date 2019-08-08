package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListDeliveryPersonAdapter extends RecyclerView.Adapter<ListDeliveryPersonAdapter.PersonViewHolder> {

    private Context mContext;
    private ArrayList<ModelDeliverPerson> mList;

    public ListDeliveryPersonAdapter(Context mContext, ArrayList<ModelDeliverPerson> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        Log.d("message", "onBindCalled");
        View v = inflater.inflate(R.layout.delivery_person, parent, false);

        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        ModelDeliverPerson modelDeliverPerson = mList.get(position);

        ImageView personImage = holder.personImage;
        TextView personName = holder.personName;

        personImage.setImageResource(mList.get(position).getPersonImage());
        personName.setText(modelDeliverPerson.getPersonName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView personImage;
        TextView personName;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            personImage = itemView.findViewById(R.id.imageViewDeliveryPerson);
            personName = itemView.findViewById(R.id.textViewDeliveryPersonName);
        }
    }
}
