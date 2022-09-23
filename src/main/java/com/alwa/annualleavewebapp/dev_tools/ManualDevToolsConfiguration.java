package com.alwa.annualleavewebapp.dev_tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LocalDevToolsAutoConfiguration.class, DevToolsDataSourceAutoConfiguration.class})
public class ManualDevToolsConfiguration {

}
