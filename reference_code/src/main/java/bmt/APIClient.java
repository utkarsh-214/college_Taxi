package bmt;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {
    public static void main(String[] args) {
        try {
            // Define the API URL
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=27.99&longitude=76.39&hourly=temperature_2m,rain"; // Replace with your API URL

            // Create a URL object and open a connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Open a BufferedReader to read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Read and append the response to a StringBuilder
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Save the JSON response to a file
                String jsonResponse = response.toString();
                String fileName = "response.json";
                try (FileWriter fileWriter = new FileWriter(fileName)) {
                    fileWriter.write(jsonResponse);
                }

                System.out.println("API response saved to " + fileName);
            } else {
                System.out.println("HTTP Error: " + responseCode);
            }

            // Close the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}