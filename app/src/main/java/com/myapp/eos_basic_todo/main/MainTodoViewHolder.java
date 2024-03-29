package com.myapp.eos_basic_todo.main;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.eos_basic_todo.R;
import com.myapp.eos_basic_todo.data.entity.TodoItem;

public class MainTodoViewHolder extends RecyclerView.ViewHolder {

    private TextView todo_tv_title;
    private CheckBox todo_cb;

    public MainTodoViewHolder(@NonNull View itemView) {
        super(itemView);

        todo_tv_title = itemView.findViewById(R.id.todo_tv_title);
        todo_cb = itemView.findViewById(R.id.todo_cb);
    }

    //레이아웃에 체크여부와 타이틀 넣어주고 리스트에 넣어준다.
    public void onBind(TodoItem item) {
        todo_tv_title.setText(item.getTitle());
        todo_cb.setChecked(item.getChecked());
    }
}
