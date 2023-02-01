package clue.document.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 目录节点
 *
 * @author Sun Shipeng
 * @date 2023-01-31 15:20
 */
@Setter
@Getter
@Accessors(chain = true)
public class Node {


    private Integer id;

    private String text;

    private String path;

    private boolean isDirectory;

    private List<Node> nodes;

}
