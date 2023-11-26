package fr.webatrio.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class JobDto extends JobRequestDto {

	private Long id;
}
