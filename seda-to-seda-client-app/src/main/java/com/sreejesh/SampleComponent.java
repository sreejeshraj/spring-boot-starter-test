package com.sreejesh;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "sc")
public class SampleComponent {

    private String scString;
    private List<Map<String, String>> endpointMapList;
}
