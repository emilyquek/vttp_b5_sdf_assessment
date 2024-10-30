package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) throws IOException {

			File file = new File("task01","day.csv");
			Reader reader = new FileReader(file);
			BufferedReader breader = new BufferedReader(reader);

			Map<Integer, CsvEntry> allCsvEntries = new Hashtable<>();
			String line = "a";
			int lineNumber = 0;
			while (line != null) {
				line = breader.readLine();
				if (lineNumber == 0) {
					lineNumber++;
					continue;
				}
				if (line == null)
					break;
				String[] csvColumns = line.split(",");
				int season = Integer.parseInt(csvColumns[0]);
				int month = Integer.parseInt(csvColumns[1]);
				boolean holiday;
				if (Integer.parseInt(csvColumns[2]) == 1)  
					holiday = true;
				else holiday = false;
				int weekday = Integer.parseInt(csvColumns[3]);
				int weather = Integer.parseInt(csvColumns[4]);
				int casual = Integer.parseInt(csvColumns[8]);
				int registered = Integer.parseInt(csvColumns[9]);
				int total = casual + registered;

				CsvEntry ce = new CsvEntry(season, month, holiday, weekday, weather, total);
				allCsvEntries.put(total, ce);
		}
		breader.close();
		List<Integer> numOfCyclists = new ArrayList<>();
		numOfCyclists.addAll(allCsvEntries.keySet());
		Collections.sort(numOfCyclists, Collections.reverseOrder());
		
		String[] positions = {"highest", "second highest", "third highest", "fourth highest", "fifth highest"};

		for (int i = 0; i < 5; i++) {
			String position = positions[i];
			String season = Utilities.toSeason(allCsvEntries.get(numOfCyclists.get(i)).getSeason());
			String day = "";
			switch (allCsvEntries.get(numOfCyclists.get(i)).getWeekday()) {
				case 0:
					day = "Sunday";
					break;
				case 1:
					day = "Monday";
					break;
				case 2:
					day = "Tuesday";
					break;
				case 3:
					day = "Wednesday";
					break;
				case 4:
					day = "Thursday";
					break;
				case 5:
					day = "Friday";
					break;
				case 6:
					day = "Saturday";
					break;
			}
			String month = Utilities.toMonth(allCsvEntries.get(numOfCyclists.get(i)).getMonth());
			String weather = "";
			switch(allCsvEntries.get(numOfCyclists.get(i)).getWeather()) {
				case 1:
					weather = "Clear, Few clouds, Partly cloudy, Partly cloudy";
					break;
				case 2:
					weather = "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist";
					break;
				case 3:
					weather = "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds";
					break;
				case 4:
					weather = "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog";
					break;
			}
			String holiday = "";
			if (allCsvEntries.get(numOfCyclists.get(i)).isHoliday()) {
				holiday = "a holiday";
			} else {
				holiday = "not a holiday";
			}

			System.out.printf("The %s (position) recorded number of cyclists was in %s (season), on a %s (day) in the month of %s (month). There were a total of %d (total) cyclists. The weather was %s (weather). %s (day) was %s.\n\n", position, season, day, month, numOfCyclists.get(i), weather, day, holiday);
		}
	}	
}