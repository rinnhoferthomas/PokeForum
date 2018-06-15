package at.fh.swenga.jpa.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.AttackDao;
import at.fh.swenga.jpa.dao.EntryDao;
import at.fh.swenga.jpa.dao.PokemonDao;
import at.fh.swenga.jpa.dao.SpeciesDao;
import at.fh.swenga.jpa.dao.TopicDao;
import at.fh.swenga.jpa.dao.TypeDao;
import at.fh.swenga.jpa.dao.UserDao;
import at.fh.swenga.jpa.dao.UserRoleDao;
import at.fh.swenga.jpa.model.DocumentModel;
import at.fh.swenga.jpa.model.EntryModel;
import at.fh.swenga.jpa.model.TopicModel;
import at.fh.swenga.jpa.model.TypeModel;
import at.fh.swenga.jpa.model.User;

@Controller
public class NavigationController {

	@Autowired
	TopicDao topicDao;
	
	@Autowired
	AttackDao attackDao;
	
	@Autowired
	EntryDao entryDao;
	
	@Autowired
	PokemonDao pokemonDao;
	
	@Autowired
	SpeciesDao speciesDao;
	
	@Autowired
	TypeDao typeDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {

		List<TopicModel> topics = topicDao.getAllTopicsSortById();
		model.addAttribute("topics", topics);
		
		List<TypeModel> types = typeDao.getAllTypes();
		model.addAttribute("types", types);
	
		
		return "index";
	}
	
	@RequestMapping("/signUp")
	public String signUp(Model model) {



		
		return "signUp";
	}
	
		
	
	/*public String deleteData(Model model, @RequestParam int id) {
		employeeDao.delete(id);

		return "forward:list";
	}*/
	
	
	
	@RequestMapping("/profile")
	public String profile(Model model,Principal principal) {

		List<TopicModel> topics = topicDao.getAllTopics();
		model.addAttribute("topics", topics);
		
		List<EntryModel> entries = entryDao.getAllEntries();
		model.addAttribute("entries", entries);
		
		int id = userDao.getUser(principal.getName()).getId();
		User user = userDao.getUserById(id);
		model.addAttribute("user",user);
		
		return "profile";
		
	}
	
	@RequestMapping("/users")
	public String users(Model model) {



		
		return "users";
	}
	
	@RequestMapping("/attacks")
	public String attacks(Model model) {



		
		return "attacks";
	}
	
	@RequestMapping("/pokemon")
	public String pokemon(Model model) {



		
		return "pokemon";
	}
	
	@RequestMapping("/editTeamMember")
	public String editTeamMember(Model model) {



		
		return "editTeamMember";
	}
	
	@RequestMapping("/addEntry")
	public String addEntry(Model model) {



		
		return "addEntry";
	}
	
	
	@RequestMapping("/editSpecies")
	public String editSpecies(Model model) {



		
		return "editSpecies";
	}
	
	/*@RequestMapping("/uploadPicture")
	public String uploadPicture(Model model, @RequestParam int id ) {

		//DocumentModel picture = documentDao.getDocumentById(id);
		//model.addAttribute("picture", picture);
		
		return "uploadPicture";
	}*/
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
	
}

