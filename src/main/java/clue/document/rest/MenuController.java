package clue.document.rest;

import clue.document.bean.Node;
import clue.document.config.GlobalVariable;
import clue.document.util.ReadFileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 导航栏
 *
 * @author Sun Shipeng
 * @date 2023-01-31 16:35
 */
@RestController
@RequestMapping("/menu")
public class MenuController {



    @PostMapping("/getTree")
    public List<Node> getTree(){
        return GlobalVariable.rootNodeList;
    }

    @GetMapping("/getContent/{id}")
    public String getContent(@PathVariable("id") Integer id) throws IOException {
        var aa = GlobalVariable.rootNodeMap.get(id);
        if (!aa.isDirectory()){
            return ReadFileUtils.readFileString(aa.getPath() + "/" + aa.getText());
        }
        return null;
    }

}
