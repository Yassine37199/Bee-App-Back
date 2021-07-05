package com.beeauto.Controllers;

import com.beeauto.entities.*;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AgentTTRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agentTT")
@CrossOrigin(origins = "*")
public class AgentTTController {

    private final AgentTTRepository agentTTRepository;

    public AgentTTController(AgentTTRepository agentTTRepository) {
        this.agentTTRepository = agentTTRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<responsableTT>> getAllAgentTT(){
        List<responsableTT> agentsTT = agentTTRepository.findAll();
        return new ResponseEntity<>(agentsTT , HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<responsableTT> getAgentByEmail(@PathVariable("email") String email) {
        responsableTT responsableTT = this.agentTTRepository.findByEmail(email);
        return new ResponseEntity<>(responsableTT, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<responsableTT> getOneTicket(@PathVariable("id") long id){
        responsableTT responsableTT = agentTTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent TT By Id " + id + " does not exist"));
        return new ResponseEntity<>(responsableTT, HttpStatus.OK);
    }


    @PostMapping("/add")
    public responsableTT addAgentTT(@RequestBody responsableTT responsableTT) {
        return agentTTRepository.save(responsableTT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<responsableTT> updateAgentTT(@PathVariable("id") Long id ,
                                                       @RequestBody responsableTT responsableTT) {
        responsableTT.setIdAgentTT(id);
        agentTTRepository.save(responsableTT);
        return new ResponseEntity<>(responsableTT, HttpStatus.OK);
    }
}
