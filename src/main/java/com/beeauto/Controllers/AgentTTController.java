package com.beeauto.Controllers;

import com.beeauto.entities.*;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AgentTTRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<AgentTT>> getAllAgentTT(){
        List<AgentTT> agentsTT = agentTTRepository.findAll();
        return new ResponseEntity<>(agentsTT , HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<AgentTT> getAgentByEmail(@PathVariable("email") String email) {
        AgentTT agentTT = this.agentTTRepository.findByEmail(email);
        return new ResponseEntity<>(agentTT, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AgentTT> getOneTicket(@PathVariable("id") long id){
        AgentTT agentTT = agentTTRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent TT By Id " + id + " does not exist"));
        return new ResponseEntity<>(agentTT , HttpStatus.OK);
    }


    @PostMapping("/add")
    public AgentTT addAgentTT(@RequestBody AgentTT agentTT) {
        return agentTTRepository.save(agentTT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AgentTT> updateAgentTT(@PathVariable("id") Long id ,
                                               @RequestBody AgentTT agentTT) {
        agentTT.setIdAgentTT(id);
        agentTTRepository.save(agentTT);
        return new ResponseEntity<>(agentTT , HttpStatus.OK);
    }
}
