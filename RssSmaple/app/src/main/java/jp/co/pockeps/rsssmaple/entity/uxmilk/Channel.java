package jp.co.pockeps.rsssmaple.entity.uxmilk;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {
    @ElementList(name = "item", inline = true)
    public List<Item> items;
}
