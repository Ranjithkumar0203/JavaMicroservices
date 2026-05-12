package com.deccan.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deccan.employee.model.WorkLocation;

@FeignClient(name = "worklocation", fallback = WorkLocationClientFallback.class)
public interface WorkLocationClientClient {
    @PostMapping("/worklocation/save")
    public WorkLocation saveWorkLocation(@RequestBody WorkLocation WorkLocation);
}
