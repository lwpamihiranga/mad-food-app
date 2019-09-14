package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListDeliveryPersonAdapter extends RecyclerView.Adapter<ListDeliveryPersonAdapter.PersonViewHolder> {

    private Context mContext;
    private ArrayList<ModelDeliverPerson> mList;
    private String orderName;

    public ListDeliveryPersonAdapter(Context mContext, ArrayList<ModelDeliverPerson> mList, String orderName) {
        this.mContext = mContext;
        this.mList = mList;
        this.orderName = orderName;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.delivery_person, parent, false);

        return new PersonViewHolder(v, mContext);
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
        return mList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView personImage;
        TextView personName;
        Button reqDelivery;

        Context mContext;

        public PersonViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            personImage = itemView.findViewById(R.id.imageViewDeliveryPerson);
            personName = itemView.findViewById(R.id.textViewDeliveryPersonName);
            reqDelivery = itemView.findViewById(R.id.button);

            reqDelivery.setOnClickListener(this);

            mContext = context;
        }

        @Override
        public void onClick(View view) {


            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery");

            Delivery delivery = new Delivery();

            delivery.setDeliveryDriverUsername(personName.getText().toString().trim());
            delivery.setOrderStatus("Requested");

            dbRef.child(orderName).setValue(delivery);

            Toast.makeText(mContext, "Delivery added to batabase", Toast.LENGTH_SHORT).show();
        }
    }
}
