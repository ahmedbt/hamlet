package ba.ahmed.boot.elastic.service;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ba.ahmed.boot.elastic.model.Citat;

/**
 * Created by USER on 8/31/2017.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ElasticsearchOperations esOperations;

    @Async
    @Override
    public CompletableFuture<Citat> searchById(Integer id) {

        NativeSearchQueryBuilder nsqb = new NativeSearchQueryBuilder();
        nsqb.withQuery(boolQuery().must(termQuery("line_id", id)));

        Citat c = esOperations.queryForList(nsqb.build(), Citat.class).get(0);

        return CompletableFuture.completedFuture(c);
    }

    @Async
    @Override
    public CompletableFuture<List<Citat>> searchByPlayName(String playName, String speaker, Integer page, Integer per_page) {


        NativeSearchQueryBuilder nsqb = new NativeSearchQueryBuilder();
        nsqb.withQuery(boolQuery().must(matchQuery("play_name", playName))
                                  .must(matchQuery("speaker", speaker).fuzziness(Fuzziness.ONE))
                                  .mustNot(regexpQuery("text_entry", ".*a.*")))
                       .withSort(SortBuilders.fieldSort("text_entry").order(SortOrder.ASC));

        nsqb.withPageable(new PageRequest(page, per_page));
        List<Citat> c = esOperations.queryForList(nsqb.build(), Citat.class);

        return CompletableFuture.completedFuture(c);


    }


}

