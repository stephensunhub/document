package clue.document.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 扫描的目录
 *
 * @author Sun Shipeng
 * @date 2023-01-31 15:00
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "menu")
public class Menu {


    private String root;

    private String project;

}
