package org.acme.workloads.Table_Entity;

import org.acme.workloads.Job.Job;

import java.util.List;

public interface TableEntityRepo {

    List<TableEntity> getAllTables();
    void add(TableEntity tableEntity);
    void update(TableEntity tableEntity);
    void delete(TableEntity tableEntity);
    List<TableEntity> getAllTablesByRestaurantId(Long id);

}