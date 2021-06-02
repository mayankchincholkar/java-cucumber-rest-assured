package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Main{
	private double temp;
	@JsonProperty("temp_min")
	private double tempMin;
	private int humidity;
	private int pressure;
	@JsonProperty("feels_like")
	private double feelsLike;
	@JsonProperty("temp_max")
	private double tempMax;
}