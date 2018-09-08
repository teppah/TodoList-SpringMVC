package com.yfy.service;

import com.yfy.model.TodoData;
import com.yfy.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem item);
    void removeItem(int itemId);
    TodoItem getItem(int itemId);
    void updateItem(TodoItem item);
    TodoData getData();
}
