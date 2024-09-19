package org.shp.notification_service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="user-service")
public interface UserClient {

}
