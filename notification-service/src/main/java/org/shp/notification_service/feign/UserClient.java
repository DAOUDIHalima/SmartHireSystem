package org.shp.notification_service.feign;

import org.shp.notification_service.dtos.CandidateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="USER-SERVICE")
public interface UserClient {
    @GetMapping("/users/candidates")
    List<CandidateDto> getAllCandidates();

}
