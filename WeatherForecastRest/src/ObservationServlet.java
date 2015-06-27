

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.WeatherForecast.model.Location;
import com.ibm.WeatherForecast.model.Observation;
import com.ibm.WeatherForecast.services.WeatherForecastService;
import com.ibm.WeatherForecast.services.WeatherForecastServiceImpl;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class ObservationServlet
 */
@WebServlet({ "/Observation", "/Observation/*" })
public class ObservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String path = request.getPathInfo();
		if (null == path ) {
			out.print(printLocations());
			out.close();
			return;
		}
		path = path.substring(1);
		String[] tokens = path.split("[/]");
		try {
			WeatherForecastService WeatherForecastService = new WeatherForecastServiceImpl();
			
			Observation observation = WeatherForecastService.getObservation(Integer.parseInt(tokens[0]));
			if(observation != null){
				JSONObject jsonObservation = new JSONObject();
				jsonObservation.put("tempreture", observation.getTempreture());
				jsonObservation.put("weather", observation.getWeather());
				out.print(jsonObservation.toString());
			}else{
				JSONObject fault = new JSONObject();
				fault.put("message", "City location must be defined");
				out.print(fault.toString());
			}
			
			} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			JSONObject fault = new JSONObject();
			fault.put("message", e.getMessage());
			out.print(fault.toString());
			}
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String printLocations() {
		
		WeatherForecastService WeatherForecastService = new WeatherForecastServiceImpl();
		
		Set<Location>  locations = WeatherForecastService.getAllLocations();
		
		JSONArray jsonLocations = new JSONArray();

		for(Location location : locations) {
			
			JSONObject jsonLocation = new JSONObject();
			jsonLocation.put("id", location.getId());
			jsonLocation.put("city", location.getCity());
			jsonLocations.add(jsonLocation);
		}
		return jsonLocations.toString();
	}

}
