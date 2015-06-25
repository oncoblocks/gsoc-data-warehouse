package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.Subject;

import java.util.HashMap;
import java.util.List;

public interface SubjectRepositoryCustom {
    List<Subject> find(HashMap<String, String> param);
}
