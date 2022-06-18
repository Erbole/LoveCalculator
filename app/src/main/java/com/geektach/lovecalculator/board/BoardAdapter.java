package com.geektach.lovecalculator.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.geektach.lovecalculator.Board;
import com.geektach.lovecalculator.R;
import com.geektach.lovecalculator.databinding.PagerBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private ArrayList<Board> list;

    public BoardAdapter(BoardFragment boardFragment) {
        list = new ArrayList<>();
        list.add(new Board("",
                "",
                R.drawable.photo_1));
        list.add(new Board("",
                "",
                R.drawable.photo_1));
        list.add(new Board("",
                "",
                R.drawable.photo_1));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PagerBoardBinding binding = PagerBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView textDisc;
        private Button btn_start;

        private PagerBoardBinding binding;

        public ViewHolder(@NonNull PagerBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            textDisc = itemView.findViewById(R.id.desc);
            title = itemView.findViewById(R.id.title);
            btn_start = itemView.findViewById(R.id.btnSkip);
            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).popBackStack();
                }
            });
        }

        public void bind(int position) {
            Board board = list.get(position);
            binding.desc.setText(board.getDesc());
            binding.title.setText(board.getTitle());
            if (position == list.size() - 1) {
                btn_start.setVisibility(View.VISIBLE);
            } else {
                btn_start.setVisibility(View.INVISIBLE);
            }
            if (position == 1) {
                binding.animationView.setAnimation(R.raw.board_one);
            } else if (position == 2) {
                binding.animationView.setAnimation(R.raw.board_one);
            } else {
                binding.animationView.setAnimation(R.raw.board_one);
            }
        }
    }
}
