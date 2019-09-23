package com.myapp.eos_basic_todo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myapp.eos_basic_todo.R;
import com.myapp.eos_basic_todo.data.database.MyDatabase;
import com.myapp.eos_basic_todo.data.entity.TodoItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_rcv;
    private FloatingActionButton main_fab;
    private MainTodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_rcv = findViewById(R.id.main_rcv);
        main_fab = findViewById(R.id.main_fab);

        adapter = new MainTodoAdapter();

        //adapter 불러오기 -> viewHolder까지 다 불러옴
        main_rcv.setAdapter(adapter);
        //레이아웃 설정
        main_rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        final MyDatabase myDatabase = MyDatabase.getInstance(this);
        List<TodoItem> list_item = myDatabase.todoDao().getAllTodo();
        adapter.submitAll(list_item);

        //버튼을 누를 때 마다 임시로 데이터 넣어줌. 데이터 추가.
        main_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //command 누르고 마우스 올리면 반환값 확인가능
                //long, int, float, double은 primitive type Long, INTEGER(?)은 레퍼머시기 타입
                Long time = System.currentTimeMillis();
                TodoItem temp = new TodoItem(time.toString());
                //final로 바뀜, dataBase에 data들어감
                myDatabase.todoDao().insertTodo(temp);
                //다 지우고 다시 저장 -> 데이터 많아지면 오래걸림
                //adapter.submitAll();
                adapter.addItem(temp);
            }
        });
    }
}
