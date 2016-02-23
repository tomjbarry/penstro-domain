package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class ImageLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7913244944468409375L;
	public static final String LINK = SharedFields.LINK;
	public static final String WIDTH = SharedFields.WIDTH;
	public static final String HEIGHT = SharedFields.HEIGHT;
	
	@Field(LINK)
	private String link;
	@Field(WIDTH)
	private Integer width;
	@Field(HEIGHT)
	private Integer height;
	
	public ImageLink() {
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
}
