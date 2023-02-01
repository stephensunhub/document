package clue.document;

import clue.document.bean.Node;
import clue.document.config.GlobalVariable;
import clue.document.config.Menu;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 初始化
 *
 * @author Sun Shipeng
 * @date 2023-01-31 14:41
 */
@Order(Integer.MIN_VALUE)
@Slf4j
@Component
public class ScanMenuTree implements CommandLineRunner {


    private AtomicInteger ai = new AtomicInteger();

    private final Menu menu;

    public ScanMenuTree(Menu menu) {
        this.menu = menu;
    }


    @Override
    public void run(String... args) {
        log.info("开始加载文件目录");
        var path = menu.getRoot() + "/" + menu.getProject();
        readRoot(path, menu.getProject());
    }


    @SneakyThrows
    private void readRoot(String rootPath, String rootName){
        File rootDic = ResourceUtils.getFile("classpath:" + rootPath);
        Node rootNode = new Node();
        rootNode.setId(ai.getAndIncrement());
        rootNode.setText(rootName);
        rootNode.setDirectory(true);
        rootNode.setNodes(new LinkedList<>());
        rootNode.setPath(rootPath);
        readFolder(rootDic, rootNode);
        GlobalVariable.rootNodeList = rootNode.getNodes();
    }

    @SneakyThrows
    private void readFolder(File path, Node node){
        var childList = path.listFiles();
        assert childList != null;
        for (File file : childList) {
            Node childNode;
            if (file.isDirectory()){
                childNode = factory(path.getPath(), file.getName(), true);
                readFolder(file, childNode);
            }else {
                childNode = factory(path.getPath(), file.getName(), false);
            }
            node.getNodes().add(childNode);
            GlobalVariable.rootNodeMap.put(childNode.getId(), childNode);
        }
    }

    private Node factory(String path, String name, Boolean isDirectory){
        var id = ai.getAndIncrement();
        Node node = new Node()
                .setId(id)
                .setText(name)
                .setPath(path)
                .setDirectory(isDirectory);
        if (isDirectory){
            node.setNodes(new LinkedList<>());
        }
        return node;
    }
}
