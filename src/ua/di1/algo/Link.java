package ua.di1.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 07.02.16.
 */
public class Link implements TreeOperations{

    private Object data;
    private String desc;

    private List<Link> children;

    public Link(Object data, String desc) {
        this.data = data;
        this.desc = desc;
        this.children = new ArrayList<>();
    }

    public Link(Object data, String desc, Link...children) {
        this.data = data;
        this.desc = desc;
        this.children = Arrays.asList(children);
    }

    public void addChild(Link child){
        children.add(child);
    }

    public void setChildren(List<Link> children) {
        this.children = children;
    }

    // varags
    public void addAll(Link...links){
        Link[] mas = links;
        this.children = new ArrayList<>();

    }

    public Integer getAmount(Link link){
        int report = (int) link.data;
        for (Link child : link.children) {
            report += child.getAmount(child);
        }
        System.out.println(String.format("Worker: %s, report: %d" , desc, report));
        return report;
    }

    public int report() {
        int report = (int) data;
        for (Link link : children) {
            report += link.report();
        }
        System.out.println(String.format("Worker: %s, report: %d" , desc, report));
        return report;
    }
}
