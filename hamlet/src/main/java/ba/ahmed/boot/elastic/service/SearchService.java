package ba.ahmed.boot.elastic.service;

import ba.ahmed.boot.elastic.model.Citat;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by USER on 8/31/2017.
 */
public interface SearchService {

    CompletableFuture<Citat> searchById(Integer id);

    CompletableFuture<List<Citat>> searchByPlayName(String playName, String speaker, Integer page, Integer per_page);


}
