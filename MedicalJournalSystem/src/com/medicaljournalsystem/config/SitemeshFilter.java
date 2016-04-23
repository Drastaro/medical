package com.medicaljournalsystem.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshFilter extends ConfigurableSiteMeshFilter {

	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/decorators/dashboardtheme")
				// the URL for the exclude
				.addExcludedPath("/adduser").addExcludedPath("/login");

	}

}
