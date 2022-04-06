package com.example.speedtest.rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Guruprakash
 *
 * Speed test rest API class for checking Internet speed. 
 */
@RestController
public class SpeedTestRestApi {

	/**
	 * This method is to say hello.
	 * 
	 * @return Hello string
	 */
	@GetMapping("/")
	public ResponseEntity <String> sayHello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}

	/**
	 * This method redirects to fast.com to check our Internet speed
	 * 
	 * @return RedirectView which takes us to 'https://fast.com/'
	 */
	@GetMapping("/speedtest")
	public RedirectView getSpeedTest() {
		RedirectView redirectView = null;
		try {
			String externalUrl = "https://fast.com/";
			redirectView = new RedirectView();
			redirectView.setUrl(externalUrl);
		} catch(Exception e) {
			return redirectView;
		}
		return redirectView;
	}
}