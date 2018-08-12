package dev.bcv.bootrepository;

import java.util.ArrayList;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Session session;

    @Autowired
    public Controller(final Session session) {
        this.session = session;
    }

    @GetMapping("/children")
    public String children(@QueryParam("q") String q) throws RepositoryException {
        NodeIterator nodes = session.getRootNode().getNodes(q+"*");
        ArrayList<String> children = new ArrayList<>();
        while (nodes.hasNext()) {
            children.add(nodes.nextNode().getPath());
        }
        return children.toString();
    }

    @GetMapping("/create")
    public String create(@QueryParam("q") String q) throws RepositoryException {
        session.getRootNode().addNode(q, "nt:unstructured");
        session.save();
        return session.getRootNode().getNode(q).getPath();
    }

    @GetMapping("/delete")
    public String delete(@QueryParam("q") String q) throws RepositoryException {
        Node node = session.getRootNode().getNode(q);
        node.remove();
        session.save();
        return children("");
    }

}
