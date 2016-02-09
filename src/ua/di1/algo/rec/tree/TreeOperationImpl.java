package ua.di1.algo.rec.tree;

import java.util.List;

/**
 * Created by serhii on 07.02.16.
 */
public class TreeOperationImpl implements TreeOperations {
    @Override
    public Integer getAmount(Link link) {
        if(link == null){
            return null;
        }

        int myRes = (Integer) link.getData();
        List<Link> children = link.getChildren();

        if(children == null || children.isEmpty()){
            return myRes;
        }

        int amount = 0;

        for (int i = 0; i < children.size(); i++) {
            Link child = children.get(i);
            int childRes = getAmount(child);
            amount += childRes;
        }


        return amount + myRes;
    }
}
