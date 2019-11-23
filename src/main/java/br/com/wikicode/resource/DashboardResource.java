package br.com.wikicode.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.dto.DashboardDto;
import br.com.wikicode.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardResource {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
	public ResponseEntity<DashboardDto> getDashboard() {
		DashboardDto dto = dashboardService.getDashboard();
		return ResponseEntity.ok().body(dto);
	}
}
