package com.myapp.eos_basic_todo.data.dao;

import com.myapp.eos_basic_todo.data.entity.TodoItem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface TodoDao {
    //public interface라서 함수에 public 쓸 필요 없음.
    @Insert
    void insertTodo(TodoItem item);

    @Delete
    void deleteTodo(TodoItem item);

    //수정
    @Update
    void updateTodo(TodoItem item);

    //모든 데이터를 리스트 형태로 가져오기
    @Query("SELECT * FROM Todo")
    List<TodoItem> getAllTodo();

    //WHERE은 자바의 if, *은 다 가져온다.
    //id가 같은 row를 가져온다.
    @Query("SELECT * FROM Todo WHERE id = :id")
    TodoItem getTodo(int id);
}
