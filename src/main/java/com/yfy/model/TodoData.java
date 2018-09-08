package com.yfy.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    /*
     * fields
     *
     * */

    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();


    /*
     * constructors
     *
     * */
    public TodoData() {

        // add dummy data
        addItem(new TodoItem("first", "firstDetails", LocalDate.now()));
        addItem(new TodoItem("second", "secondDetails", LocalDate.now()));
        addItem(new TodoItem("third", "thirdDetails", LocalDate.now()));
        addItem(new TodoItem("fourth", "secondDetails", LocalDate.now()));
    }

    /*
     * public methods
     *
     * */
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        idValue++;
        items.add(toAdd);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();
            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
            }
        }
    }

}
