package com.latam.desarrollo.bff.desarrolloBFF.entities;

import lombok.Data;

@Data
public class Poema {
	private String title;
	private String content;
	private String url;
	private Poeta poet;
}
