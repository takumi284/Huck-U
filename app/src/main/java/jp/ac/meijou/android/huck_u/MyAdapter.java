package jp.ac.meijou.android.huck_u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // データのバインド
        holder.morningView.setText(data.get(position));
        holder.View1.setText(data.get(position));
        holder.View2.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView morningView, View1, View2, noonView,
                        View3, View4, View5, View6,
                        View7, nightView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 三分割のTextViewを取得
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

