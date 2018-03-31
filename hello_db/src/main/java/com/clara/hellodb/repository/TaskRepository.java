package com.clara.hellodb.repository;

import com.clara.hellodb.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by clara on 3/30/18.
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
