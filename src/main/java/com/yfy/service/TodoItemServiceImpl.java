package com.yfy.service;

import com.yfy.model.TodoData;
import com.yfy.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;


@Service
public class TodoItemServiceImpl implements TodoItemService {

    /*
    * fields
    *
    * */
    @Getter
    private final TodoData data = new TodoData();


    /*
    * public methods
    *
    * */
    @Override
    public void addItem(TodoItem item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(int itemId) {
        data.removeItem(itemId);
    }

    @Override
    public TodoItem getItem(int itemId) {
        return data.getItem(itemId);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }

}
