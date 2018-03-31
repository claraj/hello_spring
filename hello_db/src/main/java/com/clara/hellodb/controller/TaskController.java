package com.clara.hellodb.controller;

import com.clara.hellodb.model.Task;
import com.clara.hellodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * Created by clara on 3/30/18.
 */

@Controller
public class TaskController {

    /* The TaskRepository is an object that will interact with the
    Task database table, so save new Tasks, query for tasks... */
    private final TaskRepository tasks;
    
    @Autowired
    public TaskController(TaskRepository tasks) {
        this.tasks = tasks;
    }
    
    /* Handles requests to the home page. Displays a form that's bound to a new
    * Task object. In the future, When the form is submitted, (that's the /addTask route, below)
    * the Task object will be updated to include the data entered in the form, and this Task object will be
    * sent to the server. */
    @RequestMapping("/")
    public ModelAndView addTask() {
        return new ModelAndView("tasks.html", "task", new Task());
    }
    
    /* Handles form submission requests. Saves the Task sent with the request, and
    * redirect (creates a new request to) the /allTasks page. */
    @RequestMapping(value="/addTask", method=RequestMethod.POST)
    public RedirectView addNewTask(Task task) {
        tasks.save(task);
        return new RedirectView("/allTasks");
    }
    
    /* Handles requests to the /allTasks page. The modelMap object will be populated with
    * a list ot Task objects that we'll get by asking the tasks repository to query
    * the database. Returns a View (the Thymeleaf template) which be combined with
    * the modelMap data to produce the HTML page. */
    @RequestMapping("/allTasks")
    public ModelAndView allTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", tasks.findAll(new Sort(Sort.Direction.DESC, "urgent")));
        return new ModelAndView("alltasks.html", modelMap);
    }
    
}
