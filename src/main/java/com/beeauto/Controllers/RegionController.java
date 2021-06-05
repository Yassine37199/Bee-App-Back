package com.beeauto.Controllers;

import com.beeauto.entities.*;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.RegionRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionRepository regionRepository;
    private final UserRepository userRepository;

    @Autowired
    public RegionController(RegionRepository regionRepository, UserRepository userRepository) {
        this.regionRepository = regionRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/list")
    public List<Region> listRegion() {
        return (List<Region>) regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getOneRegion(@PathVariable("id") Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region By Id " + id + " does not exist"));
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @GetMapping("/name/{regionName}")
    public ResponseEntity<Region> getRegionByName(@PathVariable("regionName") String regioName) {
        Region region = this.regionRepository.findByName(regioName);
        return new ResponseEntity<>(region, HttpStatus.OK);
    }


    @PostMapping("/add/{idUser}")
    public Region addRegion(@PathVariable("idUser") long idUser,
                            @RequestBody Region region) {

        return userRepository.findById(idUser).map(user -> {
            region.setUser(user);
            return regionRepository.save(region);
        }).orElseThrow(() -> new com.beeauto.Exception.ResourceNotFoundException("user" + idUser + "not found"));
    }


    @PutMapping("update/{idRegion}/{idUser}")
    public Region updateRegion(@PathVariable(value = "idUser") Long idUser,
                           @PathVariable(value = "idRegion") Long idRegion,
                           @Valid @RequestBody Region regionRequest ) {
        return
                regionRepository.findById(idRegion).map(region -> {
                    User user = userRepository.findById(idUser)
                            .orElseThrow(() -> new com.beeauto.Exception.ResourceNotFoundException("errreeeur"));
                    region.setRegionName(region.getRegionName());
                    region.setUser(user);
                    return regionRepository.save(region);
                }).orElseThrow(() -> new
                        com.beeauto.Exception.ResourceNotFoundException("user" + idUser + "not found"));

    }
}
