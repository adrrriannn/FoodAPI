package foodAPI;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;

import com.london.food.controller.HomeController;
import com.london.food.mappers.PizzaPlaceJson;
import com.london.food.response.ErrorResponse;
import com.london.food.response.PizzaResponse;
import com.london.food.response.Response;
import com.london.food.service.PizzaPlaceAPIService;
import com.london.food.validator.PostCodeValidator;
	

public class HomeControllerTest {
	
	@Spy
	private HomeController homeController;
	@Mock
	private PizzaPlaceAPIService pizzaService;
	@Spy
	private PostCodeValidator postCodeValidator;
	
	private final ErrorResponse INVALID_POSTCODE_RESPONSE = getInvalidPostcodeResponse();
	private final ErrorResponse EMPTY_POSTCODE_RESPONSE = getEmptyPostcodeResponse();
	private final PizzaPlaceJson EXPECTED_PIZZA_LIST = getSuccessPizzaPlaceJson();
	
	@Before
	public void setUp() throws IllegalArgumentException, IllegalAccessException {
		
		MockitoAnnotations.initMocks(this);
		
		PowerMockito.field(HomeController.class, "pizzaPlaceAPIService")
			.set(homeController, pizzaService);
		PowerMockito.field(HomeController.class, "postCodeValidator")
		.set(homeController, postCodeValidator);
	}
	
	@Test
	public void homeTestSuccess() {
		PowerMockito.doReturn(EXPECTED_PIZZA_LIST).
		when(pizzaService).readFromUrl(Matchers.any());
		
		
		PizzaResponse json = (PizzaResponse) homeController.pizza("W127BW");
		Assert.assertTrue(Objects.equals(EXPECTED_PIZZA_LIST, json.getPizzaJson()));
	}
	
	@Test
	public void homeTestFailureInvalidPostCode() {

		Response json = homeController.pizza("W12BW123456");
		Assert.assertTrue(Objects.equals(INVALID_POSTCODE_RESPONSE, json));
	}
	
	@Test
	public void homeTestFailureEmptyPostCode() {

		Response json = homeController.pizza("");
		Assert.assertTrue(Objects.equals(EMPTY_POSTCODE_RESPONSE, json));
	}
	
	private PizzaPlaceJson getSuccessPizzaPlaceJson() {
		
		return new PizzaPlaceJson();
	}
	
	private ErrorResponse getInvalidPostcodeResponse(){

		return new ErrorResponse(false, PostCodeValidator.ERROR_INVALID_POSTCODE);
	}
	
	private ErrorResponse getEmptyPostcodeResponse(){
		
		return new ErrorResponse(false,PostCodeValidator.ERROR_EMPTY_POSTCODE);
	}
}
