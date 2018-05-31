package com.example.FreeMarkerEnvers.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.FreeMarkerEnvers.dto.PostDTO;
import com.example.FreeMarkerEnvers.form.PersonForm;
import com.example.FreeMarkerEnvers.model.Person;
import com.example.FreeMarkerEnvers.service.PostService;
 
@Controller
public class MainController {
 
	@Autowired
	private PostService service;
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    // Inject via application.properties
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
     
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
         
        return "index";
    }
    
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
    
    @RequestMapping(value = { "/postList" }, method = RequestMethod.GET)
    public String postList(Model model) {
 
    	List<PostDTO> posts = service.listaPost();
        model.addAttribute("posts", posts);
 
        return "post";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String addPersonForm(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String addPersonSave(Model model, //
            @ModelAttribute("personForm") PersonForm personForm) {
 
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:/personList";
        }
        String error = "First Name & Last Name is required!";
        model.addAttribute("errorMessage", error);
        return "addPerson";
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    public String add(Model model) {
 
    	PostDTO postForm = new PostDTO();
        model.addAttribute("postForm", postForm);
 
        return "postAdd";
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute("postForm") PostDTO postForm) {
 
    	service.salvarPost(postForm);
    	
        return "redirect:/postList";
    }
    
    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public String postEdit(Model model,@PathVariable Long id) {
 
    	PostDTO post = service.buscaPost(id);
        model.addAttribute("postForm", post);
 
        return "postEdit";
    }
    
    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.POST)
    public String postEditar(Model model, @ModelAttribute("postForm") PostDTO postForm) {
 
    	service.editaPost(postForm);
    	
        return "redirect:/postList";
    }
    
    @RequestMapping(value = { "/postList/{id}" }, method = RequestMethod.GET)
    public String postExcluir(Model model,@PathVariable Long id) {
 
    	PostDTO post = service.buscaPost(id);
    	service.removePost(post);
    	
        return "redirect:/postList";
    }
}