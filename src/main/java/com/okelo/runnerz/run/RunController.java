package com.okelo.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Run not found"
            );

        }
    }


}
