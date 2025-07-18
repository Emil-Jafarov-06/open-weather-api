package com.example.open_weather_api.service;

import com.example.open_weather_api.model.City;
import com.example.open_weather_api.model.Weather;
import com.example.open_weather_api.model.apiResponse.Root;
import com.example.open_weather_api.model.request.CityRequest;
import com.example.open_weather_api.repository.CityRepository;
import com.example.open_weather_api.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final CityRepository cityRepository;
    private  final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    public City addCity(CityRequest cityRequest) {
        City city = new City(null, cityRequest.getCityName(), cityRequest.getCountryName(), null);
        return cityRepository.save(city);
    }

    public Object getLatestInfo(String cityName) {
        List<Weather> weathers =  weatherRepository.getWeatherByCity_Name(cityName);
        if(!weathers.isEmpty()){
            return weathers.get(weathers.size() - 1);
        }
        else{
            return "No weather information found!";
        }
    }

    @Scheduled(cron = "0 0 * * * *")
    public void getWeatherInfoForCity(){
        List<City> cities= cityRepository.findAll();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=77d09da501b4123619e80ae0cee2f8ec&units=metric";

        for (City city:cities){
            String newUrl = url.formatted(city.getName());
            Root root = restTemplate.getForObject(newUrl, Root.class);
            if(root!=null){
                Weather weather = new Weather(null,
                        root.getMain().getTemp(),
                        root.getMain().getHumidity(),
                        root.getWeather().get(0).getDescription(),
                        LocalDateTime.now(),
                        city);
                city.addWeather(weather);
                weatherRepository.save(weather);
            }
        }
    }

    @Scheduled(cron = "0 0 */12 * * *")
    public void transferInfoIntoExcelFile() throws IOException {
        List<Weather> weatherList = weatherRepository.findAll();
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\Open_Weather_API\\src\\main\\resources\\ExcelFile.xlsx");
        System.out.println(file.exists());

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Weather_Data");

        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Temperature", "Humidity", "Description", "Timestamp", "City"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowIndex = 1;
        for (Weather weather : weatherList) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(weather.getId());
            row.createCell(1).setCellValue(weather.getTemperature());
            row.createCell(2).setCellValue(weather.getHumidity());
            row.createCell(3).setCellValue(weather.getDescription());
            row.createCell(4).setCellValue(weather.getTimestamp().toString());
            row.createCell(5).setCellValue(weather.getCity().getName());
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            workbook.write(outputStream);
        }

        workbook.close();

    }
}
