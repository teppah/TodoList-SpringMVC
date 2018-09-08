package com.yfy.controller;

import com.yfy.model.TodoData;
import com.yfy.model.TodoItem;
import com.yfy.service.TodoItemService;
import com.yfy.util.AttributeNames;
import com.yfy.util.Mappings;
import com.yfy.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Slf4j
public class TodoItemController {
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    /*
     * Model attributes
     *
     * */
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    /*
     * handler methods
     *
     * */

    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {
//        log.info("Editing id: {}", id);
//        TodoItem todoItem = id == -1 ?
//                new TodoItem("", "", LocalDate.now()) :
//                todoItemService.getItem(id);

        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItems(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("New item added: {}", todoItem);

        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with ID {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        log.info("viewItem id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            throw new RuntimeException("What the fuck are you doing dawg, " + id + " not a valid id");
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
//        model.addAttribute("id", todoItem.getId());
//        model.addAttribute("title", todoItem.getTitle());
//        model.addAttribute("details", todoItem.getDetails());
//        model.addAttribute("deadline", todoItem.getDeadline());
        return ViewNames.VIEW_ITEM;
    }
}
