package vn.techmaster.web.controller;
import java.util.List;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
  @Autowired	
	@Lazy	private EurekaClient eurekaClient;

  @GetMapping("/info")
	public List<Application> showShopInfo() {
    return eurekaClient.getApplications().getRegisteredApplications();
	}
}
