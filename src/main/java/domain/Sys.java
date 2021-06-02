package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sys{
	private String country;
	private int sunrise;
	private int sunset;
	private int id;
	private int type;
}