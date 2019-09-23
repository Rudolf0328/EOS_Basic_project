package com.myapp.eos_basic_todo.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.eos_basic_todo.R;
import com.myapp.eos_basic_todo.data.entity.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class MainTodoAdapter extends RecyclerView.Adapter<MainTodoViewHolder> {

    private ArrayList<TodoItem> itemList = new ArrayList<>();

    public void submitAll(List<TodoItem> list) {
        itemList.clear();
        //리스트에 모든 데이터 불러옴
        itemList.addAll(list);
        //바뀐 데이터 적용, 이거 안하면 새로운 메인액티비티 생기기전에 안댐
        notifyDataSetChanged();
    }

    public void addItem(TodoItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    //viewHolder란?
    @NonNull
    @Override
    public MainTodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainTodoViewHolder viewHolder = new MainTodoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false));
        return viewHolder;
    }

    //포지션마다 호출
    @Override
    public void onBindViewHolder(@NonNull MainTodoViewHolder holder, int position) {
        holder.onBind(itemList.get(position));
    }

    //아이템 갯수 반환
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
