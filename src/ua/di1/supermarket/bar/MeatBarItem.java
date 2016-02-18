package ua.di1.supermarket.bar;

import ua.di1.supermarket.animal.BodyPart;

/**
 * Created by I on 2016-02-18.
 * A packaged meat part which can be placed on the bar, reviewed by user and sold to user. Extends general BarItem
 * which is a general class for any items that could be placed on a bar.
 */
public class MeatBarItem extends BarItem {
    BodyPart bodyPart = null;
}
