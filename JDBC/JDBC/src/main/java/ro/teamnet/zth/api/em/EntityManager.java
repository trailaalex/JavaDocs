package ro.teamnet.zth.api.em;

import java.util.List;
import java.util.Map;

/**
 * NATO-LOGFS : NCI Agency
 * This source file is the property of the NATO Communications and Information (NCI) Agency, on behalf of NATO.
 * It may not be copied, modified, reused or distributed without the express permission of the NCI Agency.
 * Full terms and conditions are described in LICENSE.TXT, which is part of this software package.
 * Date : 7/13/2017
 * All rights reserved.
 */
public interface EntityManager {

    <T> T findById(Class<T> entityClass, Long id);

    <T> T findByStringId(Class<T> entityClass, String id);

    <T> List<T> findAll(Class<T> entityClass);

    <T> Object insert(T entity);
    <T> T update(T entity);

    void delete(Object entity);

    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params);


}
