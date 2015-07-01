package org.oncoblocks.magpie.rest.repositories;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class SubjectRepositoryImpl implements SubjectRepositoryCustom {

    private static final Log log = LogFactory.getLog(SubjectRepositoryImpl.class);
    private static final String COLLECTION_NAME = "subject";

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Subject> find(HashMap<String, String> param) {
        Criteria criteria = new Criteria();

        String gender = param.get("gender");
        if ( gender != null ) {
            criteria = criteria.where("gender").regex(gender, "i");
        }

        String cellLinePrimarySite = param.get("cellLinePrimarySite");
        if ( cellLinePrimarySite != null ) {
            criteria = criteria.where("cellLinePrimarySite").regex(cellLinePrimarySite, "i");
        }

        String cellLineHistology = param.get("cellLineHistology");
        if ( cellLineHistology != null ) {
            criteria = criteria.where("cellLineHistology").regex(cellLineHistology, "i");
        }

        Query query = new Query(criteria);
//        log.info("Query is built: " + query);

        String fieldsStr = param.get("fields");
        if ( fieldsStr != null ) {
            List<String> fields = Arrays.asList( fieldsStr.split(",") );
            for ( String field : fields) {
                query.fields().include(field);
            }
        }

        return mongoTemplate.find(query, Subject.class);
    }
}
