package jp.ac.meijou.android.huck_u;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    private int rand, intContentView3, seats;

    private String contentView3, strSeats;
    long seed = 123; // 任意のシード値を指定
    Random random = new Random(seed);

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // データのバインド
        List<String> rooms = Arrays.asList(
                "E101", "E102", "E103", "E201", "E202", "E203", "E204", "E205",
                "E301", "E302", "E303", "E304", "E305", "E401", "E402", "E403",
                "E404", "E405", "E501", "E503", "E504", "E505", "E601", "E602",
                "E603", "E604", "E605", "E701", "E702"
        );

        holder.roomView.setText(rooms.get(position));

        seats = Integer.parseInt(data.get(position)) + 219;
        strSeats = Integer.valueOf(seats).toString();
        holder.seatView.setText(strSeats);

        holder.View3.setText(data.get(position));

        contentView3 = holder.View3.getText().toString();
        intContentView3 = Integer.parseInt(contentView3);
        if (intContentView3 < 40){
            holder.View3.setBackgroundColor(Color.parseColor("#9BEAFF"));
        } else if (intContentView3 < 55) {
            holder.View3.setBackgroundColor(Color.parseColor("#FBFF87"));
        } else {
            holder.View3.setBackgroundColor(Color.parseColor("#FF7700"));
        }

        ArrayList<String> OorX = new ArrayList<String>();
        for (int i = 0; i < 9; i++){
            rand = random.nextInt(60);
            if (rand < 50){
                OorX.add("x");
            }
            else{
                OorX.add("o");
            }
        }
        holder.morningView.setText(OorX.get(0));
        holder.View1.setText(OorX.get(1));
        holder.View2.setText(OorX.get(2));
        holder.noonView.setText(OorX.get(3));
        holder.View5.setText(OorX.get(4));
        holder.View4.setText(OorX.get(5));
        holder.View6.setText(OorX.get(6));
        holder.View7.setText(OorX.get(7));
        holder.nightView.setText(OorX.get(8));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView roomView, seatView, morningView, View1, View2, noonView,
                        View3, View4, View5, View6, View7, nightView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            roomView = itemView.findViewById(R.id.roomView);
            seatView = itemView.findViewById(R.id.seatView);
            morningView = itemView.findViewById(R.id.morningView);
            View1 = itemView.findViewById(R.id.View1);
            View2 = itemView.findViewById(R.id.View2);
            noonView = itemView.findViewById(R.id.noonView);
            View3 = itemView.findViewById(R.id.View3);
            View4 = itemView.findViewById(R.id.View4);
            View5 = itemView.findViewById(R.id.View5);
            View6= itemView.findViewById(R.id.View6);
            View7 = itemView.findViewById(R.id.View7);
            nightView = itemView.findViewById(R.id.nightView);
        }
    }
}

