package ba.ahmed.boot.elastic.controller;


import ba.ahmed.boot.elastic.model.Citat;
import ba.ahmed.boot.elastic.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/{id}")
    public DeferredResult<Citat> searchById(@PathVariable Integer id) {
        DeferredResult<Citat> defCitat = new DeferredResult<>();
        CompletableFuture<Citat> futureCitat = searchService.searchById(id);
        futureCitat.thenAccept(res -> {
            defCitat.setResult(res);
        });
        return defCitat;
    }

    @GetMapping("")
    public DeferredResult<List<Citat>> searchByPlayName(@RequestParam String playName, @RequestParam String speaker, @RequestParam Integer page, @RequestParam Integer per_page) {
        DeferredResult<List<Citat>> citati = new DeferredResult<>();
        CompletableFuture<List<Citat>> futureCitati = searchService.searchByPlayName(playName, speaker, page, per_page);
        futureCitati.thenAccept(res -> {
            citati.setResult(res);
        });
        return citati;
    }



}
