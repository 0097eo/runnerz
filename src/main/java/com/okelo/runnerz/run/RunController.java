package com.okelo.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAllRuns() {
        return runRepository.findAll();
    }

    @GetMapping("/{runId}")
    Run findById(@PathVariable Integer runId) {
        Optional<Run> byId = runRepository.findById(runId);
        if(byId.isPresent()) {
            return byId.get();
        } else {
            throw new RunNotFoundException();
        }
    }

    //Post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    //Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    //Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }


}
