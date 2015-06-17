package org.oncoblocks.magpie.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author woemler
 */

@Configuration
@ComponentScan(basePackages = { "org.oncoblocks.magpie.rest.service" })
public class ApplicationConfig {
}
