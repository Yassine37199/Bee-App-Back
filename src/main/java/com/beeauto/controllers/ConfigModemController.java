package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beeauto.entities.ConfigModem;
import com.beeauto.repositories.ConfigModemRepository;


@RestController
@RequestMapping("/configmodem")
	public class ConfigModemController {

		
		private final ConfigModemRepository configmodemRepo;
		
		
		@Autowired
		public ConfigModemController (ConfigModemRepository configmodemRepo)
		
		{
			this.configmodemRepo=configmodemRepo;
			
		}
		
		@GetMapping("/list")
		public List <ConfigModem> listconfigmodem()
		{
			
		return (List<ConfigModem>) configmodemRepo.findAll();
			
		}
		
		@PostMapping("/add")
		public ConfigModem addConfigmodem(   @Valid    @RequestBody ConfigModem configmodem) {
			
			return configmodemRepo.save(configmodem);
			
		}
		

}
